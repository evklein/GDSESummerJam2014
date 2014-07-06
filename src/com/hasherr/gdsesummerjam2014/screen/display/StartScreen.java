package com.hasherr.gdsesummerjam2014.screen.display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.hasherr.gdsesummerjam2014.screen.ScreenManager;

/**
 * Created by Evan on 7/6/2014.
 */
public class StartScreen extends DisplayScreen
{
    private Rectangle playButton;
    private Rectangle creditsButton;

    public StartScreen(SpriteBatch batch, OrthographicCamera camera, ScreenManager managerToRespondTo)
    {
        super(batch, camera, managerToRespondTo, "Screens/title_screen.png");

        playButton = new Rectangle(286f, 196f, 257, 87);
        creditsButton = new Rectangle(286f, 301f, 257, 87);
    }

    @Override
    public void update()
    {
        if (Gdx.input.isTouched())
        {
            Vector2 touchPos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            if (playButton.contains(touchPos))
                managerToRespondTo.startGame();
            if (creditsButton.contains(touchPos))
                managerToRespondTo.showCredits();
        }
    }
}
