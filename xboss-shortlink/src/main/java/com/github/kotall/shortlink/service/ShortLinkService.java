package com.github.kotall.shortlink.service;

import com.github.kotall.shortlink.dal.ShortLinkDO;
import com.github.kotall.shortlink.dal.ShortLinkRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

@Service
public class ShortLinkService {

    @Resource
    private ShortLinkRepository shortLinkRepository;
    //private Map<String, String> shortUrlMapping = Maps.newConcurrentMap();

    public String getOriginUrl(String shortUrl) {
//        return "https://blog.csdn.net/is_zhoufeng/article/details/26503725";
        //String originUrl = this.shortUrlMapping.get(shortUrl);
        try {
            ShortLinkDO shortLinkDO = this.shortLinkRepository.findByShortUrl(shortUrl);
            String originUrl = shortLinkDO.getOriginUrl();
            return URLDecoder.decode(originUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveShortUrl(String shortUrl, String decodeUrl) {
        //this.shortUrlMapping.put(shortUrl, decodeUrl);
        ShortLinkDO shortLinkDO = new ShortLinkDO();
        shortLinkDO.setShortUrl(shortUrl);
        shortLinkDO.setOriginUrl(decodeUrl);
        shortLinkDO.setCreateTime(new Date());
        shortLinkDO.setUpdateTime(new Date());
        if (null == this.shortLinkRepository.findByOriginUrl(decodeUrl)) {
            this.shortLinkRepository.save(shortLinkDO);
        }
    }
}
