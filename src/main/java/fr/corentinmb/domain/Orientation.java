package fr.corentinmb.domain;

public enum Orientation {
    N("North"),
    S("Sus"),
    E("East"),
    W("West");

    private final String label;

    Orientation(String label) {
        this.label = label;
    }
}
