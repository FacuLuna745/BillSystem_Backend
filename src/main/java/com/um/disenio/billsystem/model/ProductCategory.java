package com.um.disenio.billsystem.model;

public enum ProductCategory {
    HOGAR("Hogar"),
    PINTURERIA("Pintureria"),
    CONSTRUCCION("Construccion"),
    CARPINTERIA("Carpinteria"),
    ELECTRICIDAD("Electricidad");

    private String category;

    ProductCategory(String condition) {
        this.category = category;
    }

    @Override
    public String toString(){
        return category;
    }
}
