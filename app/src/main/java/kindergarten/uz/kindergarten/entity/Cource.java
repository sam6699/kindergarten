package kindergarten.uz.kindergarten.entity;

public class Cource {
    private int id;
    private String name;
    private int ball;
    private int child;
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

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setChild(int anInt) {
        this.child = anInt;
    }

    public int getChild(){
        return this.child;

    }
}
