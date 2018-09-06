package sino.gmn.entity;

import java.util.Date;

public class DownloadFile {
    private Integer id;

    private String name;

    private String url;

    private String user;

    private String comments;

    private Integer flag;

    private Date uploadFileDate;

    private Date downloadFileDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getUploadFileDate() {
        return uploadFileDate;
    }

    public void setUploadFileDate(Date uploadFileDate) {
        this.uploadFileDate = uploadFileDate;
    }

    public Date getDownloadFileDate() {
        return downloadFileDate;
    }

    public void setDownloadFileDate(Date downloadFileDate) {
        this.downloadFileDate = downloadFileDate;
    }
}