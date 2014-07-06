package com.hasherr.gdsesummerjam2014.screen;

/**
 * Created with IntelliJ IDEA.
 * User: Evan
 * Date: 7/4/14
 */
public abstract class Screen
{
    public boolean isDisposable = false;
    public abstract void render();
    public abstract void update();
}
