package ru.innopolis.uni.course3.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InterfaceAddress;

/**
 * Created by julia on 12.12.2016.
 */
public class ProxyMain {
    public static void main(String[] args) {
        InterfaceOneImpl impl = new InterfaceOneImpl();

        Object proxy = Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{InterfaceOne.class, InterfaceTwo.class},
                new InvocationHandler() {
                    private InterfaceOneImpl interfaceOne = new InterfaceOneImpl();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (args != null && args.length > 0) {
                            System.out.println("logging " + args[0]);
                        }
                        return  method.invoke(interfaceOne, args);
                    }
                }
        );
        InterfaceOne one = (InterfaceOne) proxy;

        one.doSome(5);

        System.out.println(proxy);
    }
}
