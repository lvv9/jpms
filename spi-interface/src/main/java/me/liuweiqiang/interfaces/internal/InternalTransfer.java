package me.liuweiqiang.interfaces.internal;

import me.liuweiqiang.interfaces.exports.IFundTransfer;

public class InternalTransfer implements IFundTransfer {
    @Override
    public void transfer(String from, String to, int amount) {
        System.out.println("Internal transfer from " + from + " to " + to + " amount " + amount);
    }
}
