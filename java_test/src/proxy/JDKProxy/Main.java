package proxy.JDKProxy;

import java.lang.reflect.Proxy;

/**
 * Created by tuzhenyu on 17-7-14.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler
        );

        proxy.addTopic();
        proxy.removeTopic();
    }
}
