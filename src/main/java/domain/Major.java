package domain;

public class Major {
    private int majorId;
    private String majorName;
    private String imageURL;

    public Major(int majorId, String majorName, String imageURL) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.imageURL = imageURL;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
