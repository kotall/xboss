package com.github.kotall.shortlink.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShortLinkRepository extends CrudRepository<ShortLinkDO, Integer> {

    ShortLinkDO findByShortUrl(String shortUrl);


    ShortLinkDO findByOriginUrl(String originUrl);

}
