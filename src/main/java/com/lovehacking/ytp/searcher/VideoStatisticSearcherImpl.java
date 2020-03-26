package com.lovehacking.ytp.searcher;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.lovehacking.ytp.config.ConfigService;
import com.lovehacking.ytp.data.VideoData;
import com.lovehacking.ytp.exception.VideoDataNotFoundException;
import com.lovehacking.ytp.searcher.utils.Converter;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
public class VideoStatisticSearcherImpl implements VideoStatisticSearcher {
    private final YouTube service;
    private final Converter<VideoData, Video> converter;
    private final ConfigService configs;
    private final static String RESOURCE_PROPERTIES = "statistics, snippet";

    @Override
    public List<VideoData> videoData(List<String> videoIds) {
        try {
            YouTube.Videos.List videosReq = service.videos()
                    .list(RESOURCE_PROPERTIES);

            String ids = String.join(",", videoIds);
            VideoListResponse videosResp = videosReq.setKey(configs.apiKey())
                    .setId(ids)
                    .execute();

            return videosResp.getItems().stream()
                    .map(converter::convert)
                    .sorted((v1, v2) -> v2.getViewCount().subtract(v1.getViewCount()).intValue())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new VideoDataNotFoundException(e.getMessage());
        }


    }


}
