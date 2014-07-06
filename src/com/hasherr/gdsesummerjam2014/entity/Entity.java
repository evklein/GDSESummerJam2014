package com.hasherr.gdsesummerjam2014.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Evan on 7/4/2014.
 */
public abstract class Entity
{
    public Texture sprite;
    public Vector2 position;
    public Vector2 velocity;
    public Rectangle boundingBox;
    public float timeConstant = 1f;

    public Entity(String spritePath, Vector2 position)
    {
        sprite = new Texture(spritePath);
        this.position = position;
        boundingBox = new Rectangle();
    }

    public abstract void render(SpriteBatch batch);

    public void update()
    {
        setBoundingBoxBounds();
    }

    private void setBoundingBoxBounds()
    {
        boundingBox.set(position.x, position.y, 1f, 1f);
    }

    public Vector2 getVelocity()
    {
        return velocity;
    }

    public void setVelocity(Vector2 velocity)
    {
        this.velocity = velocity;
    }
}
