package mybatisPlugin;

import mybatisPlugin.domain.Role;
import mybatisPlugin.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created by tuzhenyu on 17-9-12.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        String resource = "mybatisPlugin/config.xml";
        InputStream is = mybatis.Main.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();


        String statement1 = "mybatisPlugin.mapping.UserMapper.getUserRole";
        List<User> users = session.selectList(statement1);
        for (User user : users){
            System.out.println(user.getId()+" "+ user.getName()+" "+user.getRole());
        }
//        session.commit();

        Role role = new Role();
        role.setId(2);
        role.setRole("admin");
        String statement = "mybatisPlugin.mapping.RoleMapper.updateRole";
        session.update(statement,role);
//        session.commit();

        String statement2 = "mybatisPlugin.mapping.UserMapper.getUserRole";
        List<User> user2 = session.selectList(statement2);
        for (User user : user2){
            System.out.println(user.getId()+" "+ user.getName()+" "+user.getRole());
        }
//        session.commit();
//        session.close();
    }
}
