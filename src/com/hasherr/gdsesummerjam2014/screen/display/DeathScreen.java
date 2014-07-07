package com.hasherr.gdsesummerjam2014.screen.display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.hasherr.gdsesummerjam2014.screen.ScreenManager;



/**
 * Created by Evan on 7/6/2014.
 */
public class DeathScreen extends DisplayScreen
{
    private int score;
    private Preferences preferences;
    private BitmapFont scoreFont;
    private Rectangle menuButton;
    private Rectangle replayButton;

    public DeathScreen(SpriteBatch batch, OrthographicCamera camera, ScreenManager managerToRespondTo, int score)
    {
        super(batch, camera, managerToRespondTo, "Screens/death_screen.png");

        this.score = score;
        preferences = Gdx.app.getPreferences("scores");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Fonts/Spoutnik.ttf"));
        scoreFont = generator.generateFont(50);

        menuButton = new Rectangle(540, 329, 202, 88);
        replayButton = new Rectangle(156, 327, 202, 88);
    }

    @Override
    public void render()
    {
        super.render();
        batch.begin();
        fixCamera();
        scoreFont.draw(super.batch, Integer.toString(score), 473, 480 - 85);
        scoreFont.draw(super.batch, Integer.toString(preferences.getInteger("high_score")), 500, 480 - 135);
        unfixCamera();
        batch.end();
    }

    @Override
    public void update()
    {
        manageHighScore();
        if (Gdx.input.isTouched())
        {
            if (menuButton.contains(Gdx.input.getX(), Gdx.input.getY()))
            {
                managerToRespondTo.showTitle();
                System.out.println("WAT");
            }
            if (replayButton.contains(Gdx.input.getY(), Gdx.input.getY()))
                managerToRespondTo.startGame();
        }
    }

    private void manageHighScore()
    {
        int highScore = preferences.getInteger("high_score");
        if (score > highScore)
            preferences.putInteger("high_score", score);
        preferences.flush();
    }
}
