package fr.corentinmb.domain;

import fr.corentinmb.exception.InvalidRoverPositionException;
import lombok.Data;

@Data
public class Rover {
    private int x;
    private int y;
    private Orientation orientation;

    public Rover(Plateau plateau, int x, int y, Orientation orientation) {
        if(x < 0 || y < 0 || !plateau.isValid(x, y)){
            throw new InvalidRoverPositionException();
        }
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
}
