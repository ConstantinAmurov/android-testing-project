package com.example.androidassignment;

public class Suffixer {

    String text;
    Integer index;

    public  Suffixer(String text,Integer index) {
        this.text = text;
        this.index = index;
    }

    public String getSuffix ()
    {
        try {
            String result = this.text.substring(this.index);
            return result;
        }
        catch(Exception e) {
            throw e;
        }
    }
}
