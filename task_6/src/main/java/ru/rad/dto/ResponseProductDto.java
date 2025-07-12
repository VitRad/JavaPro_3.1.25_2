package ru.rad.dto;

import ru.rad.entity.ProductType;

import java.math.BigDecimal;

public class ResponseProductDto {
    private String account;
    private BigDecimal balance;
    private ProductType productType;
    private ResponseUserDto user;


    public ResponseProductDto(String account, BigDecimal balance, ProductType productType, ResponseUserDto user) {
        this.account = account;
        this.balance = balance;
        this.productType = productType;
        this.user = user;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ResponseUserDto getUser() {
        return user;
    }

    public void setUser(ResponseUserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ResponseProductDto{" +
                "account='" + account + '\'' +
                ", balance=" + balance +
                ", productType=" + productType +
                ", userId=" + user +
                '}';
    }
}
