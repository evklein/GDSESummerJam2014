package com.hasherr.gdsesummerjam2014.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hasherr.gdsesummerjam2014.screen.ScreenManager;

/**
 * Created by Evan on 7/4/2014.
 */
public class Game implements ApplicationListener
{
    SpriteBatch batch;
    OrthographicCamera camera;
    ScreenManager screenManager;

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth() / (Gdx.graphics.getHeight() / 9f),
                Gdx.graphics.getHeight() / (Gdx.graphics.getHeight() / 9f));
        camera.update();
        screenManager = new ScreenManager(batch, camera);
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render()
    {
        clearScreen();
        screenManager.render();
        screenManager.update();
        camera.update();
    }

    private void clearScreen()
    {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1.0f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void pause()
    {
        screenManager.pauseScreen();
    }

    @Override
    public void resume()
    {
        screenManager.unpause();
    }


    @Override
    public void resize(int width, int height) // DEPRECATED: Screen is not resizable.
    {
        camera.setToOrtho(false, Gdx.graphics.getWidth() / (Gdx.graphics.getHeight() / 9f),
                Gdx.graphics.getHeight() / (Gdx.graphics.getHeight() / 9f));
    }


    @Override
    public void dispose()
    {
        batch.dispose();
    }
}
