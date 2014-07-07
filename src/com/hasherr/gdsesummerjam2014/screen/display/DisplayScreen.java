package com.hasherr.gdsesummerjam2014.screen.display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hasherr.gdsesummerjam2014.screen.Screen;
import com.hasherr.gdsesummerjam2014.screen.ScreenManager;

/**
 * Created by Evan on 7/6/2014.
 */
public abstract class DisplayScreen extends Screen
{
    protected SpriteBatch batch;
    private OrthographicCamera camera;
    protected ScreenManager managerToRespondTo;
    private Texture screen;

    public DisplayScreen(SpriteBatch batch, OrthographicCamera camera, ScreenManager managerToRespondTo, String displayPath)
    {
        this.batch = batch;
        this.camera = camera;
        this.managerToRespondTo = managerToRespondTo;
        screen = new Texture(displayPath);
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

    protected void fixCamera()
    {
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.setProjectionMatrix(camera.combined);
    }

    protected void unfixCamera()
    {
        camera.setToOrtho(false, Gdx.graphics.getWidth() / (Gdx.graphics.getHeight() / 9f),
                Gdx.graphics.getHeight() / (Gdx.graphics.getHeight() / 9f));
        batch.setProjectionMatrix(camera.combined);
    }
}
