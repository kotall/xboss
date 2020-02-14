package com.github.kotall.shortlink.controller;

import com.github.kotall.shortlink.service.ShortLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/")
@Controller
public class ShortLinkController {

    @Resource
    private ShortLinkService shortLinkService;

    /**
     * 短链接跳转
     *
     * @param shortUrl
     */
    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable("shortUrl") String shortUrl) {
        System.out.println("短链接 ==> " + shortUrl);
        String originUrl = this.shortLinkService.getOriginUrl(shortUrl);
        if (StringUtils.isEmpty(originUrl)) {
            return "index";
        }
        System.out.println("原url ==> " + originUrl);
        return "redirect:" + originUrl;
    }

}
