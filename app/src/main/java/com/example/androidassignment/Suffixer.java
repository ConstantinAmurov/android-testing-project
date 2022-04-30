package com.example.androidassignment;

public class Suffixer {

    String text;
    Integer index;

    public  Suffixer(String text,Integer index) {
        this.text = text;
        this.index = index;
    }

    public String getSuffix () throws Exception {
        try {
            if (this.index < 0 || this.index > text.length() - 1) {
                throw new Exception("Index should be greater than 0 and smaller than " + (text.length()-1));
            }

            String result = this.text.substring(this.index);
            return result;
        }
        catch(Exception e) {
            throw e;
        }
    }
}
