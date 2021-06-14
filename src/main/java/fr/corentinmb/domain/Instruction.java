package fr.corentinmb.domain;

public enum Instruction {
    L("Left"),
    R("Right"),
    M("Move forward");

    private final String label;

    Instruction(String label) {
        this.label = label;
    }
}
