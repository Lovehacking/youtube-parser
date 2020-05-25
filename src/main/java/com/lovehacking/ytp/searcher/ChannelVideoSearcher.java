package com.lovehacking.ytp.searcher;

import com.google.api.services.youtube.model.Channel;

import java.math.BigInteger;
import java.util.List;

public interface ChannelVideoSearcher {
    Channel findById(String channelId);

    List<String> videoIds (String channelId);

    BigInteger channelSubscribers(String channelId);
}
