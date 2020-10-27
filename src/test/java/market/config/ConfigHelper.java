package market.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getBaseURL() {
        return getConfig().baseURL();
    }

    public static String getBasePath() {
        return getConfig().basePath();
    }

    public static String getEmail() {
        return getDataConfig().email();
    }

    public static String getPassword() {
        return getDataConfig().password();
    }

    private static ApiConfig getConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class);
    }

    private static TestDataConfig getDataConfig() {
        return ConfigFactory.newInstance().create(TestDataConfig.class);
    }
}
