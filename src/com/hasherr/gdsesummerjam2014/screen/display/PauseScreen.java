package com.hasherr.gdsesummerjam2014.screen.display;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hasherr.gdsesummerjam2014.screen.ScreenManager;

/**
 * Created by Evan on 7/6/2014.
 */
public class PauseScreen extends DisplayScreen
{


    public PauseScreen(SpriteBatch batch, OrthographicCamera camera, ScreenManager managerToRespondTo)
    {
        super(batch, camera, managerToRespondTo, "Screens/pause_screen.png");
    }

    @Override
    public void update()
    {

    }
}
