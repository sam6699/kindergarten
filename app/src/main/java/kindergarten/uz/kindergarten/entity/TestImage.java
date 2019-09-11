package kindergarten.uz.kindergarten.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestImage {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path")
    @Expose
    private byte[] path;
    private int compay_id;

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

    public byte[] getPath() {
        return path;
    }

    public void setPath(byte[] path) {
        this.path = path;
    }

    public int getCompay_id() {
        return compay_id;
    }

    public void setCompay_id(int compay_id) {
        this.compay_id = compay_id;
    }
}
