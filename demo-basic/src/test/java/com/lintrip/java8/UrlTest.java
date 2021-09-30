package com.lintrip.java8;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 正则测试
 *
 * @date 2021/9/14 16:49
 */
public class UrlTest {


    @Test
    public void testUrlValid() throws MalformedURLException {
        String s1 = "http://www.evil.com/acs?a=34422&b=212"; // 合法的地址
        Assert.assertTrue(oldValid(s1));
        Assert.assertTrue(newRegxValidate(s1));
        String s2 = "http://evil.com?login.aaa.com/acs?a=34422&b=212"; // 包含 ?
        Assert.assertFalse(oldValid(s2));
        Assert.assertFalse(newRegxValidate(s2));
        String s3 = "http://evil.com#login.aaa.com/acs?a=34422&b=212"; // 包含 #
        Assert.assertFalse(oldValid(s3));
        Assert.assertFalse(newRegxValidate(s3));
        String s4 = "http://aaa.com@www.evil.com/acs?a=34422&b=212"; // 包含 @
        Assert.assertTrue(oldValid(s4));
        Assert.assertFalse(newRegxValidate(s4));
        String s5 = "http://github.com\\\\evil.com/acs?a=34422&b=212"; // 包含 \\
        Assert.assertTrue(oldValid(s5));
        Assert.assertFalse(newRegxValidate(s5));
        String s6 = "http://github.com\\.evil.com/acs?a=34422&b=212"; // 包含 \
        Assert.assertTrue(oldValid(s6));
        Assert.assertFalse(newRegxValidate(s6));
        String s7 = "http://github.com\\.evil.com/acs?a=34422&b=212"; // 包含 \
        Assert.assertTrue(oldValid(s7));
        Assert.assertFalse(newRegxValidate(s7));

        String s8 = "https://github.com\\.evil.com/c&validTime=31536000&width=104&fc=&platform=&fv=&P00001=";
        Assert.assertTrue(oldValid(s8));
    }

    @Test
    public void testUrlValid02() throws MalformedURLException {
        String s1 = "http://www.evil.com/acs?a=34422&b=212"; // 合法的地址
        Assert.assertTrue(newRegxValidate(s1));
        String s2 = "http://abcevil.com/acs?a=34422&b=212"; // 包含 ?
        Assert.assertFalse(newRegxValidate(s2));
        String s3 = "http://evil.com#login.aaa.com/acs?a=34422&b=212"; // 包含 #
        Assert.assertFalse(newRegxValidate(s3));
        String s4 = "http://aaa.com@www.evil.com/acs?a=34422&b=212"; // 包含 @
        Assert.assertFalse(newRegxValidate(s4));
    }

    private boolean oldValid(String str) throws MalformedURLException {
        StringBuilder sbUrl = new StringBuilder(str);
        URL url = new URL(sbUrl.toString());
        String urlPath = url.getPath();
        int index = sbUrl.indexOf(urlPath);
        String path = sbUrl.toString();
        if (index > 0) {
            path = path.substring(0, index);
        }
        if (!path.matches("^(http|https)://.*evil\\.com.*")) {
            return false;
        }
        if (!path.endsWith("evil.com") && !path.endsWith("gitv.tv")) {
            return false;
        }
        return true;
    }

    public boolean newRegxValidate(String str) throws MalformedURLException {
        StringBuilder sbUrl = new StringBuilder(str);
        URL url = new URL(sbUrl.toString());
        String urlPath = url.getPath();
        int index = sbUrl.indexOf(urlPath);
        String path = sbUrl.toString();
        if (index > 0) {
            path = path.substring(0, index);
        }
        return path.matches("^(http|https)://[^@?#\\\\]*(\\.evil\\.com|\\.gitv\\.tv)$");
    }

}
