package com.lovehacking.ytp.processor;

import com.lovehacking.ytp.data.RatedVideoData;

import java.util.List;

public interface VideoComposer {
    List<RatedVideoData> getChannelsTopVideos(List<String> channels, Integer limit);
}
