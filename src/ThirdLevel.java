// Ariel Lancer 206550030

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThirdLevel class.
 */
public class ThirdLevel implements LevelInformation {
    private int numOfBlocksToRemove, width, height, xValueOfLeftPoint, heightInScreenOfBlocks, x;
    private List<Velocity> list;
    private List<Point> pointList;
    private List<Block> blockList;
    private List<Color> colorList;
    private Point pointOfFrame, point;
    private static int PaddleSpeed = 5, PaddleWidth = 60, NumOfBalls =2, BlocksWidth = 40, BlocksHeight = 30;
    private ThirdBackground background;
    private Block block;

    /**
     * ThirdLevel C-tor.
     * @param point
     * @param width
     * @param height
     */
    public ThirdLevel(Point point, int width, int height) {
        this.pointOfFrame = point;
        this.width = width;
        this.height = height;
    }

    /**
     * The method returns the num of balls of the level.
     * @return the num of balls of the level.
     */
    @Override
    public int numberOfBalls() {
        return this.NumOfBalls;
    }

    /**
     *  Initialize the balls velocity.
     *  @return list of the velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        int dy = -3;
        int dx = 4;
        list = new ArrayList<>();
        list.add(new Velocity(-dx, dy));
        list.add(new Velocity(dx, dy));
        return list;
    }

    /**
     * Returns the speed of the paddle.
     * @return the speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return this.PaddleSpeed;
    }

    /**
     * Returns the width of the paddle.
     * @return the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return this.PaddleWidth;
    }

    /**
     * Returns the name of the level.
     * @return string of the name of the level.
     */
    @Override
    public String levelName() {
        return "Green 3";
    }

    /**
     * Initialize the background of the level.
     * @return Sprite of the background.
     */
    @Override
    public Sprite getBackground() {
        Rectangle backgroundBlock = new Rectangle(this.pointOfFrame, (double) width, (double) height);
        background = new ThirdBackground(backgroundBlock, 2 * BlocksWidth);
        return background;
    }

    /**
     * Initialize the blocks of the level.
     * @return a list of the blocks of the level.
     */
    @Override
    public List<Block> blocks() {
        int z = 0;
        this.heightInScreenOfBlocks = height / 2;
        this.xValueOfLeftPoint = width + BlocksHeight - BlocksWidth;
        x = xValueOfLeftPoint;
        colorList = new ArrayList<Color>(Arrays.asList(Color.white, Color.blue, Color.yellow,
                Color.red, Color.gray));
        pointList = new ArrayList<>();
        blockList = new ArrayList<>();
        for (int i = 6; i < 11; i++) {
            for (int j = 0; j < i; j++) {
                block=(new Block(new Point(x, heightInScreenOfBlocks),
                        (double) BlocksWidth, (double) BlocksHeight));
                block.setColor(colorList.get(z));
                blockList.add(block);
                x = x - BlocksWidth;
                numOfBlocksToRemove++;
            }
            z++;
            heightInScreenOfBlocks = heightInScreenOfBlocks - BlocksHeight;
            x = xValueOfLeftPoint;
        }
        return blockList;
    }

    /**
     * Returns the number of blocks to remove.
     * @return the number of blocks to remove.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return numOfBlocksToRemove;
    }
}
