package ru.skblab.configandevents.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import ru.skblab.configandevents.models.ConfigUserModel;



@Getter
@Setter
@ConfigurationProperties(prefix = "app")
public class SimpleConfig {
    private String firstConfig;
    private ConfigUserModel secondConfig;

    @Override
    public String toString() {
        String subconfig = secondConfig.getSubconfig();
        String user = secondConfig.getUser();
        String ttl = secondConfig.getTtl().getSeconds() + "s";
        return String.format(
                "first-config: %s%n" +
                        "second-config: %n" +
                        "  subconfig: %s%n" +
                        "  user: %s%n" +
                        "  ttl: %s",
                firstConfig, subconfig, user, ttl);
    }
}
