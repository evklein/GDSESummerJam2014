package com.hasherr.gdsesummerjam2014.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hasherr.gdsesummerjam2014.entity.path.PathType;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class ScreenManager
{
    private ArrayList<Screen> currentScreens;
    private ArrayList<PathType> levelCycle = new ArrayList<>();
    private SpriteBatch batch;
    private OrthographicCamera camera;

    public ScreenManager(SpriteBatch batch, OrthographicCamera camera)
    {
        currentScreens = new ArrayList<Screen>();
        currentScreens.add(new GameScreen(batch, camera, PathType.WATER));

        this.batch = batch;
        this.camera = camera;

        levelCycle.add(PathType.ROAD);
        levelCycle.add(PathType.WATER);
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
//            currentScreens.add(new DeathScreen());
        }

        if (lastScreen instanceof GameScreen && ((GameScreen) lastScreen).isReadyForSwitch)
        {
            if (((GameScreen) lastScreen).levelType == PathType.WATER)
            {
                currentScreens.clear();
                currentScreens.add(new GameScreen(batch, camera, PathType.ROAD));
            }
            else
            {
                currentScreens.clear();
                currentScreens.add(new GameScreen(batch, camera, PathType.WATER));
            }
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
