package com.example.simplehotel.util;

public enum BookingStatus {
    ACTUAL("actual"),DELETED("deleted"),ALL("all");
    private String value;

    public String getValue() {
        return value;
    }

    BookingStatus(String value) {
        this.value = value;
    }
}
