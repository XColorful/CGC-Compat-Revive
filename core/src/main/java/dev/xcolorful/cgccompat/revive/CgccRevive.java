package dev.xcolorful.cgccompat.revive;

import com.mojang.logging.LogUtils;
import dev.xcolorful.cgccompat.revive.core.config.CgccReviveConfig;
import dev.xcolorful.customgun.core.api.common.McSide;
import org.jetbrains.annotations.ApiStatus;
import org.slf4j.Logger;

import java.nio.file.Path;

public class CgccRevive {
    public static final String MOD_ID = "cgccrevive";
    public static final Logger LOGGER = LogUtils.getLogger();

    protected static boolean initialized;

    /**
     * 配置文件名，位于平台的 config 目录下
     */
    public static final String FILE_NAME = MOD_ID + ".json";

    /**
     * 游戏根目录，用于解析配置中的相对路径
     */
    private static Path gameDirectory;

    /**
     * 配置根目录，用于解析配置中的相对路径
     */
    private static Path configDirectory;

    /**
     * 模组配置文件的绝对路径
     */
    private static Path configFile;

    public static void init(McSide mcSide,
                            Path gameDirectory, Path configDirectory) {
        if (initialized) return;

        CgccRevive.gameDirectory = gameDirectory;
        CgccRevive.configDirectory = configDirectory;
        CgccRevive.configFile = configDirectory.resolve(FILE_NAME);

        CgccRevive.reloadConfig();

        initialized = true;
    }

    /**
     * 重新从磁盘读取配置
     */
    @ApiStatus.Internal
    public static void reloadConfig() {
        if (configFile == null) return;
        CgccReviveConfig.INSTANCE.load(configFile);
    }

    /**
     * 把配置写回磁盘
     */
    @ApiStatus.Internal
    public static void saveConfig() {
        if (configFile == null) return;
        CgccReviveConfig.INSTANCE.save(configFile);
    }

    /**
     * @return 游戏根目录
     */
    public static Path gameDirectory() {
        return gameDirectory;
    }

    /**
     * @return 配置根目录
     */
    public static Path configDirectory() {
        return configDirectory;
    }

    /**
     * @return 模组配置文件的绝对路径
     */
    public static Path configFile() {
        return configFile;
    }
}
