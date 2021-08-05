package sg.edu.rp.c346.id20002369.oursingapore;

import java.io.Serializable;

public class Island implements Serializable {

    private int id;
    private String name;
    private String desc;
    private int area;
    private int rating;

    public Island(String name, String desc, int area, int rating) {
        this.name = name;
        this.desc = desc;
        this.area = area;
        this.rating = rating;
    }

    public Island(int id, String name, String desc, int area, int rating) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.area = area;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public Island setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Island setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Island setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public int getArea() {
        return area;
    }

    public Island setArea(int area) {
        this.area = area;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Island setRating(int rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public String toString() {
        String ratingString = "";
        for(int i = 0; i < rating; i++){
            ratingString += "*";
        }
        return name + "\n" + desc + " - " + area + "\n" + ratingString;

    }
}
