package mybatisPlugin.redis;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by tuzhenyu on 17-9-11.
 * @author tuzhenyu
 */

public class RedisCache implements Cache {

    private String cacheId;
    private JedisUtil jedisUtil;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public RedisCache(String cacheId)throws Exception{
        this.cacheId = cacheId;
        this.jedisUtil = new JedisUtil();
    }

    @Override
    public String getId() {
        return cacheId;
    }

    @Override
    public void putObject(Object key, Object value) {
        jedisUtil.putObject(key,value);
    }

    @Override
    public Object getObject(Object key) {
        return jedisUtil.getObject(key);
    }

    @Override
    public Object removeObject(Object key) {
        return jedisUtil.removeObject(key);
    }

    @Override
    public void clear() {
        jedisUtil.removeAll();
    }

    @Override
    public int getSize() {
        return jedisUtil.getSize();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
