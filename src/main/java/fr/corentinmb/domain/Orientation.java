package fr.corentinmb.domain;

public enum Orientation {
    N("North"),
    E("South"),
    S("East"),
    W("West");

    private final String label;

    Orientation(String label) {
        this.label = label;
    }

    public Orientation next()
    {
        return this.ordinal() < Orientation.values().length - 1
            ? Orientation.values()[this.ordinal() + 1]
            : Orientation.values()[0];
    }

    public Orientation previous()
    {
        return this.ordinal() > 0
            ? Orientation.values()[this.ordinal() - 1]
            : Orientation.values()[Orientation.values().length - 1];
    }
}
