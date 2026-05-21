package me.liuweiqiang.unionpay.opens;

import me.liuweiqiang.interfaces.exports.IFundTransfer;

public class TransferOut implements IFundTransfer {
    @Override
    public void transfer(String from, String to, int amount) {
        System.out.println("TransferOut: " + from + " -> " + to + " " + amount);
    }
}