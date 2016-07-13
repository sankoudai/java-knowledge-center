package com.sankoudai.java.apix.apache.httpclient;

import junit.framework.TestCase;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.Charset;
import java.util.List;


public class TestURLEncodedUtils extends TestCase {
    public void testParse() {
        String queryString = "SPREADURL=ZBFRZ9&ADNETNAME=gdt&APPKEY=ddb931fe9226409591c448cffc9d6eda&click=%7B%22click_time%22:%221468394815%22,%22app_type%22:%22ios%22,%22advertiser_id%22:%221830177%22,%22appid%22:%22911330580%22,%22chn%22:%22gdt%22,%22muid%22:%228d3a6a56ecccb7269a51d1395fe71fb7%22,%22click_id%22:%223lhikv3fdyaghsjfo4yq%22%7D&CLICKTIME=1468394815000&SPREADNAME=%E5%B9%BF%E7%82%B9%E9%80%9A%E6%B5%8B%E8%AF%95";
        List<NameValuePair> pairList = URLEncodedUtils.parse(queryString, Charset.forName("UTF-8"));
        for (NameValuePair pair : pairList) {
            System.out.println(pair.getName() + "=" + pair.getValue());
        }
    }
}
