import me.liuweiqiang.interfaces.exports.IFundTransfer;

// make application open because application layer is accessed by org.springframework or other frameworks usually
// same as java --adds-opens application/me.liuweiqiang.application=ALL-UNNAMED --adds-opens application/me.liuweiqiang.application.controller=ALL-UNNAMED
open module application {
    uses IFundTransfer;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires unoinpay;
    // TODO
    requires java.instrument;
//    requires org.apache.tomcat.embed.core;
}