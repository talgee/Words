package com.example.demo.Entities;

public class Words {

    public long id;
    public String word;
    public int asciiValue ;
    public int difference ;

    public Words(){
    }

    public long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public int getAsciiValue() {
        return this.asciiValue;
    }

    public int getDifference() {
        return difference;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setAsciiValue(int asciiValue) {
        this.asciiValue = asciiValue;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public Words(long id, String word){

        this.word = word;
        this.id = id;
        this.asciiValue = asciiValue(word);
        this.difference = 0;
    }

    public static int asciiValue(String string){
        int sum = 0;

        for (int i = 0; i < string.length(); i++) {
            sum = sum + (int)string.charAt(i);
        }

        return sum;
    }

}
