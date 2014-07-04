package com.hasherr.gdsesummerjam2014.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class Player extends Entity
{
    public Player()
    {
        position = new Vector2();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(sprite, position.x, position.y, position.x, position.y, 1f, 1f, 1f, 1f, 0f, )
    }

    @Override
    public void update()
    {
        super.update();
    }
}
