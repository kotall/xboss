package com.github.kotall.shortlink.service;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Service
public class ShortLinkService {

    private Map<String, String> shortUrlMapping = Maps.newConcurrentMap();

    public String getOriginUrl(String shortUrl) {
//        return "https://blog.csdn.net/is_zhoufeng/article/details/26503725";
        String originUrl = this.shortUrlMapping.get(shortUrl);
        try {
            return URLDecoder.decode(originUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveShortUrl(String shortUrl, String decodeUrl) {
        this.shortUrlMapping.put(shortUrl, decodeUrl);
    }
}
