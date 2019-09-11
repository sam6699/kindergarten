package kindergarten.uz.kindergarten.entity;

import java.util.ArrayList;

public class Child {
    private String name;

    private String birth;


    private String address;

    private String direction;

    private Parent parent;

    private int group_id;

    private Group group;

    private ArrayList<Cource> list;

    private Image image;;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }


    public ArrayList<Cource> getList() {
        return list;
    }

    public void setList(ArrayList<Cource> list) {
        this.list = list;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}


