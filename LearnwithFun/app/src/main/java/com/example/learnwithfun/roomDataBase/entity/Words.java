package com.example.learnwithfun.roomDataBase.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_table")
public class Words {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String language;
    private String character;
    private String word;
    private int imageID;
    private int splitIndex;

    public Words() {
    }

    public Words( String language, String character, String word, int imageID, int splitLength) {
        this.language = language;
        this.character = character;
        this.word = word;
        this.imageID = imageID;
        this.splitIndex = splitLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getSplitIndex() {
        return splitIndex;
    }

    public void setSplitIndex(int splitIndex) {
        this.splitIndex = splitIndex;
    }
}
