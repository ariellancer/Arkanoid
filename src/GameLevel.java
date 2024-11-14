// Ariel Lancer 206550030


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Game class.
 */
public class GameLevel implements Animation {
    private static int widthOfGame = 800, heightOfGame = 600, blocksHeight = 30, blocksWidth = 40, paddlesHeight = 10;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Block up, down, left, right, deathRegionBlock;
    private Counter blocksCounter, ballsCounter, scoreCounter;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation level;
    private Ball ball;
    private Point endFramePoint, startFramePoint;


    /**
     * C-tor of GameLevel.
     * @param levelInformation
     * @param keyboard
     * @param animationRunner
     * @param scoreCounter
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard, AnimationRunner animationRunner,
                     Counter scoreCounter) {
        this.level = levelInformation;
        this.keyboard = keyboard;
        this.runner = animationRunner;
        this.scoreCounter = scoreCounter;
    }

    /**
     * @return Game Environment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }

    /**
     * @return Sprite Collection.
     */
    public SpriteCollection getSpriteCollection() {
        return this.sprites;
    }

    /**
     * Adds a collidable to the environment.
     *
     * @param c
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Removes a collidable from the environment.
     *
     * @param c
     */
    public void removeCollidable(Collidable c) {
        GameEnvironment temp = this.environment;
        temp.removeCollidable(c);
    }

    /**
     * Removes a Sprite from the environment.
     *
     * @param s
     */
    public void removeSprite(Sprite s) {
        SpriteCollection temp = this.sprites;
        temp.removeSprite(s);
    }

    /**
     * Adds a Sprite to the collection.
     *
     * @param s
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Creates balls and adds them to the game.
     *
     * @param game
     * @param ballsCounter
     */
    private void createAndAddBalls(GameLevel game, Counter ballsCounter, LevelInformation level) {
        startFramePoint = new Point(widthOfGame - widthOfGame, heightOfGame - heightOfGame);
        endFramePoint = new Point(widthOfGame, heightOfGame);
        for (int i = 0; i < level.numberOfBalls(); i++) {
            ball = new Ball(new Point(widthOfGame / 2, heightOfGame - (2 * blocksHeight) + paddlesHeight - 8),
                    8, Color.yellow);
            ball.setVelocity(level.initialBallVelocities().get(i));
            ball.setGame(game.getGameEnvironment());
            ball.setFrame(startFramePoint, endFramePoint);
            ball.addToGame(game);
            ballsCounter.increase(1);
        }
    }

    /**
     * Creates and adds death-region block to the game.
     *
     * @param game
     * @param width
     * @param height
     * @param ballRemover
     */
    private void deathRegionBlock(GameLevel game, int width, int height, BallRemover ballRemover) {
        int deathRegionBlocksHeight = 1;
        Point point = new Point(blocksHeight, height - blocksHeight - deathRegionBlocksHeight);
        deathRegionBlock = new Block(point, (double) (width - (2 * blocksHeight)), (double) deathRegionBlocksHeight);
        deathRegionBlock.setColor(Color.blue);
        deathRegionBlock.addToGame(game);
        deathRegionBlock.addHitListener(ballRemover);
    }


    /**
     * Creates and add to the game the blocks that our
     * the border of the surface.
     *
     * @param game
     * @param width
     * @param height
     */
    private void blocksOfFrame(GameLevel game, int width, int height) {
        Point leftCorner, upperLeft, upperRight, bottomLeft;
        leftCorner = new Point(width - width, height - height);
        upperLeft = new Point(width - width, blocksHeight);
        upperRight = new Point(width - blocksHeight, blocksHeight);
        bottomLeft = new Point(width - width, height - blocksHeight);
        up = new Block(leftCorner, (double) width, (double) blocksHeight);
        down = new Block(bottomLeft, (double) width, (double) blocksHeight);
        left = new Block(upperLeft, (double) blocksHeight, (double) height - blocksHeight - blocksHeight);
        right = new Block(upperRight, (double) blocksHeight, (double) height - blocksHeight - blocksHeight);
        up.addToGame(game);
        down.addToGame(game);
        left.addToGame(game);
        right.addToGame(game);
    }

