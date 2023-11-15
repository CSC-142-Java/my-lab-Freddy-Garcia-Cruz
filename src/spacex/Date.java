package spacex;

public class Date {

    private int   day;
    private Month month;
    private int   year;

    public Date(){
        this(0, Month.JAN, 0 );
    }

    public Date(int day, Month month, int year) {
        this.day    = day;
        this.month  = month;
        this.year   = year;
    }


    @Override
    public String toString() {
        String date = String.format("%d-%s-%02d", day, month, year);
        return date.equals("0-Jan-0") ? "" : date;
    }
    
}
