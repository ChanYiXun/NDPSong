package sg.edu.rp.c346.id21012377.ndpsong;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Song(int id, String title, String singer, int year, int stars) {
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

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() { return "ID:" + id
            + "\nSinger:" + singer
            + "\nTitle:" + title
            + "\nYear:" + year
            + "\nStar:" + stars; }

}

