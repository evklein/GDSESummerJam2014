package com.hasherr.gdsesummerjam2014.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.hasherr.gdsesummerjam2014.core.InputManager;
import com.hasherr.gdsesummerjam2014.entity.Entity;
import com.hasherr.gdsesummerjam2014.entity.Player;
import com.hasherr.gdsesummerjam2014.entity.path.PathType;
import com.hasherr.gdsesummerjam2014.level.Level;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class GameScreen extends Screen
{
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Level level;
    private Player player;
    private InputManager inputManager;
    public PathType levelType;
    public boolean isReadyForSwitch;

    public GameScreen(SpriteBatch batch, OrthographicCamera camera, PathType levelType)
    {
        this.batch = batch;
        this.camera = camera;

        if (levelType == PathType.WATER)
            level = new Level("Maps/river_map.tmx", batch, levelType);
        else
            level = new Level("Maps/road_map.tmx", batch, levelType);
        player = new Player("Sprites/player.png", new Vector2(5, 0));
        inputManager = new InputManager();
        isReadyForSwitch = false;
        this.levelType = levelType;
    }

    @Override
    public void render()
    {
        /* batch.begin() is never called because for some reason batch.begin() is
         ALREADY called in level's levelRenderer's render() method. (LibGDX)
          */
        level.drawLevel(camera);
        player.render(batch);
        batch.end();
    }

    @Override
    public void update()
    {
        level.updatePaths();
        player.update();
        inputManager.handleInput(player);
        handleLevelHazards();
        handleLevelTypeSwitching();
        handlePowerup();
    }

    private void handlePowerup()
    {
        if (level.getPowerup().boundingBox.overlaps(player.boundingBox))
        {
            level.powerupActivated();
            for (Entity e: level.getEntities())
            {
                e.timeConstant = 0.4f;
            }
        }
    }

    private void handleLevelHazards()
    {
        System.out.println(player.position.y);
        if (levelType == PathType.WATER)
        {
            boolean isOnPlatform = false;
            for (Entity e: level.getEntities())
            {
                if (player.boundingBox.overlaps(e.boundingBox))
                {
                    player.velocity.x = e.velocity.x;
                    isOnPlatform = true;
                }
            }

            int[] hazardY = { 1, 2, 3, 5, 6, 7 };
            for (int y: hazardY)
            {
                for (int x = 0; x < 18; x++)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        if ((int)player.position.x == x && (int)player.position.y == y && !isOnPlatform)
                        {
                            isDisposable = true;
                        }
                    }
                }
            }
        }
        else // Cars.
        {
            for (Entity e: level.getEntities())
            {
                if (player.boundingBox.overlaps(e.boundingBox))
                {
                    isDisposable = true;
                }
            }
        }
    }

    private void handleLevelTypeSwitching()
    {
        if (player.position.y > 8f)
        {
            isReadyForSwitch = true;
        }
    }
}
