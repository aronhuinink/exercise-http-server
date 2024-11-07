package nl.han.dea.http;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class HtmlPageReader {
    public String readFile(String filename) {
        var fullFileName = "pages/".concat(filename);
        try {
            

            var file = getClass().getClassLoader().getResourceAsStream(fullFileName);

            var fileAsString = new String(file.readAllBytes());

            return fileAsString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getContentLength() {
        System.out.println(readFile("index.html").length());
        return readFile("index.html").length();
    }

    public String getDate() {

        String string = "";

        Calendar calendar = Calendar.getInstance();

        //find the day
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        if(dayOfWeek == Calendar.MONDAY) {
            string += "Mon";
        }
        else if(dayOfWeek == Calendar.TUESDAY) {
            string += "Tue, ";
        }
        else if(dayOfWeek == Calendar.WEDNESDAY) {
            string += "Wed, ";
        }
        else if(dayOfWeek == Calendar.THURSDAY) {
            string += "Thu, ";
        }
        else if(dayOfWeek == Calendar.FRIDAY) {
            string += "Fri, ";
        }
        else if(dayOfWeek == Calendar.SATURDAY) {
            string += "Sat, ";
        }
        else if(dayOfWeek == Calendar.SUNDAY) {
            string += "Sun, ";
        }

        //day
        string += calendar.get(Calendar.DAY_OF_MONTH) + " ";

        //month
        int month = calendar.get(Calendar.MONTH);

        if(month == Calendar.JANUARY){
            string += "Jan";
        }
        else if(month == Calendar.FEBRUARY){
            string += "Feb";
        }
        else if(month == Calendar.MARCH){
            string += "Mar";
        }
        else if(month == Calendar.APRIL){
            string += "Apr";
        }
        else if(month == Calendar.MAY){
            string += "May";
        }
        else if(month == Calendar.JUNE){
            string += "Jun";
        }
        else if(month == Calendar.JULY){
            string += "Jul";
        }
        else if(month == Calendar.AUGUST){
            string += "Aug";
        }
        else if(month == Calendar.SEPTEMBER){
            string += "Sep";
        }
        else if(month == Calendar.OCTOBER){
            string += "Oct";
        }
        else if(month == Calendar.NOVEMBER){
            string += "Nov";
        }
        else if(month == Calendar.DECEMBER){
            string += "Dec";
        }

        string += " ";

        //year
        string += calendar.get(Calendar.YEAR) + " ";

        //time
        string += calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + " ";

        //timezoneoffset
        OffsetDateTime now = OffsetDateTime.now();
        String offset = now.format(DateTimeFormatter.ofPattern("XXX"));
        string += offset;

        return string;

    }
}