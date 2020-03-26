package com.lovehacking.ytp;

import com.lovehacking.ytp.config.AppConfiguration;
import com.lovehacking.ytp.config.ChannelsType;
import com.lovehacking.ytp.data.RatedVideoData;
import com.lovehacking.ytp.facade.TopSearcherFacade;
import com.lovehacking.ytp.facade.TopSearcherFacadeImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AppConfiguration app = new AppConfiguration();
        TopSearcherFacade topSearcherFacade = new TopSearcherFacadeImpl(app);

        List<RatedVideoData> top = topSearcherFacade.findTopForChannels(ChannelsType.ALL, 20);

        top.forEach(System.out::println);
    }
}