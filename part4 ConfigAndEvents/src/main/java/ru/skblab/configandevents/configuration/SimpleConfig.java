package ru.skblab.configandevents.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Map;


@Getter
@Setter
@ConfigurationProperties(prefix = "app")
public class SimpleConfig {
    private String firstConfig;
    private Map<String, String> secondConfig;

    @Override
    public String toString() {
        String subconfig = secondConfig.get("subconfig");
        String user = secondConfig.get("user");
        String ttl = secondConfig.get("ttl");
        return String.format(
                "first-config: %s%n" +
                        "second-config: %n" +
                        "  subconfig: %s%n" +
                        "  user: %s%n" +
                        "  ttl: %s",
                firstConfig, subconfig, user, ttl);
    }
}
