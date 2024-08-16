package by.shug.practicemain.fragments.education;

public class PointsModel {
    private String point;
    private String letter;
    private String description;
    private String pointDescription;

    public PointsModel(String point, String letter, String description, String pointDescription) {
        this.point = point;
        this.letter = letter;
        this.description = description;
        this.pointDescription = pointDescription;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPointDescription() {
        return pointDescription;
    }

    public void setPointDescription(String pointDescription) {
        this.pointDescription = pointDescription;
    }
}
