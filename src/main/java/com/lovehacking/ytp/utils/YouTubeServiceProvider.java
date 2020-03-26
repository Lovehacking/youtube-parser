package com.lovehacking.ytp.utils;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.youtube.YouTube;
import com.lovehacking.ytp.config.ConfigService;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.security.GeneralSecurityException;

@AllArgsConstructor
public class YouTubeServiceProvider {

    private final ConfigService configs;

    public YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, configs.jsonFactory(), null)
                .setApplicationName(configs.applicationName())
                .build();
    }
}
