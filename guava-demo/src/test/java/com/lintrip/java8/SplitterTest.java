package com.lintrip.java8;

import com.google.common.base.Splitter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitterTest {

    @Test
    public void testSplit(){
        String param = "tvhwver=V105A4-B-C1&s1=loginbuyQR&vipType=8&orderSeq=";
        System.out.println(getExtendParamsMap1(param));
    }


    public static Map<String, String> getExtendParamsMap(String extendParam) {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isBlank(extendParam)) {
            return map;
        }
        String[] params = StringUtils.split(extendParam,"&");
        for (String param : params) {
            String[] kv = StringUtils.split(param,"=");
            map.put(kv[0], kv[1]);
        }
        return map;
    }

    public static Map<String, String> getExtendParamsMap1(String extendParam) {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isBlank(extendParam)) {
            return map;
        }
        List<String> params = Splitter.on("&").splitToList(extendParam);
        for (String param : params) {
            List<String> kv = Splitter.on("=").splitToList(param);
            if (CollectionUtils.isNotEmpty(kv) && kv.size() > 1) {
                map.put(kv.get(0), kv.get(1));
            }
        }
        return map;
    }
}
