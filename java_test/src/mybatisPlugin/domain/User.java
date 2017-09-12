package mybatisPlugin.domain;


import java.io.Serializable;

/**
 * Created by tuzhenyu on 17-9-4.
 * @author tuzhenyu
 */
public class User implements Serializable{
    private int id;
    private String name;
    private String password;
    private String score;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
