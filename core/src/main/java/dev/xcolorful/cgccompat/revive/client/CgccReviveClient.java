package dev.xcolorful.cgccompat.revive.client;

import dev.xcolorful.cgccompat.revive.CgccRevive;
import dev.xcolorful.cgccompat.revive.client.config.CgccReviveClientConfig;
import org.jetbrains.annotations.ApiStatus;

import java.nio.file.Path;

public class CgccReviveClient {

    protected static boolean initialized;

    /**
     * 配置文件名，位于平台的 config 目录下
     */
    public static final String FILE_NAME = CgccRevive.MOD_ID + "-client" + ".json";

    /**
     * 模组配置文件的绝对路径
     */
    private static Path configFile;

    public static void init() {
        if (initialized) return;

        CgccReviveClient.configFile = CgccRevive.configDirectory().resolve(FILE_NAME);

        CgccReviveClient.reloadConfig();

        initialized = true;
    }

    /**
     * 重新从磁盘读取配置
     */
    @ApiStatus.Internal
    public static void reloadConfig() {
        if (configFile == null) return;
        CgccReviveClientConfig.INSTANCE.load(configFile);
    }

    /**
     * 把配置写回磁盘
     */
    @ApiStatus.Internal
    public static void saveConfig() {
        if (configFile == null) return;
        CgccReviveClientConfig.INSTANCE.save(configFile);
    }

    /**
     * @return 模组配置文件的绝对路径
     */
    public static Path configFile() {
        return configFile;
    }
}
