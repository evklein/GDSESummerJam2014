package com.hasherr.gdsesummerjam2014.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Evan on 7/4/2014.
 */
public class Game implements ApplicationListener
{
    SpriteBatch batch;
    OrthographicCamera camera;
    TmxMapLoader loader;
    OrthogonalTiledMapRenderer mapRenderer;

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth() / (Gdx.graphics.getHeight() / 9f),
                Gdx.graphics.getHeight() / (Gdx.graphics.getHeight() / 9f));
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        loader = new TmxMapLoader();
        TiledMap map = loader.load("Maps/map.tmx");

        mapRenderer = new OrthogonalTiledMapRenderer(map, 1f / 64f, batch);
        mapRenderer.setView(camera);
    }

    @Override
    public void render()
    {
        clearScreen();
        mapRenderer.render();
        new InputManager().handleInput();
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
