package com.hasherr.gdsesummerjam2014.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Evan on 7/6/2014.
 */
public class StartScreen extends Screen
{
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private ScreenManager managerToRespondTo;
    private Texture screen;
    private Rectangle playButton;
    private Rectangle creditsButton;

    public StartScreen(SpriteBatch batch, OrthographicCamera camera, ScreenManager managerToRespondTo)
    {
        this.batch = batch;
        this.camera = camera;
        this.managerToRespondTo = managerToRespondTo;
        screen = new Texture("Screens/title_screen.png");

        playButton = new Rectangle(286f, 196f, 257, 87);
        creditsButton = new Rectangle(286f, 301f, 257, 87);
    }

    @Override
    public void render()
    {
        batch.begin();
        fixCamera();
        batch.draw(screen, 0f, 0f);
        unfixCamera();
        batch.end();
    }

    private void fixCamera()
    {
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.setProjectionMatrix(camera.combined);
    }

    private void unfixCamera()
    {
        camera.setToOrtho(false, Gdx.graphics.getWidth() / (Gdx.graphics.getHeight() / 9f),
                Gdx.graphics.getHeight() / (Gdx.graphics.getHeight() / 9f));
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void update()
    {
        if (Gdx.input.isTouched())
        {
            Vector2 touchPos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            System.out.println(touchPos.x + " " + touchPos.y);
            if (playButton.contains(touchPos))
                managerToRespondTo.startGame(); System.out.println("HOly");
            if (creditsButton.contains(touchPos))
                managerToRespondTo.showCredits();
        }
    }
}
