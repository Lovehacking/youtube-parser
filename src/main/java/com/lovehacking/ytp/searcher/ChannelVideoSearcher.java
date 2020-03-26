package com.lovehacking.ytp.searcher;

import com.google.api.services.youtube.model.Channel;
import lombok.SneakyThrows;

import java.math.BigInteger;
import java.util.List;

public interface ChannelVideoSearcher {
    @SneakyThrows
    Channel findById(String channelId);

    List<String> videoIds (String channelId);

    BigInteger channelSubscribers(String channelId);
}
