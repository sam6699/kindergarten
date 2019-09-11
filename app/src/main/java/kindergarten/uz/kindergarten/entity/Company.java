package kindergarten.uz.kindergarten.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("main_id")
    @Expose
    private Main mainId;
    @SerializedName("img_id")
    @Expose
    private Image img_id;

    public Image getImg_id() {
        return img_id;
    }

    public void setImg_id(Image img_id) {
        this.img_id = img_id;
    }

    public Main getMainId() {
        return mainId;
    }

    public void setMainId(Main mainId) {
        this.mainId = mainId;
    }

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
}
