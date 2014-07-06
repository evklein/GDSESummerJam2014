package com.hasherr.gdsesummerjam2014.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Evan on 7/6/2014.
 */
public class Powerup extends Entity
{
    public Powerup(Vector2 position)
    {
        super("Sprites/powerup.png", position);
    }

    @Override
    public void update()
    {
        super.update();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        // Same as player class; render so that each sprite appears as a 1x1 unit.
        batch.draw(sprite, position.x, position.y, 0f, 0f, 1f, 1f, 1f, 1f, 0f, 0, 0, 64, 64, false, false);
    }
}
