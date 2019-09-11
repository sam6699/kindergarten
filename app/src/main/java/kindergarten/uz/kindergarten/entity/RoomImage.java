package kindergarten.uz.kindergarten.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RoomImage {
    @SerializedName("id")
    @Expose
        private int id;
    @SerializedName("room_id")
    @Expose
    private Group groupId;
    @SerializedName("images")
    @Expose
    private ArrayList<Image> imageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public ArrayList<Image> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<Image> imageList) {
        this.imageList = imageList;
    }
}
