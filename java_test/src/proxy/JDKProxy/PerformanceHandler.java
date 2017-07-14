package proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tuzhenyu on 17-7-14.
 * @author tuzhenyu
 */
public class PerformanceHandler implements InvocationHandler{
    private Object target;

    public PerformanceHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("begin monitor...");
        Object obj = method.invoke(target,args);
        System.out.println("end monitor...");
        return obj;
    }
}
