package dev.xcolorful.cgccompat.revive.client;

public class CgccReviveClient {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        initialized = true;
    }
}
