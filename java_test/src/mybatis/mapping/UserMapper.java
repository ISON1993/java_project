package mybatis.mapping;

import mybatis.domain.User;

/**
 * Created by tuzhenyu on 17-9-4.
 * @author tuzhenyu
 */
public interface UserMapper {
    public User getUser(int id) throws Exception;

    public void insertUser(User user);

    public void updateUserScore(User user);
}
