package com.hasherr.gdsesummerjam2014.level;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.hasherr.gdsesummerjam2014.entity.Entity;
import com.hasherr.gdsesummerjam2014.entity.path.Path;
import com.hasherr.gdsesummerjam2014.entity.path.PathType;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class Level
{
    private TiledMap map;
    private OrthogonalTiledMapRenderer levelRenderer;
    private int[] pathHeights = { 1, 2, 3, 5, 6, 7 };
    private ArrayList<Path> levelPaths;
    private SpriteBatch batch;

    private Timer timer;
    private Task timerTask;
    private float timerInterval;

    public Level(String pathToMap, SpriteBatch batch, PathType pathType)
    {
        map = new TmxMapLoader().load(pathToMap);
        this.batch = batch;
        levelRenderer = new OrthogonalTiledMapRenderer(map, 1f / 64f, batch); // 1/64
        levelPaths = new ArrayList<>();

        for (int i: pathHeights)
        {
            levelPaths.add(new Path(i, pathType));
        }

        if (pathType == PathType.WATER)
            timerInterval = 1f;
        else
            timerInterval = 5f;

        initiateTimerElements();
    }

    private void initiateTimerElements()
    {
        timer = new Timer();
        timerTask = new Task()
        {
            @Override
            public void run()
            {
                for (Path p: levelPaths)
                {
                    p.generatePathEntity();
                }
            }
        };
        timer.scheduleTask(timerTask, 0f, timerInterval);
        timer.start();
    }

    public void drawLevel(OrthographicCamera camera)
    {
        levelRenderer.setView(camera);
        levelRenderer.render();
        batch.begin();

        for (Path p: levelPaths)
        {
            p.renderPathObjects(batch);
        }
    }

    public void updatePaths()
    {
        for (Path p: levelPaths)
        {
            p.updatePathObjects();
        }
    }

    public ArrayList<Entity> getEntities()
    {
        ArrayList<Entity> entities = new ArrayList<>();
        for (Path p: levelPaths)
        {
            for (Entity e: p.getPathEntities())
            {
                entities.add(e);
            }
        }
        return entities;
    }
}
