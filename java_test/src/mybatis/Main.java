package mybatis;

import mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by tuzhenyu on 17-9-4.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) throws Exception{
        String resource = "mybatis/config.xml";
        InputStream is = Main.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

//        String statement = "mybatis.mapping.UserMapper.getUser";
//        User user = session.selectOne(statement,1);
//        System.out.println(user.getName());
////        session.commit();
//        session.close();

//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        User user = userMapper.getUser(1);
//        System.out.println(user.getName());

//        User user = new User();
//        user.setName("liuliu");
//        user.setPassword("123123");
//        user.setScore("88");
//        String statement = "mybatis.mapping.UserMapper.insertUser";
//        session.insert(statement,user);
//        session.commit();
//        session.close();


        String statement0 = "mybatis.mapping.UserMapper.getUser";
        User user0 = session.selectOne(statement0,1);
        System.out.println(user0.getScore());
//        session.commit();

        User user = new User();
        user.setId(1);
        user.setScore("88");
        String statement = "mybatis.mapping.UserMapper.updateUserScore";
        session.update(statement,user);
//        session.commit();

        String statement1 = "mybatis.mapping.UserMapper.getUser";
        User user1 = session.selectOne(statement1,1);
        System.out.println(user1.getScore());
//        session.commit();
        session.close();


    }
}
