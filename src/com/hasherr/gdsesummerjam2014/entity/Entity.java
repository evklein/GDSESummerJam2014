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
    Texture sprite;
    Vector2 position;
    Vector2 velocity;
    Rectangle boundingBox;

    public void render(SpriteBatch batch)
    {

    }

    public void update()
    {

    }
}
