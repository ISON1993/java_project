package proxy.CGLibProxy;

import JDKProxy.ForumServiceImpl;

/**
 * Created by tuzhenyu on 17-7-14.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
        forumService.addTopic();
        forumService.removeTopic();
    }
}
