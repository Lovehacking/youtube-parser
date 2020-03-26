package com.lovehacking.ytp.searcher;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import com.lovehacking.ytp.config.ConfigService;
import com.lovehacking.ytp.exception.ChannelNotFoundException;
import com.lovehacking.ytp.exception.ChannelVideosNotFoundException;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ChannelVideoSearcherImpl implements ChannelVideoSearcher {
    private final YouTube service;
    private final ConfigService configs;

    @Override
    public Channel findById(String channelId) {
        try {
            YouTube.Channels.List request = service.channels()
                    .list("statistics");

            ChannelListResponse response = request.setKey(configs.apiKey())
                    .setId(channelId)
                    .setFields("items")
                    .execute();

            return response.getItems().stream().findFirst()
                    .orElseThrow(() -> new ChannelNotFoundException("Channel with id " + channelId + " not found."));
        } catch (IOException e) {
            throw new ChannelNotFoundException(e.getMessage());
        }
    }

    @Override
    public List<String> videoIds(String channelId) {
        try {
            YouTube.Search.List request = service.search()
                    .list("snippet");

            SearchListResponse response = request.setKey(configs.apiKey())
                    .setChannelId(channelId)
                    .setType("video")
                    .setFields("items")
                    .setOrder("viewCount")
                    .setMaxResults(50L)
                    .execute();

            return response.getItems().stream()
                    .map(it -> it.getId().getVideoId())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new ChannelVideosNotFoundException(e.getMessage());
        }
    }

    @Override
    public BigInteger channelSubscribers(String channelId) {
        Channel channel = findById(channelId);
        BigInteger subscriberCount = channel.getStatistics().getSubscriberCount();


        if (subscriberCount.equals(BigInteger.ZERO)) {
            throw new RuntimeException("CHANNEL " + channel.getSnippet().getTitle() + "with id '" + channelId + "' has 0 subscribers");
        }
        return subscriberCount;
    }
}
