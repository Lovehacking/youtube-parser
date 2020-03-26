package com.lovehacking.ytp.processor;

import com.lovehacking.ytp.data.RatedVideoData;
import com.lovehacking.ytp.data.VideoData;
import com.lovehacking.ytp.utils.RatedVideoComparator;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class VideoAnalyzerImpl implements VideoAnalyzer {
    private final BigInteger FULL_PERCENTS = BigInteger.valueOf(100L);
    private final BigInteger RATE_COEFFICIENT = BigInteger.TEN;


    @Override
    public List<RatedVideoData> rateTop20(List<VideoData> channelVideos, BigInteger subscribersCount) {
        return channelVideos.parallelStream()
                .map(video -> new RatedVideoData(video, rate(video, subscribersCount)))
                .sorted(new RatedVideoComparator())
                .limit(20)
                .collect(Collectors.toList());
    }

    private Integer rate(VideoData video, BigInteger subscribersCount) {
        return calculateViewCoefficient(video.getViewCount(), subscribersCount).multiply(RATE_COEFFICIENT)
                .divide(BigInteger.valueOf(video.getMonthAge())).intValue();
    }

    private BigInteger calculateViewCoefficient(BigInteger viewCount, BigInteger subscribersCount) {
        return FULL_PERCENTS
                .multiply(viewCount)
                .divide(subscribersCount);
    }
}
