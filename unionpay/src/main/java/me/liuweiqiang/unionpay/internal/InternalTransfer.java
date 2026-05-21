package me.liuweiqiang.unionpay.internal;

import me.liuweiqiang.interfaces.exports.IFundTransfer;

public class InternalTransfer implements IFundTransfer {
    @Override
    public void transfer(String from, String to, int amount) {
        System.out.println("InternalTransfer: " + from + " -> " + to + " " + amount);
    }
}