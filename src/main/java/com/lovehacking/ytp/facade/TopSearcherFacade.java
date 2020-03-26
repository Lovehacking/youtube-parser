package com.lovehacking.ytp.facade;

import com.lovehacking.ytp.config.ChannelsType;
import com.lovehacking.ytp.data.RatedVideoData;

import java.util.List;

public interface TopSearcherFacade {
    List<RatedVideoData> findTopForChannels(ChannelsType type, Integer topLimit);
}
