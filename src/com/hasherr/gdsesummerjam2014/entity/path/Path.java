package com.hasherr.gdsesummerjam2014.entity.path;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
        pathVelocity = new Random().nextFloat() * (0.09f - 0.03f) + 0.03f;
        if (moveDirection == Direction.RIGHT_TO_LEFT)
            pathVelocity = -pathVelocity;
        pathEntities = new ArrayList<>();
    }

    public void renderPathObjects(SpriteBatch batch)
    {
        for (Entity e: pathEntities)
        {
            e.render(batch);
        }
    }

    public void updatePathObjects()
    {
        for (Entity e: pathEntities)
        {
            e.update();
        }
        handleEntityExistances();
    }

    private void handleEntityExistances()
    {
        for (int i = 0; i < pathEntities.size(); i++) // Use manual for loop because of possible ConcurrentModExcep.
        {
            Entity e = pathEntities.get(i);
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
            int randX = new Random().nextInt((25 - 15) + 1) + 15;
            entityPosition.set(randX, yPos);
        }
        else
        {
            int randX = new Random().nextInt((-2 - -10) + 1) + (-10);
            entityPosition.set(randX, yPos);
        }

        if (type == PathType.WATER)
        {
            entity = new Log(entityPosition, new Vector2(pathVelocity, 0f));
        }
        else
        {
            entity = new Car(entityPosition, new Vector2(pathVelocity, 0f));
        }
        pathEntities.add(entity);
    }

    public ArrayList<Entity> getPathEntities()
    {
        return pathEntities;
    }

    private Direction generateDirection()
    {
        Direction[] directions = { Direction.RIGHT_TO_LEFT, Direction.LEFT_TO_RIGHT };
        int x = new Random().nextInt(2);
        return directions[x];
    }
}
