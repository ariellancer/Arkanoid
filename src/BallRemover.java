// Ariel Lancer 206550030

/**
 * The BallRemover class.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter counterOfBalls;

    /**
     * C-tor of BallRemover.
     * @param game
     * @param removedBalls
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.counterOfBalls = removedBalls;
    }

    /**
     * Returns the Counter of the balls.
     * @return the Counter of the balls.
     */
    public Counter getCounterOfBalls() {
        return this.counterOfBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        counterOfBalls.decrease(1);
    }
}
