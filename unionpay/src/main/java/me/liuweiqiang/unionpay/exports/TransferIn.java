package me.liuweiqiang.unionpay.exports;

import me.liuweiqiang.interfaces.exports.IFundTransfer;

public class TransferIn implements IFundTransfer {
    @Override
    public void transfer(String from, String to, int amount) {
        System.out.println("TransferIn: " + from + " -> " + to + " " + amount);
    }

    private void transfer(String from, int amount) {
        System.out.println("TransferIn: " + from + " " + amount);
    }
}
