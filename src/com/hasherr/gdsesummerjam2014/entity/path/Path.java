package com.hasherr.gdsesummerjam2014.entity.path;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.hasherr.gdsesummerjam2014.entity.Direction;
import com.hasherr.gdsesummerjam2014.entity.Entity;

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
    float pathVelocity;
    PathType type;
    int yPos;

    public Path(int yPos, PathType type)
    {
        moveDirection = generateDirection();
        this.type = type;
        this.yPos = yPos;
        pathVelocity = new Random().nextFloat() * (0.7f - 0.1f) + 0.1f;
        if (moveDirection == Direction.RIGHT_TO_LEFT)
            pathVelocity *= -1f;
    }

    public Entity generatePathEntity()
    {
        Entity entity;
        if (type == PathType.WATER)
        {
            entity = new Log()
        }
        else
        {

        }
    }

    private Direction generateDirection()
    {
        Direction[] directions = { Direction.RIGHT_TO_LEFT, Direction.LEFT_TO_RIGHT };
        return directions[new Random().nextInt(2)];
    }
}
