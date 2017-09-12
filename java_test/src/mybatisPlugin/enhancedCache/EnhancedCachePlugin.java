package mybatisPlugin.enhancedCache;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * Created by tuzhenyu on 17-9-12.
 * @author tuzhenyu
 */
@Intercepts(value = {
        @Signature(type = Executor.class,method = "query",args = {MappedStatement.class, Object.class, RowBounds.class,ResultHandler.class}),
        @Signature(type = Executor.class,method = "update",args = {MappedStatement.class, Object.class})
})
public class EnhancedCachePlugin implements Interceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
