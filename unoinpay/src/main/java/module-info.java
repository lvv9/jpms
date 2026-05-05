import me.liuweiqiang.interfaces.exports.IFundTransfer;
import me.liuweiqiang.unoinpay.exports.TransferIn;
import me.liuweiqiang.unoinpay.internal.InternalTransfer;
import me.liuweiqiang.unoinpay.opens.TransferOut;

module unoinpay {
    exports me.liuweiqiang.unoinpay.exports;
    opens me.liuweiqiang.unoinpay.opens;
    requires transitive interfaces;

    provides IFundTransfer with TransferIn, TransferOut, InternalTransfer;
}