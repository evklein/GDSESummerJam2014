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
public class GameScreen implements Screen
{
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Level level;
    private Player player;
    private InputManager inputManager;
    private PathType levelType;

    public GameScreen(SpriteBatch batch, OrthographicCamera camera)
    {
        this.batch = batch;
        this.camera = camera;
        levelType = PathType.WATER;

        level = new Level("Maps/map.tmx", batch, levelType);
        player = new Player("Sprites/player.png", new Vector2(3, 0));
        inputManager = new InputManager();
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
    }

    private void handleLevelHazards()
    {
        if (levelType == PathType.WATER)
        {
            for (Entity e : level.getEntities())
            {
                if (player.boundingBox.overlaps(e.boundingBox))
                {
                    player.velocity.x = e.velocity.x;
                }
            }
        }
    }
}
