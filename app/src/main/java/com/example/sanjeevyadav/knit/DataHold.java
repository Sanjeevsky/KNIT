package com.example.sanjeevyadav.knit;

public class DataHold {

    String text;
    String link;
    String type;

    public DataHold() {
    }

    public DataHold(String text, String link,String type) {
        this.text = text;
        this.link = link;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
