package com.hasherr.gdsesummerjam2014.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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
        screenManager = new ScreenManager();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth() / (Gdx.graphics.getHeight() / 9f),
                Gdx.graphics.getHeight() / (Gdx.graphics.getHeight() / 9f));
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render()
    {
        clearScreen();
        batch.begin();
        screenManager.render(batch);
        batch.end();
        screenManager.update();
    }

    private void clearScreen()
    {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1.0f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        camera.update();
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }


    @Override
    public void resize(int width, int height) // TODO: Deprecated.
    {
        camera.setToOrtho(false, Gdx.graphics.getWidth() / (Gdx.graphics.getHeight() / 9f),
                Gdx.graphics.getHeight() / (Gdx.graphics.getHeight() / 9f));
    }


    @Override
    public void dispose()
    {

    }
}
