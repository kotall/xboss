package com.github.kotall.shortlink.controller;

import com.github.kotall.commons.http.HttpResult;
import com.github.kotall.shortlink.ShortLinkBuilder;
import com.github.kotall.shortlink.service.ShortLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/console")
@Controller
public class ConsoleController {

    @Resource
    private ShortLinkService shortLinkService;

    @ResponseBody
    @PostMapping("/ex")
    public HttpResult exchange(@RequestBody String decodeUrl) {
        System.out.println(decodeUrl);
        String shortUrl = ShortLinkBuilder.build(decodeUrl);
        // 保存短链接映射
        this.shortLinkService.saveShortUrl(shortUrl, decodeUrl);
        return new HttpResult(shortUrl);
    }
}
