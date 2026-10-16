package dev.xcolorful.cgccompat.revive.neoforgeclient;

import dev.xcolorful.cgccompat.revive.client.CgccReviveClient;

public class CgccReviveNeoforgeClient {

    protected static boolean initialized;

    public static void init() {
        if (initialized) return;

        CgccReviveClient.init();

        initialized = true;
    }
}
