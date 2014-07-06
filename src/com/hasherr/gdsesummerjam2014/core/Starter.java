package com.hasherr.gdsesummerjam2014.core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Created by Evan on 7/4/2014.
 */
public class Starter
{
    public static void main(String[] args)
    {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
        configuration.title = "Aesop";
        configuration.width = 854;
        configuration.height = 480;
        configuration.resizable = false;
        configuration.foregroundFPS = 60;
        configuration.useGL20 = true;

        new LwjglApplication(new Game(), configuration); // Start game.
    }
}
