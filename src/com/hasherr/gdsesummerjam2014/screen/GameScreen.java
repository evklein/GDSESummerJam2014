package com.hasherr.gdsesummerjam2014.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.hasherr.gdsesummerjam2014.core.InputManager;
import com.hasherr.gdsesummerjam2014.entity.Player;
import com.hasherr.gdsesummerjam2014.entity.path.Log;
import com.hasherr.gdsesummerjam2014.level.Level;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public class GameScreen implements Screen
{
    SpriteBatch batch;
    OrthographicCamera camera;
    InputManager inputManager;
    Level level;
    Player player;
    Log log;

    public GameScreen(SpriteBatch batch, OrthographicCamera camera)
    {
        level = new Level("Maps/map.tmx", batch);
        player = new Player("Sprites/player.png", new Vector2(3, 0));
        this.batch = batch;
        this.camera = camera;
        inputManager = new InputManager();
    }

    @Override
    public void render()
    {
        level.drawLevel(camera);
        player.render(batch);
        log = new Log(new Vector2(4, 1), new Vector2(-0.2f, 0f));
        log.render(batch);
        batch.end();
    }

    @Override
    public void update()
    {
        player.update();
        log.update();
        inputManager.handleInput(player);
    }
}
