package kindergarten.uz.kindergarten.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {
    private int id;
    private String title_text;

    private String text;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle_text() {
        return title_text;
    }

    public void setTitle_text(String title_text) {
        this.title_text = title_text;
    }


}
