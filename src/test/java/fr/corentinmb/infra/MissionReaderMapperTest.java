package fr.corentinmb.infra;

import fr.corentinmb.domain.Instruction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MissionReaderMapperTest {

    @Test
    void shouldMapListOfStringsToRawMissionValues() {
        List<String> lines = new ArrayList<>();
        lines.add("5 5");
        lines.add("1 1 N");
        lines.add("LLM");

        RawMissionValues rawMissionValues = MissionReaderMapper.map(lines);

        InstructionGroup expectedInstructionGroup = new InstructionGroup();
        expectedInstructionGroup.setRoverStartPositionX(1);
        expectedInstructionGroup.setRoverStartPositionY(1);
        expectedInstructionGroup.setOrientation("N");
        expectedInstructionGroup.setInstructions("LLM");

        RawMissionValues expectedRawMissionValues = new RawMissionValues();
        expectedRawMissionValues.setMaxPlateauX(5);
        expectedRawMissionValues.setMaxPlateauY(5);
        expectedRawMissionValues.getInstructionGroup().add(expectedInstructionGroup);

        Assertions.assertThat(rawMissionValues).isEqualTo(expectedRawMissionValues);
    }

    @Test
    void shouldMapStringToListOfInstructions() {
        String instructions = "LLLMMRR";

        List<Instruction> rawMissionValues = MissionReaderMapper.map(instructions);

        List<Instruction> expectedInstructions = List.of(
            Instruction.L,
            Instruction.L,
            Instruction.L,
            Instruction.M,
            Instruction.M,
            Instruction.R,
            Instruction.R);

        Assertions.assertThat(rawMissionValues).isEqualTo(expectedInstructions);
    }
}
