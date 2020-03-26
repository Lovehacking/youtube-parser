package com.lovehacking.ytp.facade;

import com.lovehacking.ytp.config.AppConfiguration;
import com.lovehacking.ytp.config.ChannelsType;
import com.lovehacking.ytp.data.RatedVideoData;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TopSearcherFacadeImpl implements TopSearcherFacade {
    private final AppConfiguration app;

    @Override
    public List<RatedVideoData> findTopForChannels(ChannelsType type, Integer topLimit) {

        List<String> channels = app.configService().channels(type);

        return app.videoComposer().getChannelsTopVideos(channels, topLimit);
    }
}
