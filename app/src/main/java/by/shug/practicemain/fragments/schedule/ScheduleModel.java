package by.shug.practicemain.fragments.schedule;

public class ScheduleModel {
    private String day;
    private String start;
    private String end;
    private String description;
    private String group;

    public ScheduleModel(String day, String start, String end, String description, String group) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.description = description;
        this.group = group;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
