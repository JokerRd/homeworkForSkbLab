package ru.skblab.broker.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AppProperties {
    @Setter
    @Getter
    private String topicRequest;

    @Setter
    @Getter
    private String topicReply;

    @Setter
    @Getter
    private String groupId;
}
