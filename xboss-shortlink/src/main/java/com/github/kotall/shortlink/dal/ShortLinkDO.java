package com.github.kotall.shortlink.dal;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "T_SHORT_URL")
@Data
public class ShortLinkDO {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "short_url")
    private String shortUrl;
    @Column(name = "origin_url")
    private String originUrl;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    @UpdateTimestamp
    private Date updateTime;
}
