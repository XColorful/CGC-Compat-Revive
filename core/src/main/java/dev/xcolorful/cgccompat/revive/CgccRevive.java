package dev.xcolorful.cgccompat.revive;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class CgccRevive {
    public static final String MOD_ID = "cgccrevive";
    public static final Logger LOGGER = LogUtils.getLogger();

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        initialized = true;
    }
}
