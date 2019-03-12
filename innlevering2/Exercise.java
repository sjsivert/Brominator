package innlevering2;

import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Exercise{

    private String date;
    private Time duration;
    private int shape;
    private int performance;
    private String note;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public Exercise(String date, String duration, String shape, String performance, String note) throws IllegalArgumentException{
        setDate(date);
        setDuration(duration);
        setShape(shape);
        setPerformance(performance);
        setNote(note);
        sdf.setLenient(false);
    }

    public String getDate(){
        return date;
    }

    public Time getDuration(){
        return duration;
    }

    public int getShape(){
        return shape;
    }

    public int getPerformance(){
        return performance;
    }

    public String getNote(){
        return note;
    }

    public void setDate(String date) {
        if(dateIsValid(date)){
            this.date = date.trim();
            return;
        }
        throw new IllegalArgumentException("wrong_date");
    }

    public void setDuration(String duration){
        if(durationIsValid(duration)){
            this.duration = new Time(Integer.parseInt(duration)*60*1000);
            return;
        }
        throw new IllegalArgumentException("wrong_duration");
    }

    public void setShape(String shape){
        if(shapeIsValid(shape)){
            this.shape = Integer.parseInt(shape);
            return;
        }
        throw new IllegalArgumentException("wrong_shape");
    }

    public void setPerformance(String performance){
        if(performanceIsValid(performance)){
            this.performance = Integer.parseInt(performance);
            return;
        }
        throw new IllegalArgumentException("wrong_performance");
    }

    public void setNote(String note){
        if(noteIsValid(note)){
            this.note = note;
            return;
        }
        throw new IllegalArgumentException("wrong_note");
    }

    public boolean dateIsValid(String date){
        try {
            sdf.parse(date.trim());
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public boolean durationIsValid(String duration){
        try {
            int val = Integer.parseInt(duration);
            return 1 <= val;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public boolean shapeIsValid(String shape){
        try {
            int val = Integer.parseInt(shape);
            return 1 <= val && val <= 10;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public boolean performanceIsValid(String performance){
        try {
            int val = Integer.parseInt(performance);
            return 1 <= val && val <= 10;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public boolean noteIsValid(String note){
        return note instanceof String;
    }
}
