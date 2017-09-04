package mybatis.dao;

import mybatis.domain.User;

/**
 * Created by tuzhenyu on 17-9-4.
 * @author tuzhenyu
 */
public interface UserMapper {
    public User getUser(int id) throws Exception;
}
