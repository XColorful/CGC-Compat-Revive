package dev.xcolorful.cgccompat.revive.core.config;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dev.xcolorful.cgccompat.revive.CgccRevive;
import dev.xcolorful.cgccompat.revive.core.api.config.CgccReviveConfigTag;
import dev.xcolorful.customgun.core.util.JsonUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CgccReviveConfig {
    public static final CgccReviveConfig INSTANCE = new CgccReviveConfig();

    // --------默认值--------

    private static final boolean DEFAULT_DISABLE_BLEEDING_SHOOT = true;
    private static final boolean DEFAULT_DISABLE_BLEEDING_RELOAD = true;
    private static final boolean DEFAULT_DISABLE_BLEEDING_SWITCH_FIRE_MODE = true;
    private static final boolean DEFAULT_DISABLE_BLEEDING_MELEE = true;

    public boolean disableBleedingShoot = DEFAULT_DISABLE_BLEEDING_SHOOT;
    public boolean disableBleedingReload = DEFAULT_DISABLE_BLEEDING_RELOAD;
    public boolean disableBleedingSwitchFireMode = DEFAULT_DISABLE_BLEEDING_SWITCH_FIRE_MODE;
    public boolean disableBleedingMelee = DEFAULT_DISABLE_BLEEDING_MELEE;

    protected CgccReviveConfig() {
    }

    /**
     * 从配置目录加载配置；文件不存在时按默认值创建。
     *
     * @param configFile 配置文件的绝对路径
     */
    public void load(Path configFile) {
        if (Files.exists(configFile)) {
            try (JsonReader reader = new JsonReader(Files.newBufferedReader(configFile, StandardCharsets.UTF_8))) {
                _read(reader);
            } catch (IOException | RuntimeException exception) {
                CgccRevive.LOGGER.error("Failed to read config file {}, using defaults", configFile, exception);
            }
        }

        save(configFile);
    }

    /**
     * 把配置按固定顺序回写，便于使用者直接编辑。
     *
     * @param configFile 配置文件的绝对路径
     */
    public void save(Path configFile) {
        try {
            Path parent = configFile.getParent();
            if (parent != null) Files.createDirectories(parent);

            try (JsonWriter writer = new JsonWriter(Files.newBufferedWriter(configFile, StandardCharsets.UTF_8))) {
                writer.setIndent("\t");
                writer.beginObject(); {
                    JsonUtils.writeBoolean(writer, CgccReviveConfigTag.DISABLE_BLEEDING_SHOOT, disableBleedingShoot);
                    JsonUtils.writeBoolean(writer, CgccReviveConfigTag.DISABLE_BLEEDING_RELOAD, disableBleedingReload);
                    JsonUtils.writeBoolean(writer, CgccReviveConfigTag.DISABLE_BLEEDING_SWITCH_FIRE_MODE, disableBleedingSwitchFireMode);
                    JsonUtils.writeBoolean(writer, CgccReviveConfigTag.DISABLE_BLEEDING_MELEE, disableBleedingMelee);
                }
                writer.endObject();
            }
        } catch (IOException exception) {
            CgccRevive.LOGGER.error("Failed to write config file {}", configFile, exception);
        }
    }

    private void _read(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            switch (reader.nextName()) {
                case CgccReviveConfigTag.DISABLE_BLEEDING_SHOOT -> disableBleedingShoot = JsonUtils.readBoolean(reader);
                case CgccReviveConfigTag.DISABLE_BLEEDING_RELOAD -> disableBleedingReload = JsonUtils.readBoolean(reader);
                case CgccReviveConfigTag.DISABLE_BLEEDING_SWITCH_FIRE_MODE -> disableBleedingSwitchFireMode = JsonUtils.readBoolean(reader);
                case CgccReviveConfigTag.DISABLE_BLEEDING_MELEE -> disableBleedingMelee = JsonUtils.readBoolean(reader);
                default -> reader.skipValue();
            }
        }
        reader.endObject();
    }
}
