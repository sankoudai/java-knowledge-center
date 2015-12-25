package com.sankoudai.java.apix.xstream.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by xuliufeng on 2015/12/22.
 */
@XStreamAlias("address")
public class AnnotatedAddress {
    private String area;
    private String city;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
