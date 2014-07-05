package com.hasherr.gdsesummerjam2014.entity.path;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
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
    ArrayList<Entity> pathEntities;

    public Path(int yPos, PathType type)
    {
        moveDirection = generateDirection();
        this.type = type;
        this.yPos = yPos;
        pathVelocity = new Random().nextFloat() * (0.7f - 0.1f) + 0.1f;
        if (moveDirection == Direction.RIGHT_TO_LEFT)
            pathVelocity *= -1f;
        pathEntities = new ArrayList<>();
    }

    public void renderPathObjects(SpriteBatch batch)
    {
        for (Entity e: pathEntities)
        {
            e.render(batch);
            e.update();
        }

    }

    private void handleEntityExistances()
    {
        for (Entity e: pathEntities)
        {
            if (e.position.x > 22f || e.position.x < -22f)
            {
                pathEntities.remove(e);
            }
        }
    }

    public void generatePathEntity()
    {
        Entity entity = null;
        Vector2 entityPosition = new Vector2();
        if (moveDirection == Direction.RIGHT_TO_LEFT)
        {
            int randX = new Random().nextInt((20 - 10) + 1) + 10;
            entityPosition.set(randX, yPos);
        }

        if (type == PathType.WATER)
        {
            entity = new Log(entityPosition, new Vector2(0f, pathVelocity));
        }
        else
        {

        }
        pathEntities.add(entity);
    }

    private Direction generateDirection()
    {
        Direction[] directions = { Direction.RIGHT_TO_LEFT, Direction.LEFT_TO_RIGHT };
        return directions[new Random().nextInt(2)];
    }
}
