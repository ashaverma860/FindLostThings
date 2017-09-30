package joyee.findlost;

/**
 * Created by Lenovo on 20-09-2017.
 */

public class User {
    private String ItemName;
    private String ItemLocation;
    private String ItemDiscription;
    private String Date;
    private String Time;
    private String ImageUrl;

    public User()
    {}

    public User(String ItemName, String ItemLocation, String ItemDiscription, String Date, String Time, String ImageUrl)
    {
        this.ItemName=ItemName;
        this.ItemLocation=ItemLocation;
        this.ItemDiscription=ItemDiscription;
        this.Date= Date;
        this.Time=Time;
        this.ImageUrl=ImageUrl;

    }


    public void setItemName(String ItemName)
    {
    this.ItemName=ItemName;
    }
    public void setItemLocation(String ItemLocation)
    {
    this.ItemLocation=ItemLocation;
    }
    public void setItemDiscription(String ItemDiscription)
    {
        this.ItemDiscription=ItemDiscription;
    }
    public void setDate(String Date)
    {
        this.Date=Date;
    }
    public void setTime(String Time)
    {
        this.Time=Time;
    }
    public void setImageUrl(String ImageUrl)
    {
        this.ImageUrl=ImageUrl;
    }
    public String getItemName()
    {
        return ItemName;
    }
    public String getItemLocation()
    {
        return ItemLocation;
    }
    public String getItemDiscription()
    {
        return ItemDiscription;
    }
    public String getDate()
    {
        return Date;
    }
    public String getTime()
    {
        return Time;
    }
    public String getImageUrl()
    {
        return ImageUrl;
    }



}
