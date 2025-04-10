package com.example.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
@Table(name="order_pojo")
public class OrderPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	@NotNull
	@Past
	private Date orderdate;
	@NotNull
	private String orderstatus;
	private Date shippingdate;
	private Date deliverydate;
	@NotNull
	private String paymentmethod;
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	private long totalamount;
	@NotBlank
	private String currency;
	@Override
	public String toString() {
		return "OrderPojo [orderid=" + orderid + ", orderdate=" + orderdate + ", orderstatus=" + orderstatus
				+ ", shippingdate=" + shippingdate + ", deliverydate=" + deliverydate + ", paymentmethod="
				+ paymentmethod + ", totalamount=" + totalamount + ", currency=" + currency + "]";
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
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
	public void setShippingdate(Date shippingdate) {
		this.shippingdate = shippingdate;
	}
	public Date getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public long getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(long totalamount) {
		this.totalamount = totalamount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public OrderPojo(int orderid, @NotNull @Past Date orderdate, @NotNull String orderstatus,
			@FutureOrPresent Date shippingdate, @FutureOrPresent Date deliverydate, @NotNull String paymentmethod,
			@NotNull @DecimalMin(value = "0.0", inclusive = false) long totalamount, @NotBlank String currency) {
		super();
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.shippingdate = shippingdate;
		this.deliverydate = deliverydate;
		this.paymentmethod = paymentmethod;
		this.totalamount = totalamount;
		this.currency = currency;
	}
	public OrderPojo() {
		super();
	}

}
