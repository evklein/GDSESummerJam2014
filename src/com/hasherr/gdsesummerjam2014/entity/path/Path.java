package com.hasherr.gdsesummerjam2014.entity.path;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.hasherr.gdsesummerjam2014.entity.Direction;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class Path
{
    Direction moveDirection;
    ArrayList<Cell> tiles;

    public Path(int yPos)
    {
        moveDirection = generateDirection();


    }

    private ArrayList<Cell> getTiles()
    {
        return null;
    }

    private Direction generateDirection()
    {
        Direction[] directions = { Direction.RIGHT_TO_LEFT, Direction.LEFT_TO_RIGHT };
        return directions[new Random().nextInt(2)];
    }
}
