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
        configuration.resizable = false;
        configuration.useGL20 = true;
        configuration.title = "Tale of Time";
        configuration.width = 854;
        configuration.height = 480;
        configuration.foregroundFPS = 60;
        new LwjglApplication(new Game(), configuration);
    }
}
