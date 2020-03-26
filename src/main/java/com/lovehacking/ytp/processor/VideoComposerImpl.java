package com.lovehacking.ytp.processor;

import com.lovehacking.ytp.data.RatedVideoData;
import com.lovehacking.ytp.utils.RatedVideoComparator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class VideoComposerImpl implements VideoComposer {
    private final ChannelVideoAnalyzer channelVideoAnalyzer;

    @Override
    public List<RatedVideoData> getChannelsTopVideos(List<String> channels, Integer limit) {
        return channels.stream()
                .flatMap(channelVideoAnalyzer::rateChannelTop20)
                .sorted(new RatedVideoComparator())
                .limit(limit)
                .collect(Collectors.toList());
    }
}