    /**
     * Creates and adds blocks to the game.
     *
     * @param game
     * @param width
     * @param height
     * @param blockRemover
     * @param ballRemover
     * @param scoreTrackingListener
     */
    private void createAndAddBlocks(GameLevel game, int width, int height, BlockRemover blockRemover,
                                    BallRemover ballRemover, ScoreTrackingListener scoreTrackingListener,
                                    LevelInformation level) {
        blocksOfFrame(game, width, height);
        deathRegionBlock(game, width, height, ballRemover);
        List<Block> blockList = level.blocks();
        for (int i = 0; i < level.numberOfBlocksToRemove(); i++) {
            blockList.get(i).addToGame(game);
            blockList.get(i).addHitListener(blockRemover);
            blockList.get(i).addHitListener(scoreTrackingListener);
            blockRemover.getCounter().increase(1);
        }
    }

    /**
     * Creates and adds to the game the paddle.
     *
     * @param game
     * @param frameWidthEnd
     * @param frameHeight
     * @param keyboard
     */

    private void createAndAddPaddle(GameLevel game, double frameWidthEnd, double frameHeight, KeyboardSensor keyboard,
                                    LevelInformation level) {
        Point start = new Point((frameWidthEnd - level.paddleWidth() + blocksHeight) / 2,
                frameHeight - blocksHeight + paddlesHeight);
        Paddle paddle = new Paddle(start, (double) level.paddleWidth(), (double) paddlesHeight, keyboard);
        paddle.setSpeed(level.paddleSpeed());
        paddle.setFrame(frameWidthEnd, frameHeight);
        paddle.addToGame(game);
    }

    /**
     * Initialize a new game: create the Blocks and Balls and Paddle
     * and add them to the game.
     */

    public void initialize(LevelInformation level) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blocksCounter = new Counter();
        this.ballsCounter = new Counter();
        this.getSpriteCollection().addSprite(level.getBackground());
        BlockRemover blockRemover = new BlockRemover(this, blocksCounter);
        BallRemover ballRemover = new BallRemover(this, ballsCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(scoreCounter);
        createAndAddBlocks(this, widthOfGame, heightOfGame, blockRemover, ballRemover,
                scoreTrackingListener, level);
        createAndAddPaddle(this, widthOfGame - (blocksHeight), heightOfGame - blocksHeight,
                this.keyboard, level);
        createAndAddBalls(this, ballRemover.getCounterOfBalls(), level);
        ScoreIndicator scoreIndicator = new ScoreIndicator(widthOfGame, blocksHeight / 2, scoreCounter, level);
        scoreIndicator.addToGame(this);
        blockRemover.serFrame(up, down, right, left);

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2,3,this.sprites));
        this.running = true;
        this.runner.run(this);

    }

    /**
     * Returns the num of balls in the level.
     * @return the num of balls in the level.
     */
    public int getNumOfBalls() {
        return this.ballsCounter.getValue();
    }

    /**
     * Returns the num of blocks in the level.
     * @return the num of blocks in the level.
     */
    public int getNumOfBlocks() {
        return this.blocksCounter.getValue();
    }

    /**
     * Do One Frame on the given surface.
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        Point start = new Point(0, 0);
        if (ballsCounter.getValue() == 0) {
            this.running = false;
        }
        if (blocksCounter.getValue() == 0) {
            scoreCounter.increase(100);
            this.running = false;
        }
        d.setColor(Color.blue);
        d.fillRectangle((int) start.getX(), (int) start.getY(), widthOfGame, heightOfGame);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, " ", new PauseScreen()));
        }
    }

    /**
     * Is in charge of stop condition.
     * @return boolean.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
