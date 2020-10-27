package market.api.model;

public class Schedule {
    private String day;
    private  String fromTime;
    private  Boolean isAllDay;
    private  Boolean isDayOff;
    private  String toTime;

    public Schedule() {
    }

    public Schedule(String day, String fromTime, Boolean isAllDay, Boolean isDayOff, String toTime) {
        this.day = day;
        this.fromTime = fromTime;
        this.isAllDay = isAllDay;
        this.isDayOff = isDayOff;
        this.toTime = toTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public Boolean getisAllDay() {
        return isAllDay;
    }

    public void setisAllDay(Boolean isallDay) {
        isAllDay = isallDay;
    }

    public Boolean getisDayOff() {
        return isDayOff;
    }

    public void setisDayOff(Boolean isdayOff) {
        isDayOff = isdayOff;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
}
