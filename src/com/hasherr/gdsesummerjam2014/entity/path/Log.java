package com.hasherr.gdsesummerjam2014.entity.path;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.hasherr.gdsesummerjam2014.entity.Entity;

/**
 * Created by Evan on 7/4/2014.
 */
public class Log extends Entity
{
    public Log(Vector2 position, Vector2 velocity)
    {
        super("Sprites/log.png", position);
        this.velocity = velocity;
    }

    @Override
    public void update()
    {
        super.update();

        position.x += velocity.x;
    }

    @Override
    public void render(SpriteBatch batch)
    {
        // Same as player class; render so that each sprite appears as a 1x1 unit.
        batch.draw(sprite, position.x, position.y, 0f, 0f, 1f, 1f, 1f, 1f, 0f, 0, 0, 64, 64, false, false);
    }
}
