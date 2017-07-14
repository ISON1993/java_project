package proxy.CGLibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tuzhenyu on 17-7-14.
 * @author tuzhenyu
 */
public class CglibProxy implements MethodInterceptor{
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws  Throwable{
        System.out.println("start monitor...");
        Object result = proxy.invokeSuper(obj,args);
        System.out.println("end monitor...");
        return result;
    }
}
