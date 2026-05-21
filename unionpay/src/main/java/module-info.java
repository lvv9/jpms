import me.liuweiqiang.interfaces.exports.IFundTransfer;
import me.liuweiqiang.unionpay.exports.TransferIn;
import me.liuweiqiang.unionpay.internal.InternalTransfer;
import me.liuweiqiang.unionpay.opens.TransferOut;

module unionpay {
    exports me.liuweiqiang.unionpay.exports;
    opens me.liuweiqiang.unionpay.opens;
    // why transitive? see: https://openjdk.org/projects/jigsaw/spec/sotms/#implied-readability
    requires transitive interfaces;

    provides IFundTransfer with TransferIn, TransferOut, InternalTransfer;
}