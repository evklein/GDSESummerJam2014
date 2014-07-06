package com.hasherr.gdsesummerjam2014.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.hasherr.gdsesummerjam2014.core.InputManager;
import com.hasherr.gdsesummerjam2014.entity.Player;
import com.hasherr.gdsesummerjam2014.entity.path.Log;
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

    public GameScreen(SpriteBatch batch, OrthographicCamera camera)
    {
        this.batch = batch;
        this.camera = camera;

        level = new Level("Maps/map.tmx", batch, PathType.WATER);
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
        level
        player.update();
        inputManager.handleInput(player);
    }
}
