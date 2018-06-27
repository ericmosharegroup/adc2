package com.xiaopeng.mapper.mapper;

import com.alibaba.fastjson.JSON;
import com.github.ericmoshare.adc.mapper.entity.Asset;
import com.github.ericmoshare.adc.mapper.entity.AssetExample;
import com.github.ericmoshare.adc.mapper.repository.AssetRepository;
import com.xiaopeng.mapper.BaseNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author eric.mo
 * @since 2018/5/4
 */
public class AssetRepositoryTest extends BaseNGTest {

    @Autowired
    private AssetRepository assetRepository;

    @Test
    public void selectCountByTable() {

        int result = assetRepository.countByExample(new AssetExample());
        System.out.println(result);
    }

    @Test
    public void selectByTable() {
        List<Asset> result = assetRepository.selectByExample(new AssetExample());
        System.out.println(JSON.toJSONString(result, true));
    }

}
