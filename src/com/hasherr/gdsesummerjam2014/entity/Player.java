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
    private boolean canMove;

    public Player(String spritePath, Vector2 position)
    {
        super(spritePath, position);
        velocity = new Vector2();

        canMove = true;
    }

    @Override
    public void render(SpriteBatch batch)
    {
        // Draws the player in a specific way so that he is projected as a 1x1 unit on the level and not
        batch.draw(sprite, position.x, position.y, 0f, 0f, 1f, 1f, 1f, 1f, 0f, 0, 0, 64, 64, false, false);
    }

    @Override
    public void update()
    {
        super.update();

        position.x += velocity.x;
        position.y += velocity.y;
    }

    public boolean canMove()
    {
        return canMove;
    }

    public void setCanMove(boolean canMove)
    {
        this.canMove = canMove;
    }
}
