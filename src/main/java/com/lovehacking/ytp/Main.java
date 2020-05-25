package com.lovehacking.ytp;

import com.lovehacking.ytp.config.AppConfiguration;
import com.lovehacking.ytp.config.ChannelsType;
import com.lovehacking.ytp.data.RatedVideoData;
import com.lovehacking.ytp.facade.TopSearcherFacade;
import com.lovehacking.ytp.facade.TopSearcherFacadeImpl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) {
        AppConfiguration app = new AppConfiguration();
        TopSearcherFacade topSearcherFacade = new TopSearcherFacadeImpl(app);

        System.out.println("TOP 50 RU");
        List<RatedVideoData> topRU = topSearcherFacade.findTopForChannels(ChannelsType.RU, 50);
        AtomicInteger i = new AtomicInteger(1);
        topRU.forEach(video -> System.out.println(i.getAndIncrement() + ") " + video.toString()));

        System.out.println("\nTOP 50 EN");
        List<RatedVideoData> topEN = topSearcherFacade.findTopForChannels(ChannelsType.EN, 50);
        AtomicInteger in = new AtomicInteger(1);
        topEN.forEach(video -> System.out.println(in.getAndIncrement() + ") " + video.toString()));
    }
}