package com.hasherr.gdsesummerjam2014.entity.path;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.hasherr.gdsesummerjam2014.entity.Entity;

/**
 * Created by Evan on 7/6/2014.
 */
public class Car extends Entity
{
    public Car(Vector2 position, Vector2 velocity)
    {
        super("Sprites/car.png", position);
        this.velocity = velocity;
    }

    @Override
    public void render(SpriteBatch batch)
    {
        if (this.velocity.x > 0)
        {
            batch.draw(sprite, position.x, position.y, 0f, 0f, 1f, 1f, 1f, 1f, 0f, 0, 0, 64, 64, false, false);
        }
        else
        {
            batch.draw(sprite, position.x, position.y, 0f, 0f, 1f, 1f, 1f, 1f, 0f, 0, 0, 64, 64, true, false);
        }
    }

    @Override
    public void update()
    {
        super.update();

        position.x += velocity.x * timeConstant;
    }
}
