package com.bohanee.jcp.hrai;

/**
 * Created by Shivanshu Raj on 28-12-2022.
 */
public class Employee {
    private String name;
    private String empID;
    private String storeCode;
    private long phoneNo;
    private boolean isApproved;

    public Employee(String name, String empID, String storeCode, long phoneNo) {
        this.name = name;
        this.empID = empID;
        this.storeCode = storeCode;
        this.phoneNo = phoneNo;
    }

    public Employee(String name, String storeCode, long phoneNo, boolean isApproved) {
        this.name = name;
        this.storeCode = storeCode;
        this.phoneNo = phoneNo;
        this.isApproved = isApproved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }


}
