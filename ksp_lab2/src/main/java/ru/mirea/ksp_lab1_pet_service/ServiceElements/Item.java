package ru.mirea.ksp_lab1_pet_service.ServiceElements;

public class Item {
    private int id;
    private String name;
    private String type;
    private int count;

    public Item(int id, String name, String type, int count) {
        this.id = id;
        this.name = name;
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

    public String getName() { return name; }
}
