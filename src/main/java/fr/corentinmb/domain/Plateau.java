package fr.corentinmb.domain;

import fr.corentinmb.exception.InvalidPlateauDimensionsException;


public class Plateau {
    private final int maxX;
    private final int maxY;

    public Plateau(int sizeX, int sizeY) {
        if(sizeX <= 0 || sizeY <= 0){
            throw new InvalidPlateauDimensionsException();
        }
        this.maxX = sizeX;
        this.maxY = sizeY;
    }

    public boolean isValid(int x, int y) {
        return x <= maxX && y <= maxY;
    }
}
