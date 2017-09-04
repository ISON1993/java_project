package mybatis;

import mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.beans.Statement;
import java.io.InputStream;

/**
 * Created by tuzhenyu on 17-9-4.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        String resource = "mybatis/config.xml";
        InputStream is = Main.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "mybatis.mapping.userMapper.getUser";

        User user = session.selectOne(statement,1);
        System.out.println(user.getName());
    }
}
