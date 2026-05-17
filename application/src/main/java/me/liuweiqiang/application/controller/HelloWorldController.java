package me.liuweiqiang.application.controller;

//import me.liuweiqiang.automatic.entity.World;
import me.liuweiqiang.entity.Hello;
import me.liuweiqiang.interfaces.exports.IFundTransfer;
import me.liuweiqiang.unoinpay.exports.TransferIn;
//import me.liuweiqiang.unoinpay.opens.TransferOut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.Method;
import java.util.ServiceLoader;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String hello() throws Exception {
        TransferIn transferIn = new TransferIn();
        transferIn.transfer("External Account", "Internal Account", 100);
        // can not be imported because module unoinpay opens me.liuweiqiang.unoinpay.opens package
        // but does not export
//        TransferOut exportedTransferOut = new TransferOut();

        IFundTransfer transferOut = (IFundTransfer) Class
                .forName("me.liuweiqiang.unoinpay.opens.TransferOut")
                .getDeclaredConstructor()
                .newInstance();
        transferOut.transfer("Internal Account", "External Account", 101);
        Class<?> clazz = Class.forName("me.liuweiqiang.unoinpay.exports.TransferIn");
        // the constructor and method can be accessed because it is exported and public
        IFundTransfer iFundTransfer = (IFundTransfer) clazz.getDeclaredConstructor().newInstance();
        iFundTransfer.transfer("External Account", "Internal Account", 102);
        Method transfer = clazz.getDeclaredMethod("transfer", String.class, String.class, int.class);
        Object instance = clazz.getDeclaredConstructor().newInstance();
        transfer.invoke(instance, "External Account", "Internal Account", 103);
        // the method can not be accessed because it is private and is not opened
        Method transferOldVersion = clazz.getDeclaredMethod("transfer", String.class, int.class);
        try {
            transferOldVersion.setAccessible(true);
        } catch (InaccessibleObjectException e) {
            e.printStackTrace();
        }
        try {
            transferOldVersion.invoke(instance, "External Account", 104);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Class<?> openedPrivateTransfer = Class.forName("me.liuweiqiang.unoinpay.opens.OpenedPrivateTransfer");
        Object openedPrivateTransferInstance = openedPrivateTransfer.getDeclaredConstructor().newInstance();
        System.out.println(openedPrivateTransferInstance);

        // all implementations of IFundTransfer can be accessed (provides)
        ServiceLoader.load(IFundTransfer.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .forEach(i -> i.transfer("Random Account", "Random Account", 105));

        return "hello";
    }

    // when run by IDE:
    // - application in module path
    // - entity in class path, i.e., thus entity is a unnamed module
    // - entity_new in class path
    public static void main(String[] args) throws Exception {
        // A named module cannot declare a dependence upon the unnamed module.
        // Unless [--add-reads application=ALL-UNNAMED] (try running jar without --add-reads to observe the exceptions)
        // or reflectively access
        Class<?> helloClazz = Class.forName("me.liuweiqiang.entity.Hello");
        Object helloInstance = helloClazz.getDeclaredConstructor().newInstance();
        Method toString = helloClazz.getDeclaredMethod("toString");
        String hello = (String) toString.invoke(helloInstance);
        System.out.println(hello);
        try {
            new Hello();
        } catch (IllegalAccessError e) {
            e.printStackTrace();
        }
        Method main = helloClazz.getDeclaredMethod("main", String[].class);
        main.invoke(null, (Object) null);

//        World world = new World();
//        System.out.println(world.join());
    }
}