package com.lovehacking.ytp.utils;

import com.lovehacking.ytp.data.RatedVideoData;

import java.util.Comparator;

public class RatedVideoComparator implements Comparator<RatedVideoData> {
    @Override
    public int compare(RatedVideoData v1, RatedVideoData v2) {
        return v2.getRate() - v1.getRate();
    }
}
