package app.utils;

import app.config.Config;

public class CheckJavaVersion {

    public static boolean checkRunIsAllow () {
        int currentVersion = getVersion();
        return currentVersion >= Config.ALLOW_VERSION;
    }

    private static int getVersion() {
            String version = System.getProperty("java.version");
            String[] split = version.split("[._]");
            if (split[0].equals("1")) {
                return Integer.parseInt(split[1]);
            }
            return Integer.parseInt(split[0]);
    }
}
