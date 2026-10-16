package dev.xcolorful.cgccompat.revive.forgeclient;

import dev.xcolorful.cgccompat.revive.client.CgccReviveClient;

public class CgccReviveForgeClient {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        CgccReviveClient.init();

        initialized = true;
    }
}
