package ru.mirea.ksp_lab1_pet_service.ServiceElements;

public class Balance {
    private int id;
    private int user_id;
    private float current_balance;

    public Balance(int id, int user_id, float current_balance) {
        this.id = id;
        this.user_id = user_id;
        this.current_balance = current_balance;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public float getCurrent_balance() {
        return current_balance;
    }
}
