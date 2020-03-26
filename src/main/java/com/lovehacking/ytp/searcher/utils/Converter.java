package com.lovehacking.ytp.searcher.utils;

public interface Converter<R,D> {
    R convert(D data);
}
