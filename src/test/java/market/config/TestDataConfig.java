package market.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:test.properties",
})
public interface TestDataConfig extends Config {
    @DefaultValue("moderator@codevie.kz")
    String email();

    @DefaultValue("TeSt0vIyPaS5")
    String password();
}
