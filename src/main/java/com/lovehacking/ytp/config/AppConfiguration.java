package com.lovehacking.ytp.config;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.lovehacking.ytp.data.VideoData;
import com.lovehacking.ytp.processor.*;
import com.lovehacking.ytp.searcher.ChannelVideoSearcher;
import com.lovehacking.ytp.searcher.ChannelVideoSearcherImpl;
import com.lovehacking.ytp.searcher.VideoStatisticSearcher;
import com.lovehacking.ytp.searcher.VideoStatisticSearcherImpl;
import com.lovehacking.ytp.searcher.utils.Converter;
import com.lovehacking.ytp.searcher.utils.VideoConverter;
import com.lovehacking.ytp.utils.YouTubeServiceProvider;
import lombok.SneakyThrows;

public class AppConfiguration {

    public ConfigService configService() {
        return new ConfigService();
    }

    @SneakyThrows
    public YouTube youTube() {
        YouTubeServiceProvider youTubeProvider = new YouTubeServiceProvider(configService());
        return youTubeProvider.getService();
    }

    public Converter<VideoData, Video> videoConverter() {
        return new VideoConverter();
    }

    public ChannelVideoSearcher channelVideoSearcher() {
        return new ChannelVideoSearcherImpl(youTube(), configService());
    }

    public VideoStatisticSearcher videoStatisticSearcher() {
        return new VideoStatisticSearcherImpl(youTube(), videoConverter(), configService());
    }

    public VideoAnalyzer videoAnalyzer() {
        return new VideoAnalyzerImpl();
    }

    public ChannelVideoAnalyzer channelVideoAnalyzer() {
        return new ChannelVideoAnalyzerImpl(channelVideoSearcher(), videoStatisticSearcher(), videoAnalyzer());
    }

    public VideoComposer videoComposer() {
        return new VideoComposerImpl(channelVideoAnalyzer());
    }

}
