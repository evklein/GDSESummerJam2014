package com.hasherr.gdsesummerjam2014.level;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
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
    SpriteBatch batch;

    Timer timer;
    Task timerTask;

    public Level(String pathToMap, SpriteBatch batch, PathType pathType)
    {
        map = new TmxMapLoader().load(pathToMap);
        this.batch = batch;
        levelRenderer = new OrthogonalTiledMapRenderer(map, 1f / 64f, batch);
        levelPaths = new ArrayList<>();

        for (int i : pathHeights)
        {
            levelPaths.add(new Path(i, pathType));
        }

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
        timer.scheduleTask(timerTask, 0f, 0.5f);
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
}
