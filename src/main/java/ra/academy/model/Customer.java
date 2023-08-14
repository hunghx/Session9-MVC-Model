package ra.academy.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Long id;
    private String fullName;
    private int age;
    private boolean sex;
    private String avatar; // uploadfile
    private List<String> images = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long id, String fullName, int age, boolean sex, String avatar) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
