package com.sankoudai.java.apix.xstream.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by xuliufeng on 2015/12/22.
 */
@XStreamAlias("annotatedStudent")
public class AnnotatedStudent {

    @XStreamAlias("row")
    private int rowNo;

    @XStreamAsAttribute
    @XStreamAlias("name")
    private String firstName;
    private String lastName;
    private String className;

    @XStreamImplicit
    private List<AnnotatedAddress> addresses;

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public List<AnnotatedAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AnnotatedAddress> addresses) {
        this.addresses = addresses;
    }
}
