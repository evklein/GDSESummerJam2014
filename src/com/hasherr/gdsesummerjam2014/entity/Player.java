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
    public boolean canMove;

    public Player(String spritePath, Vector2 position)
    {
        super(spritePath, position);
        velocity = new Vector2();
        canMove = true;
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(sprite, position.x, position.y, 0f, 0f, 1f, 1f, 1f, 1f, 0f, 0, 0, 64, 64, false, false);
    }

    @Override
    public void update()
    {
        super.update();

        position.x += velocity.x;
        position.y += velocity.y;
//        canMove = true; // Reset canMove for next movement.
    }
}
