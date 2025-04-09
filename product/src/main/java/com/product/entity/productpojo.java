package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class productpojo {
    
    @Id
    @Min(value = 1, message = "Id must be greater than 0")
    private int pid;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String pname;

    @Max(value = 200000, message = "Price must be less than or equal to 200,000")
    private double pprice;

    private double pquantity;

    private String status;

    // Getters and setters
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPquantity() {
        return pquantity;
    }

    public void setPquantity(double pquantity) {
        this.pquantity = pquantity;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "productpojo [pid=" + pid + ", pname=" + pname + ", pquantity=" + pquantity + ", pprice=" + pprice
                + ", status=" + status + "]";
    }
}
