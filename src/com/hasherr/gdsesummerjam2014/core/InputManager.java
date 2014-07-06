package com.hasherr.gdsesummerjam2014.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.hasherr.gdsesummerjam2014.entity.Player;

/**
 * Created by Evan on 7/4/2014.
 */
public class InputManager
{
    private SoundManager manager;
    public InputManager()
    {
        manager = new SoundManager();
    }

    public void handleInput(Player playerToControl)
    {
        if (playerToControl.canMove())
        {
            if (isKeyDown())
            {
                playerToControl.setCanMove(false);
                manager.playSound("Sounds/jump.wav");
            }

            if (Gdx.input.isKeyPressed(Input.Keys.W))
                playerToControl.position.y += 1f;
            if (Gdx.input.isKeyPressed(Input.Keys.A))
                playerToControl.position.x += -1f;
            if (Gdx.input.isKeyPressed(Input.Keys.S))
                playerToControl.position.y += -1f;
            if (Gdx.input.isKeyPressed(Input.Keys.D))
                playerToControl.position.x += 1f;
        }
        else
        {
            playerToControl.setVelocity(new Vector2(0f, 0f));
            if (!isKeyDown())
            {
                playerToControl.setCanMove(true);
            }
        }
    }

    private boolean isKeyDown() // Determines if the necessary keys for controlling are being pressed.
    {
        boolean result = false;
        int[] keys = { Input.Keys.W, Input.Keys.A, Input.Keys.S, Input.Keys.D };
        for (int key : keys)
        {
            if (Gdx.input.isKeyPressed(key))
            {
                result = true;
            }
        }
        return result;
    }
}
