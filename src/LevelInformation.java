// Ariel Lancer 206550030

import java.util.List;

/**
 * LevelInformation interface.
 */
public interface LevelInformation {
    /**
     * The method returns the num of balls of the level.
     * @return the num of balls of the level.
     */
    int numberOfBalls();

    /**
     *  The initial velocity of each ball.
     * @return list of the velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * Returns the speed of the paddle.
     * @return the speed of the paddle.
     */
    int paddleSpeed();

    /**
     * Returns the width of the paddle.
     * @return the width of the paddle.
     */
    int paddleWidth();

    /**
     * Returns the name of the level.
     * @return string of the name of the level.
     */
    String levelName();

    /**
     * Initialize the background of the level.
     * @return Sprite of the background.
     */
    Sprite getBackground();

    /**
     * Initialize the blocks of the level.
     * @return a list of the blocks of the level.
     */
    List<Block> blocks();

    /**
     * Returns the number of blocks to remove.
     * @return the number of blocks to remove.
     */
    int numberOfBlocksToRemove();
}
