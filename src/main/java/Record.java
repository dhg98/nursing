import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Record implements Comparable<Record>{

    private final Calendar date;
    private final String description;

    public Record(int year, int month, int date, String description) {
        this.date = new GregorianCalendar();
        this.date.set(year, month, date);
        this.description = description;
    }

    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    public String getDescription() {
        return description;
    }

    public int compareTo(Record o) {
        if (this.date.before(o)) return -1;
        else if (o.date.before(this.date)) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date.getTime()) + "\t" + description;
    }
}
