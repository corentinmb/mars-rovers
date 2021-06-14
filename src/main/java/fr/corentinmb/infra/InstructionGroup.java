package fr.corentinmb.infra;

import lombok.Data;

@Data
public class InstructionGroup {
    private int roverStartPositionX;
    private int roverStartPositionY;
    private String orientation;
    private String instructions;
}
