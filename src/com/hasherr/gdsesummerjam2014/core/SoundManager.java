package com.hasherr.gdsesummerjam2014.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Evan on 7/6/2014.
 */
public class SoundManager
{
    public void playSound(String soundPath)
    {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal(soundPath));
        sound.play();
    }
}
