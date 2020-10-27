package market.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"
})
public interface ApiConfig extends Config {
    @DefaultValue("https://api.dev.vlife.kz")
    String baseURL();

    @DefaultValue("/market/core")
    String basePath();
}

