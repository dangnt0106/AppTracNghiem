package com.example.app.score;

/**
 * Created by NguyenTuan on 11/20/2016.
 */

public class Score {
    private int _id;
    private String name;
    private String room;
    private float score;
    private String date;

    public Score(String name, String room, float score) {
        this.name = name;
        this.room = room;
        this.score = score;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public float getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
