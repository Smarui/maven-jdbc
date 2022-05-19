package pro_demo;

/**
 *
 * 英雄信息
 * @author small瑞
 */
public class Hero {
    private String name ;
    private String sex;
    private String location;
    private String nickname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", location='" + location + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}


