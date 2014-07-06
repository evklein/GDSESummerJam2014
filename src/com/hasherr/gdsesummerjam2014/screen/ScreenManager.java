package com.hasherr.gdsesummerjam2014.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class ScreenManager
{
    ArrayList<Screen> currentScreens;

    public ScreenManager(SpriteBatch batch, OrthographicCamera camera)
    {
        currentScreens = new ArrayList<Screen>();
        currentScreens.add(new GameScreen(batch, camera));
    }

    public void render(SpriteBatch batch)
    {
        for (Screen screen : currentScreens)
        {
            screen.render();
        }
    }

    public void update()
    {
        Screen lastScreen = currentScreens.get(currentScreens.size() - 1);
        lastScreen.update();

        if (lastScreen.isDisposable)
        {
            currentScreens.add(new DeathScreen());
        }
    }

    private void pop()
    {
        currentScreens.remove(currentScreens.size() - 1);
    }

    private void push(Screen screenToPush)
    {
        currentScreens.add(currentScreens.size() - 1, screenToPush);
    }
}
