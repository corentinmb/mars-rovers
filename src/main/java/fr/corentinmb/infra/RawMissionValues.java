package fr.corentinmb.infra;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RawMissionValues {
    private int maxPlateauX;
    private int maxPlateauY;
    private final List<InstructionGroup> instructionGroup = new ArrayList<>();
}
