package fr.corentinmb.domain;


import fr.corentinmb.exception.InvalidRoverPositionException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoverTest
{
    @Test
    void shouldThrowAnExceptionWhenRoverPositionIsNegative()
    {
        Plateau mars = new Plateau(5,5);

        assertThatThrownBy(() -> new Rover(mars,-10, -10, Orientation.N))
            .isInstanceOf(InvalidRoverPositionException.class);
    }

    @Test
    void shouldThrowAnExceptionWhenRoverPositionIsInvalid()
    {
        Plateau mars = new Plateau(5,5);

        assertThatThrownBy(() -> new Rover(mars,10, 10, Orientation.N))
            .isInstanceOf(InvalidRoverPositionException.class);
    }
}
