package by.bsu.zhurov;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zhur on 12.10.2014.
 */
public class Event
{
    private String name;
    private String city;
    private String country;
    private Date date;
    private URL url;

    public Event() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            this.date = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String eventToString() {
        return "Date&time: " + date.toLocaleString() + "\nUrl: " + url
                + "\nName: " + name + "\nCity: " + city + "\nCountry: " + country;
    }
}
