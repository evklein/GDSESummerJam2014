package com.hasherr.gdsesummerjam2014.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.hasherr.gdsesummerjam2014.entity.Player;
import org.lwjgl.input.Keyboard;

/**
 * Created by Evan on 7/4/2014.
 */
public class InputManager
{
    public void handleInput(Player playerToControl)
    {
        if (Gdx.input.isKeyPressed(Keyboard.KEY_W))
        {
            playerToControl.setVelocity(new Vector2(0f, 0.2f));
        }
        else if (Gdx.input.isKeyPressed(Keyboard.KEY_A))
        {
            playerToControl.setVelocity(new Vector2(-0.2f, 0f));
        }
        else if (Gdx.input.isKeyPressed(Keyboard.KEY_S))
        {
            playerToControl.setVelocity(new Vector2(0f, -0.2f));
        }
        else if (Gdx.input.isKeyPressed(Keyboard.KEY_D))
        {
            playerToControl.setVelocity(new Vector2(0.2f, 0f));
        }
        if (!Gdx.input.isKeyPressed(Keyboard.KEY_D) && !Gdx.input.isKeyPressed(Keyboard.KEY_A) &&
                !Gdx.input.isKeyPressed(Keyboard.KEY_S) && !Gdx.input.isKeyPressed(Keyboard.KEY_W))
        {
            System.out.println("turn down for what");
            playerToControl.setVelocity(new Vector2(0f, 0f));
        }
    }
}
