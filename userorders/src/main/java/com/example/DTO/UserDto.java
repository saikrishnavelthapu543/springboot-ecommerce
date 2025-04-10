package com.example.DTO;

import java.sql.Date;

public class UserDto {

    private int userid;
    private String firstname;
    private String lastname;
    private String userrole;
    private String accountstatus;
    
    // Order fields
    private Integer orderid;  // Integer to handle null values
    private Date orderdate;
    private String orderstatus;
    private Date shippingdate;
    private Date deliverydate;
    
    // Getters and Setters
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(String accountstatus) {
        this.accountstatus = accountstatus;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date date) {
        this.orderdate = date;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Date getShippingdate() {
        return shippingdate;
    }

    public void setShippingdate(Date date) {
        this.shippingdate = date;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    @Override
    public String toString() {
        return "UserDto [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", userrole="
                + userrole + ", accountstatus=" + accountstatus + ", orderid=" + orderid + ", orderdate=" + orderdate
                + ", orderstatus=" + orderstatus + ", shippingdate=" + shippingdate + ", deliverydate=" + deliverydate
                + "]";
    }
}
