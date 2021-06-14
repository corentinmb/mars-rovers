package fr.corentinmb.domain;


import fr.corentinmb.exception.InvalidPlateauDimensionsException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlateauTest
{
    @Test
    void shouldThrowAnExceptionWhenDimensionsAreEqualToZero()
    {
        assertThatThrownBy(() -> new Plateau(0, 0))
            .isInstanceOf(InvalidPlateauDimensionsException.class);
    }

    @Test
    void shouldThrowAnExceptionWhenDimensionsAreNegative()
    {
        assertThatThrownBy(() -> new Plateau(-10, -10))
            .isInstanceOf(InvalidPlateauDimensionsException.class);
    }
}
