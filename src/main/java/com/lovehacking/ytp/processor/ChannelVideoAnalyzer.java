package com.lovehacking.ytp.processor;

import com.lovehacking.ytp.data.RatedVideoData;

import java.util.stream.Stream;

public interface ChannelVideoAnalyzer {
    Stream<RatedVideoData> rateChannelTop20(String channelId);
}
