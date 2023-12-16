package spacex;

public class Time {

    private int hour;
    private int minutes;

    public Time(){
        this(5, 30); // call the second constructor at 5 hours and 30 minutes
    }

    public Time(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    // Accessor "getter" Methods
    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        String time = String.format("%d:%02d", hour, minutes);
        return (time.equals("0:0")) ? "" : time;
    }
}