package com.lovehacking.ytp.processor;

import com.lovehacking.ytp.data.RatedVideoData;
import com.lovehacking.ytp.data.VideoData;
import com.lovehacking.ytp.searcher.ChannelVideoSearcher;
import com.lovehacking.ytp.searcher.VideoStatisticSearcher;
import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
public class ChannelVideoAnalyzerImpl implements ChannelVideoAnalyzer {
    private final ChannelVideoSearcher channelVideoSearcher;
    private final VideoStatisticSearcher videoStatisticSearcher;
    private final VideoAnalyzer videoAnalyzer;

    @Override
    public Stream<RatedVideoData> rateChannelTop20(String channelId) {
            List<String> videoIds = channelVideoSearcher.videoIds(channelId);
            List<VideoData> videoData = videoStatisticSearcher.videoData(videoIds);
            BigInteger subscribersCount = channelVideoSearcher.channelSubscribers(channelId);

            return videoAnalyzer.rateTop20(videoData, subscribersCount).stream();
    }
}
