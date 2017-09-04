package mybatis.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tuzhenyu on 17-9-4.
 * @author tuzhenyu
 */
@Setter
@Getter
public class User {
    private int id;
    private String name;
    private String password;
    private String score;
}
