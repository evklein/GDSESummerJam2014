package com.hasherr.gdsesummerjam2014.level;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class Level
{
    private TiledMap map;
    private OrthogonalTiledMapRenderer levelRenderer;
    private int mapWidth = 18;
    private int mapHeight = 9;

    public Level(String pathToMap, SpriteBatch batch)
    {
        map = new TmxMapLoader().load(pathToMap);
        levelRenderer = new OrthogonalTiledMapRenderer(map, 1f / 64f, batch);
    }

    public void drawLevel(OrthographicCamera camera)
    {
        levelRenderer.setView(camera);
        levelRenderer.render();
    }

    public int getLevelWidth()
    {
        return mapWidth;
    }

    public int getLevelHeight()
    {
        return mapHeight;
    }
}
