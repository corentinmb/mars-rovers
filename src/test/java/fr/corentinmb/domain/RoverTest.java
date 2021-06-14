package fr.corentinmb.domain;


import fr.corentinmb.exception.InvalidRoverPositionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoverTest
{

    private Plateau mars;

    @BeforeEach
    void beforeEach(){
        mars = new Plateau(5,5);
    }

    @Test
    void shouldThrowAnExceptionWhenRoverPositionIsNegative(){
        assertThatThrownBy(() -> new Rover(mars,-10, -10, Orientation.N))
            .isInstanceOf(InvalidRoverPositionException.class);
    }

    @Test
    void shouldThrowAnExceptionWhenRoverPositionIsInvalid(){
        assertThatThrownBy(() -> new Rover(mars,10, 10, Orientation.N))
            .isInstanceOf(InvalidRoverPositionException.class);
    }

    @ParameterizedTest
    @CsvSource({
        "N,1,2",
        "S,1,0",
        "E,2,1",
        "W,0,1",
    })
    void shouldMoveForwardCorrectlyWithOrientation(
        Orientation orientation,
        int expectedX,
        int expectedY
    ){
        Rover rover = new Rover(mars, 1, 1, orientation);

        rover.executeInstructions(List.of(Instruction.M));

        assertThat(rover.getX()).isEqualTo(expectedX);
        assertThat(rover.getY()).isEqualTo(expectedY);
    }

    @ParameterizedTest
    @CsvSource({
        "N,W",
        "S,E",
        "E,N",
        "W,S",
    })
    void shouldTurnLeftCorrectlyWithOrientation(
        Orientation initialOrientation,
        Orientation expectedOrientation
    ){
        Rover rover = new Rover(mars, 1, 1, initialOrientation);

        rover.executeInstructions(List.of(Instruction.L));

        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
    }

    @ParameterizedTest
    @CsvSource({
        "N,E",
        "S,W",
        "E,S",
        "W,N",
    })
    void shouldTurnRightCorrectlyWithOrientation(
        Orientation initialOrientation,
        Orientation expectedOrientation
    ){
        Rover rover = new Rover(mars, 1, 1, initialOrientation);

        rover.executeInstructions(List.of(Instruction.R));

        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
    }

    @Test
    void shouldExecuteInstructionsCorrectlyFirstInput(){
        Rover rover = new Rover(mars, 1, 2, Orientation.N);

        rover.executeInstructions(
            List.of(
                Instruction.L,
                Instruction.M,
                Instruction.L,
                Instruction.M,
                Instruction.L,
                Instruction.M,
                Instruction.L,
                Instruction.M,
                Instruction.M
            )
        );

        assertThat(rover.getX()).isEqualTo(1);
        assertThat(rover.getY()).isEqualTo(3);
        assertThat(rover.getOrientation()).isEqualTo(Orientation.N);
    }

    @Test
    void shouldExecuteInstructionsCorrectlySecondInput(){
        Rover rover = new Rover(mars, 3, 3, Orientation.E);

        rover.executeInstructions(
            List.of(
                Instruction.M,
                Instruction.M,
                Instruction.R,
                Instruction.M,
                Instruction.M,
                Instruction.R,
                Instruction.M,
                Instruction.R,
                Instruction.R,
                Instruction.M
            )
        );

        assertThat(rover.getX()).isEqualTo(5);
        assertThat(rover.getY()).isEqualTo(1);
        assertThat(rover.getOrientation()).isEqualTo(Orientation.E);
    }
}
