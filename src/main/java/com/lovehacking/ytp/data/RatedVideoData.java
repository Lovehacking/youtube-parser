package com.lovehacking.ytp.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RatedVideoData extends VideoData {
    private Integer rate;

    public RatedVideoData(VideoData videoData, Integer rate) {
        setTitle(videoData.getTitle());
        setViewCount(videoData.getViewCount());
        setMonthAge(videoData.getMonthAge());
        setRate(rate);
    }


    @Override
    public String toString() {
        return rate + " - " + getTitle();
    }
}


