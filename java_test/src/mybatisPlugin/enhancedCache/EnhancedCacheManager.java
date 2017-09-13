package mybatisPlugin.enhancedCache;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tuzhenyu on 17-9-12.
 * @author tuzhenyu
 */
public class EnhancedCacheManager {
    private boolean isInitialized = false;
    public boolean cacheEnabled = false;
    private Map<String,Set<String>> observers = new ConcurrentHashMap<>();
    private Map<String,Cache> holds = new ConcurrentHashMap<>();
    private CacheKeysPool cacheKeysPoolAll = new CacheKeysPool();

    private static EnhancedCacheManager enhancedCacheManager;

    public static EnhancedCacheManager getEnhancedCacheManager(){
        return enhancedCacheManager==null?new EnhancedCacheManager():enhancedCacheManager;
    }

    public void initialize(Properties properties){
        String cacheEnabled = properties.getProperty("cacheEnabled");
        if ("true".equals(cacheEnabled)){
            this.cacheEnabled = true;
        }else {
            return;
        }

        String dependency = properties.getProperty("dependency");
        if (!("".equals(dependency)||dependency==null)){
            try{
                InputStream is = Resources.getResourceAsStream(dependency);
                XPathParser parser = new XPathParser(is);
                List<XNode> statements = parser.evalNodes("/dependencies/statements/statement");
                for (XNode statement : statements){
                    Set<String> set = new HashSet<>();
                    List<XNode> nodes = statement.evalNodes("observer");
                    for (XNode observer : nodes){
                        set.add(observer.getStringAttribute("id"));
                    }
                    observers.put(statement.getStringAttribute("id"),set);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            isInitialized = true;
        }
    }

    public boolean hasInitialized(){
        return isInitialized;
    }

    public void appendStatementCache(String statementId,Cache cache){
        if (holds.containsKey(statementId)&&holds.get(statementId)!=null){
            return;
        }
        holds.put(statementId,cache);
    }

    public void refreshCacheKey(CacheKeysPool cacheKeysPool){
        cacheKeysPoolAll.putAll(cacheKeysPool);
    }

    public void clearRelatedCaches(Set<String> set){
        for (String updateOperationId : set){
            Set<String> observer = observers.get(updateOperationId);
            for (String clearQueryId : observer){
                Cache cache = holds.get(clearQueryId);
                Set<Object> relatedCacheKeys = cacheKeysPoolAll.get(clearQueryId);
                for (Object o : relatedCacheKeys){
                    cache.removeObject(o);
                }
//                cacheKeysPoolAll.remove(clearQueryId);
            }
        }
    }
}
