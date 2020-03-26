package com.lovehacking.ytp.config;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.List;

import static com.lovehacking.ytp.config.ChannelsType.*;

public class ConfigService {
    private Config defaultConfig = ConfigFactory.parseResources("default.conf");

    public String apiKey() {
        return defaultConfig.getString("conf.apiKey");
    }

    public String applicationName() {
        return defaultConfig.getString("conf.applicationName");
    }

    public JsonFactory jsonFactory() {
        return JacksonFactory.getDefaultInstance();
    }

    public List<String> channels(ChannelsType channelsType) {
        if (ALL == channelsType) {
            List<String> ru = channelsByType(RU);
            ru.addAll(channelsByType(EN));
            return ru;
        }
        return channelsByType(channelsType);
    }

    private List<String> channelsByType(ChannelsType channelsType) {
        return defaultConfig.getStringList("channels." + channelsType.name().toLowerCase());
    }
}
