package com.example.androidassignment;

import java.io.IOException;

public class Suffixer {

    String text;
    String index;

    public  Suffixer(String text,String index) {
        this.text = text;
        this.index = index;
    }

    public String getSuffix () throws Exception {
        try {
            int indexNumber = Integer.parseInt(index);
            if (indexNumber < 0 || indexNumber > text.length() - 1) {
                throw new Exception("Index should be greater than 0 and smaller than " + (text.length()-1));
            }

            String result = this.text.substring(indexNumber);
            return result;
        }
        catch(NumberFormatException e) {
            throw new Exception("Please enter a valid index number");
        }

    }
}
