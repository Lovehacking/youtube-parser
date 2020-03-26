package com.lovehacking.ytp.processor;

import com.lovehacking.ytp.data.RatedVideoData;
import com.lovehacking.ytp.data.VideoData;

import java.math.BigInteger;
import java.util.List;

public interface VideoAnalyzer {
    List<RatedVideoData> rateTop20(List<VideoData> channelVideos, BigInteger subscribersCount);
}
