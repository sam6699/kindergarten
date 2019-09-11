package kindergarten.uz.kindergarten.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type {
    private int id;
    private String name;
    private int age_start;
    private int age_end;

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

    public int getAge_start() {
        return age_start;
    }

    public void setAge_start(int age_start) {
        this.age_start = age_start;
    }

    public int getAge_end() {
        return age_end;
    }

    public void setAge_end(int age_end) {
        this.age_end = age_end;
    }
}
