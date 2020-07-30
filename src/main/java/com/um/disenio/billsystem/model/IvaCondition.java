package com.um.disenio.billsystem.model;

public enum IvaCondition {
    RESPONSABLE_INSCRIPTO("Responsable inscripto"),
    MONOTRIBUTISTA("Monotributista"),
    CONSUMIDOR_FINAL("Consumidor final");

    private String condition;

    IvaCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString(){
        return condition;
    }
}
