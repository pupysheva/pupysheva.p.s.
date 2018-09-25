package ru.mirea;
public class Pet {
    int id;
    String type;
    int count;

    public Pet(int id, String type, int count){
        this.id = id;
        this.type = type;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }
}
