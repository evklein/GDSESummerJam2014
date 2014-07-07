package com.hasherr.gdsesummerjam2014.screen.display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.hasherr.gdsesummerjam2014.screen.ScreenManager;

/**
 * Created by Evan on 7/6/2014.
 */
public class DeathScreen extends DisplayScreen
{
    private Rectangle menuButton;
    private Rectangle replayButton;

    public DeathScreen(SpriteBatch batch, OrthographicCamera camera, ScreenManager managerToRespondTo)
    {
        super(batch, camera, managerToRespondTo, "Screens/death_screen.png");

        menuButton = new Rectangle(540, 329, 202, 88);
        replayButton = new Rectangle(156, 327, 202, 88);
    }

    @Override
    public void update()
    {
        if (Gdx.input.isTouched())
        {
            if (menuButton.contains(Gdx.input.getX(), Gdx.input.getY()))
            {
                managerToRespondTo.showTitle();
                System.out.println("WAT");
            }
            if (replayButton.contains(Gdx.input.getY(), Gdx.input.getY()))
                managerToRespondTo.startGame();
        }
    }
}
