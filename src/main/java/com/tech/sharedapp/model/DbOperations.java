package com.tech.sharedapp.model;

public enum DbOperations {
    C("CREATE"),
    R("READ"),
    U("UPDATE"),
    D("DELETE");

    private String operation;

    DbOperations(String operation) {
        this.operation = operation;
    }
}
