package com.um.disenio.billsystem.model;

public enum TypeBill {
    A ("A"),
    B ("B"),
    C ("C");

    private String type;

    TypeBill(String condition) {
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
