package fr.corentinmb.domain;

import fr.corentinmb.exception.InvalidRoverPositionException;
import lombok.Getter;

import java.util.List;

@Getter
public class Rover {
    private static final String SEPARATOR = " ";

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

    public String executeInstructions(List<Instruction> instructions){
        instructions.forEach(this::move);
        return this.getX() + SEPARATOR + this.getY() + SEPARATOR + this.getOrientation();
    }

    private void move(Instruction instruction) {
        switch(instruction){
            case L:
                this.turnLeft();
                break;
            case R:
                this.turnRight();
                break;
            case M:
                this.moveForward();
                break;
        }
    }

    private void moveForward() {
        switch(orientation){
            case N:
                this.y += 1;
                break;
            case S:
                this.y -= 1;
                break;
            case E:
                this.x += 1;
                break;
            case W:
                this.x -= 1;
                break;
        }
    }

    private void turnRight() {
        this.orientation = orientation.next();
    }

    private void turnLeft() {
        this.orientation = orientation.previous();

    }
}
