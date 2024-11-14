// Ariel Lancer 206550030

/**
 * The BlockRemover class.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    private Block up, down, right, left;

    /**
     * C-tor of BlockRemover.
     *
     * @param game
     * @param removedBlocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * The method checks if the Collidable is onw of the frame blocks.
     *
     * @param c
     * @return true if it is one of them, else returns false.
     */
    private boolean isFrameBlock(Collidable c) {
        if (c == up || c == down || c == left || c == right) {
            return true;
        }
        return false;
    }

    /**
     * Set the blocks of the frame.
     *
     * @param up
     * @param down
     * @param right
     * @param left
     */
    public void serFrame(Block up, Block down, Block right, Block left) {
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }

    /**
     * Returns the counter of the blocks.
     * @return the counter of the blocks.
     */
    public Counter getCounter() {
        return this.remainingBlocks;
    }

    /**
     * Removes the block from the game, and decreases the number
     * of blocks in the counter.
     * @param beingHit
     * @param hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (!isFrameBlock(beingHit)) {
            beingHit.removeFromGame(game);
            remainingBlocks.decrease(1);
        }
    }
}
