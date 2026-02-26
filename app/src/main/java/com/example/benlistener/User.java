package com.example.benlistener;

public class User {

    private int numCoins;
    private String nickName;

    public int getNumCoins() {
        return numCoins;
    }

    public void setNumCoins(int numCoins) {
        this.numCoins = numCoins;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public User(int numCoins, String nickName) {
        this.numCoins = numCoins;
        this.nickName = nickName;
    }

    public User(int etValue) {
    }

}
