package fr.corentinmb.domain;

import fr.corentinmb.exception.InvalidPlateauDimensionsException;


public class Plateau {
    private int[][] grid;

    public Plateau(int sizeX, int sizeY) {
        if(sizeX <= 0 || sizeY <= 0){
            throw new InvalidPlateauDimensionsException();
        }
        this.grid = new int[sizeX][sizeY];
    }

    public boolean isValid(int x, int y) {
        return x <= grid.length && y <= grid[0].length;
    }
}
