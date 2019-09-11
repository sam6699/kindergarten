package kindergarten.uz.kindergarten.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Group {
    private int id;
    private int count;
    private String educator;
    private String nurse;
    private int group_cnt;
    private int price;
    private int company_id;
    private Cource cource;
    private Type type;
    private int busy;

    public int getBusy() {
        return busy;
    }

    public void setBusy(int busy) {
        this.busy = busy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getEducator() {
        return educator;
    }

    public void setEducator(String educator) {
        this.educator = educator;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public int getGroup_cnt() {
        return group_cnt;
    }

    public void setGroup_cnt(int group_cnt) {
        this.group_cnt = group_cnt;
    }

    public Cource getCource() {
        return cource;
    }

    public void setCource(Cource cource) {
        this.cource = cource;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
