package com.lovehacking.ytp.searcher;

import com.lovehacking.ytp.data.VideoData;

import java.util.List;

public interface VideoStatisticSearcher {
    List<VideoData> videoData (List<String> videoIds);
}
