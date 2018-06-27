package com.github.ericmoshare.adc.mapper.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
public class Asset {
    private Long id;
    private String assetId;
    private String assetName;
    private String assetType;
    private String accountType;
    private String userId;
    private String remark;
    private Date createTime;
    private Date updateTime;


}