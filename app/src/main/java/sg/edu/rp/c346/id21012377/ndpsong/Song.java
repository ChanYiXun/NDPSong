package sg.edu.rp.c346.id21012377.ndpsong;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Song(int id, String title, String singer, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getStar() { return stars; }

    private String getStar(int star) {
        switch (star) {
            case 1: return "*";

            case 2: return "* *";

            case 3: return "* * *";

            case 4: return "* * * *";

            case 5: return "* * * * *";

            default: return "";
        }
    }

    public void setTitle(String Title){
        this.title = Title;
    }

    public void setSinger(String Singer){
        this.singer = Singer;
    }

    public void setYear(int Year){
        this.year = Year;
    }

    public void setStars(int Stars){
        this.stars = Stars;
    }

    public String toString(){ return " " + getStar(stars); }
}

