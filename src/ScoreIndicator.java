//Ariel Lancer 206550030

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ScoreIndicator class.
 */
public class ScoreIndicator implements Sprite {
    private Counter counter;
    private Color color;
    private int width, height;
    private LevelInformation levelInformation;

    /**
     * C-tor of ScoreIndicator.
     * @param width
     * @param height
     * @param counter
     */
    public ScoreIndicator(int width, int height, Counter counter,LevelInformation level) {
        this.counter = counter;
        this.width = width;
        this.height = height;
        this.color = Color.white;
        this.levelInformation=level;
    }

    /**
     * Add the ScoreIndicator to given game.
     * @param game
     */
    public void addToGame(GameLevel game) {
        game.getSpriteCollection().addSprite(this);
    }

    /**
     * draw the sprite to the screen.
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle(0, 0, width, height);
        d.setColor(Color.black);
        d.drawRectangle(0, 0, width, height);
        d.drawText(width / 3, height, "Score:" + String.valueOf(counter.getValue()), 15);
        d.drawText((width/3)*2,height, levelInformation.levelName(), 15);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
