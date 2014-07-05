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
    public void handleInput(Player playerToControl)
    {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && playerToControl.canMove)
        {
            playerToControl.setVelocity(new Vector2(0f, 0.2f));
            playerToControl.canMove = false;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A) && playerToControl.canMove)
        {
            playerToControl.setVelocity(new Vector2(-0.2f, 0f));
            playerToControl.canMove = false;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S)&& playerToControl.canMove)
        {
            playerToControl.setVelocity(new Vector2(0f, -0.2f));
            playerToControl.canMove = false;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)&& playerToControl.canMove)
        {
            System.out.println("turn down for what");
            playerToControl.setVelocity(new Vector2(0.2f, 0f));
            playerToControl.canMove = false;
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.A) &&
                !Gdx.input.isKeyPressed(Input.Keys.S) && !Gdx.input.isKeyPressed(Input.Keys.D))
        {
            playerToControl.setVelocity(new Vector2(0f, 0f));
            playerToControl.canMove = true;
        }
    }
}
