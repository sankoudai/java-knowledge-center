package com.sankoudai.java.api.encode;

import junit.framework.TestCase;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by xuliufeng on 2015/12/14.
 */
public class TestURLEncoder extends TestCase {
    public void testEncode() throws UnsupportedEncodingException {
        String encodeResult = URLEncoder.encode("^", "utf-8");
        System.out.println(encodeResult);
    }

    public void testDecode() throws UnsupportedEncodingException {
        String txt = "SPREADURL=ksoEto&UA=__UA__&ADNETNAME=toutiao&IP=125.35.93.94&APPKEY=ddb931fe9226409591c448cffc9d6eda&click=%7B%22useragent%22:%22__UA__%22,%22action%22:%22none%22,%22callback%22:%22201607111425030100060292149180_1468218314_6887952880_6888804605_6099439535_12_6283746228_28286751836169_lnk0.com%22,%22chn%22:%22toutiao%22,%22osversion%22:%221%22,%22idfa%22:%22C64803E9-64AD-4040-8324-10BB5754203D%22,%22clicktime%22:%221468218314000%22,%22ip%22:%22125.35.93.94%22%7D&CLICKTIME=1468220570597&SPREADNAME=%E4%BB%8A%E6%97%A5%E5%A4%B4%E6%9D%A1iOS%E6%B5%8B%E8%AF%95200%E5%85%83%E2%80%94%E2%80%94%E5%AE%89%E6%B2%830708";
        System.out.println(URLDecoder.decode(URLDecoder.decode(txt, "utf-8"), "utf-8"));
    }
}
