package jdbc.connectionPool;

/**
 * Created by tuzhenyu on 16-12-7.
 * tuzhenyu
 */
public class MysqlConnectionPool {
    public static void main(String[] args) {
        Pool pool = new Pool();
        System.out.println(pool.getMaxPoolSize());
    }
}
