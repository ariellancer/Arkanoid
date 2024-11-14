// Ariel Lancer 206550030

import biuoop.DrawSurface;

/**
 * EndScreen class.
 */
public class EndScreen implements Animation {
    private boolean win;
    private int score;
    private boolean stop;

    /**
     * C-tor of EndScreen.
     *
     * @param win
     * @param score
     */
    public EndScreen(boolean win, int score) {
        this.score = score;
        this.win = win;
        this.stop = false;
    }

    /**
     * Do One Frame on the given surface.
     *
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (win == true) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score, 32);
        }
        if (win == false) {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + score, 32);
        }
    }

    /**
     * Is in charge of stop condition.
     * @return
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
