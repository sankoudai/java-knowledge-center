package com.sankoudai.java.apix.xstream.entity;

/**
 * Created by xuliufeng on 2015/12/20.
 */
public class Student {
    private int rowNo;

    private String firstName;
    private String lastName;
    private String className;

    private Address address;

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

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Student [ ");
        stringBuilder.append("\nfirstName: ");
        stringBuilder.append(firstName);
        stringBuilder.append("\nlastName: ");
        stringBuilder.append(lastName);
        stringBuilder.append("\nrowNo: ");
        stringBuilder.append(rowNo);
        stringBuilder.append("\nclassName: ");
        stringBuilder.append(className);
        stringBuilder.append("\naddress: ");
        stringBuilder.append(address);
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }
}
