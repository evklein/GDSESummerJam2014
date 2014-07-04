package com.hasherr.gdsesummerjam2014.entity.path;

import com.hasherr.gdsesummerjam2014.entity.Direction;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class Path
{
    Direction moveDirection;

    public Path()
    {

    }

    private Direction generateDirection()
    {
        Direction[] directions = { Direction.RIGHT_TO_LEFT, Direction.LEFT_TO_RIGHT };
        return directions[new Random().nextInt(2)];
    }
}
