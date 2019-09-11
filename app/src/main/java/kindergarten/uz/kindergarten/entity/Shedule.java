package kindergarten.uz.kindergarten.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Shedule {
    @SerializedName("child")
    @Expose
    private Child child;
    @SerializedName("menuList")
    @Expose
    private ArrayList<Menu> menuList;
    @SerializedName("current")
    @Expose
    private Visit current;


    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }


    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    public Visit getCurrent() {
        return current;
    }

    public void setCurrent(Visit current) {
        this.current = current;
    }
}
