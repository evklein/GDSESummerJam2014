package com.hasherr.gdsesummerjam2014.core;

import com.badlogic.gdx.Gdx;
import com.hasherr.gdsesummerjam2014.entity.Player;

/**
 * Created by Evan on 7/4/2014.
 */
public class InputManager
{
    public void handleInput(Player playerToControl)
    {
        if (Gdx.input.isTouched())
        {
            System.out.println("X: " + Gdx.input.getX() / 64f + " Y: " + Gdx.input.getY() / 64f);
        }


    }
}
