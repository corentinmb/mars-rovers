package fr.corentinmb;

import fr.corentinmb.domain.Instruction;
import fr.corentinmb.domain.Orientation;
import fr.corentinmb.domain.Plateau;
import fr.corentinmb.domain.Rover;
import fr.corentinmb.infra.InstructionGroup;
import fr.corentinmb.infra.MissionReader;
import fr.corentinmb.infra.MissionReaderMapper;
import fr.corentinmb.infra.RawMissionValues;

import java.io.IOException;
import java.util.List;

public class App
{

    public static void main(String[] args ) throws IOException {
        RawMissionValues rawMissionValues = MissionReader.readMission(args[0]);

        Plateau plateau = new Plateau(rawMissionValues.getMaxPlateauX(), rawMissionValues.getMaxPlateauY());

        for (InstructionGroup ig : rawMissionValues.getInstructionGroup()) {
            Rover rover = new Rover(
                plateau,
                ig.getRoverStartPositionX(),
                ig.getRoverStartPositionY(),
                Orientation.valueOf(ig.getOrientation()));

            List<Instruction> instructions = MissionReaderMapper.map(ig.getInstructions());

            System.out.println(rover.executeInstructions(instructions));
        }
    }
}
