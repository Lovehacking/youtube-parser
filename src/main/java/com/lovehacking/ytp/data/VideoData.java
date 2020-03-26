package com.lovehacking.ytp.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VideoData {
    private String title;
    private BigInteger viewCount;
    private Integer monthAge;
}
