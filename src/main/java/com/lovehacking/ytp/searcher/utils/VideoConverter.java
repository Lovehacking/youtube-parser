package com.lovehacking.ytp.searcher.utils;

import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.model.Video;
import com.lovehacking.ytp.data.VideoData;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class VideoConverter implements Converter<VideoData, Video> {

    private static final Integer MINIMAL_AGE = 1;

    @Override
    public VideoData convert(Video video) {
        return new VideoData(
                video.getSnippet().getTitle(),
                video.getStatistics().getViewCount(),
                calculateVideoAge(video.getSnippet().getPublishedAt())
        );
    }

    private Integer calculateVideoAge(DateTime publishedAt) {
        LocalDate now = LocalDate.now();
        LocalDate videoPublishingDate = Instant.ofEpochMilli(publishedAt.getValue()).atZone(ZoneId.systemDefault()).toLocalDate();

        Period period = Period.between(now, videoPublishingDate);
        int age = Math.abs(period.getYears() * 12 + period.getMonths());
        return Math.max(MINIMAL_AGE, age);
    }
}
