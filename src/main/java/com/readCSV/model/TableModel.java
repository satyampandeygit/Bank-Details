package com.readCSV.model;

import javax.persistence.*;

@Entity
@Table(name="bank_branch", uniqueConstraints = {@UniqueConstraint(columnNames = {"ifsc_code"})})
public class TableModel {

    @Id
    @Column(name = "ifsc_code", nullable = false, unique = true)
    private String ifsc_code;

    @Column(name = "bank_id", nullable = false)
    private Integer bank_id;

    @Column(name = "branch", nullable = false)
    private String branch;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "bank_name", nullable = false)
    private String bank_name;

    public TableModel(){
        this.ifsc_code=null;
        this.bank_id=null;
        this.branch=null;
        this.address=null;
        this.city=null;
        this.district=null;
        this.state=null;
        this.bank_name=null;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
}
