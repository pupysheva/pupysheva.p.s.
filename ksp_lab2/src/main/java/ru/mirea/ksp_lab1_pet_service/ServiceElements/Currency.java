package ru.mirea.ksp_lab1_pet_service.ServiceElements;

public class Currency {
    //Коэффициент от основной валюты. Например, для рубля это 1/68
    private double multiplicator;

    public Currency(double multiplicator) {
        multiplicator = multiplicator;
    }

    public double getMultiplicator() {
        return multiplicator;
    }
}
