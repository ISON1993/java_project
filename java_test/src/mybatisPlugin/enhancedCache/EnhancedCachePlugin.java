package mybatisPlugin.enhancedCache;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by tuzhenyu on 17-9-12.
 * @author tuzhenyu
 */
@Intercepts(value = {
        @Signature(type = Executor.class,method = "query",args = {MappedStatement.class, Object.class, RowBounds.class,ResultHandler.class}),
        @Signature(type = Executor.class,method = "update",args = {MappedStatement.class, Object.class}),
        @Signature(args = {boolean.class}, method = "commit", type = Executor.class),
        @Signature(args = {boolean.class}, method = "rollback", type = Executor.class),
        @Signature(args = {boolean.class}, method = "close", type = Executor.class)
})
public class EnhancedCachePlugin implements Interceptor{

    private CacheKeysPool queryCacheOnCommit = new CacheKeysPool();
    private Set<String> updateStatementOnCommit = new HashSet<String>();
    EnhancedCacheManager enhancedCacheManager = EnhancedCacheManager.getEnhancedCacheManager();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String operate = invocation.getMethod().getName();
        Object result = null;
        if ("query".equals(operate)){
            result = processQuery(invocation);
        }else if ("update".equals(operate)){
            result = processUpdate(invocation);
        }else if ("commit".equals(operate)){
            result = processCommit(invocation);
        }

        return result;
    }

    private Object processQuery(Invocation invocation) throws Throwable{
        Object result = invocation.proceed();
        if (enhancedCacheManager.cacheEnabled){
            Object[] args = invocation.getArgs();
            MappedStatement statement = (MappedStatement)args[0];

            if (statement.isUseCache()&&statement.getCache()!=null){
                enhancedCacheManager.appendStatementCache(statement.getId(),statement.getCache());
            }
            Object parameter = args[1];
            RowBounds rowBounds = (RowBounds)args[2];
            Executor executor = (Executor)invocation.getTarget();
            BoundSql boundSql = statement.getBoundSql(parameter);

            CacheKey cacheKey= executor.createCacheKey(statement, parameter, rowBounds, boundSql);
            queryCacheOnCommit.putElement(statement.getId(), cacheKey);
        }
        return result;
    }

    private Object processUpdate(Invocation invocation) throws Throwable{
        Object result = invocation.proceed();
        MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
        updateStatementOnCommit.add(mappedStatement.getId());
        return result;
    }

    private Object processCommit(Invocation invocation) throws Throwable{
        Object result = invocation.proceed();
        refreshCache();
        return result;
    }

    private void refreshCache(){
        enhancedCacheManager.refreshCacheKey(queryCacheOnCommit);
        enhancedCacheManager.clearRelatedCaches(updateStatementOnCommit);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        if (!enhancedCacheManager.hasInitialized())
            enhancedCacheManager.initialize(properties);
    }
}
