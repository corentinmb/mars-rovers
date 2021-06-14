package fr.corentinmb.infra;

import java.util.List;

public class MissionReaderMapper {

    private static final String SEPARATOR = " ";

    public static RawMissionValues map(List<String> lines) {
        RawMissionValues rawMissionValues = new RawMissionValues();
        for (int i = 0; i < lines.size(); i++) {
            if(i == 0){
                String header = lines.get(i);
                String[] splittedHeader = header.split(SEPARATOR);
                rawMissionValues.setMaxPlateauX(Integer.parseInt(splittedHeader[0]));
                rawMissionValues.setMaxPlateauY(Integer.parseInt(splittedHeader[1]));
            }
            if(i % 2 == 1){
                String startPosition = lines.get(i);
                String[] splittedStartPosition = startPosition.split(SEPARATOR);
                InstructionGroup instructionGroup = new InstructionGroup();
                instructionGroup.setRoverStartPositionX(Integer.parseInt(splittedStartPosition[0]));
                instructionGroup.setRoverStartPositionY(Integer.parseInt(splittedStartPosition[1]));
                instructionGroup.setOrientation(splittedStartPosition[2]);

                String instructions = lines.get(i+1);
                instructionGroup.setInstructions(instructions);
                rawMissionValues.getInstructionGroup().add(instructionGroup);
            }
        }
        return rawMissionValues;
    }
}
