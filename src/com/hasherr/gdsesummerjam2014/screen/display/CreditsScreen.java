package com.hasherr.gdsesummerjam2014.screen.display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hasherr.gdsesummerjam2014.screen.ScreenManager;

import java.awt.*;

/**
 * Created by Evan on 7/6/2014.
 */
public class CreditsScreen extends DisplayScreen
{
    private Rectangle backButton;

    public CreditsScreen(SpriteBatch batch, OrthographicCamera camera, ScreenManager managerToRespondTo)
    {
        super(batch, camera, managerToRespondTo, "Screens/credit_screen.png");

        backButton = new Rectangle(639, 382, 153, 70);
    }


    @Override
    public void update()
    {
        if (Gdx.input.isTouched())
        {
            if (backButton.contains(Gdx.input.getX(), Gdx.input.getY()))
            {
                managerToRespondTo.showTitle();
            }
        }
    }
}
