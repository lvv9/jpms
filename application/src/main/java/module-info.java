import me.liuweiqiang.interfaces.exports.IFundTransfer;

// make application open because application layer is accessed by org.springframework or other frameworks usually
// same as
// java --adds-opens application/me.liuweiqiang.application=XXX
// --adds-opens application/me.liuweiqiang.application.controller=XXX
open module application {
    uses IFundTransfer;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires unoinpay;
    requires artifact.entity.automatic;
    // TODO
//    requires java.instrument;
}