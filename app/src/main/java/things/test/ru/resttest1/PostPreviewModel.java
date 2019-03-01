package things.test.ru.resttest1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostPreviewModel {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("post_title")
    @Expose
    private String postTitle;
    @SerializedName("guid")
    @Expose
    private String guid;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String postContent) {
        this.guid = postContent;
    }

}