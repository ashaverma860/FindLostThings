package joyee.findlostthings;

import java.security.PrivateKey;

/**
 * Created by Lenovo on 04-09-2017.
 */

public class Word {

private String mItemname;
    private int mImageResourceId;

    public Word(String Itemname,int ImageResourceId)
    {
        mItemname=Itemname;
        mImageResourceId= ImageResourceId;

    }
    public String getItemname()
    {return  mItemname;
    }
    public int getImageResourceId()
    {
        return mImageResourceId;
    }
}
