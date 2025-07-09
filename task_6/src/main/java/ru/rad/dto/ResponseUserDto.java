package ru.rad.dto;

public class ResponseUserDto {
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ResponseUserDto(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ResponseUserDto{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
