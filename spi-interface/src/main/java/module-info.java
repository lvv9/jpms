import me.liuweiqiang.interfaces.exports.IFundTransfer;
import me.liuweiqiang.interfaces.internal.InternalTransfer;

module interfaces {
    exports me.liuweiqiang.interfaces.exports;

    provides IFundTransfer with InternalTransfer;
}