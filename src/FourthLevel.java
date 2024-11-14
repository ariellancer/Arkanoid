// Ariel Lancer 206550030

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FourthLevel class.
 */
public class FourthLevel implements LevelInformation {
    private int numOfBalls = 3, PaddleSpeed = 5, PaddleWidth = 60, numOfBlocks, width, height,
            halfHeight;
    private double blockWidth,blocksHeight,xValueOfLeftPoint, yValueOfLeftPoint;
    private ArrayList<Block> listOfBlocks;
    private ArrayList<Point> pointList;
    private ArrayList<Velocity> list;
    private Rectangle block;
    private FourthBackground background;
    private Point pointOfFrame, point;
    private ArrayList<Color> colorsList;
    private Block b;

    /**
     * C-tor of FourthLevel.
     * @param point
     * @param width
     * @param height
     */
    public FourthLevel(Point point, int width, int height) {
        this.pointOfFrame = point;
        this.width = width;
        this.height = height;
        halfHeight = height / 2;
    }

    /**
     * The method returns the num of balls of the level.
     * @return the num of balls of the level.
     */
    @Override
    public int numberOfBalls() {
        return this.numOfBalls;
    }

    /**
     * Initialize the balls velocity.
     * @return list of the velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        int dy = -3;
        int dx = 7;
        list = new ArrayList<>();
        list.add(new Velocity(0, -3));
        list.add(new Velocity(-dx, dy));
        list.add(new Velocity(dx, dy));
        return list;
    }

    /**
     *  Returns the speed of the paddle.
     *  @return the speed of the paddle.
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
        return "Final Four";
    }

    /**
     * Initialize the background of the level.
     * @return Sprite of the background.
     */
    @Override
    public Sprite getBackground() {
        block = new Rectangle(pointOfFrame, width, height);
        background = new FourthBackground(block);
        return background;
    }

    /**
     * Initialize the blocks of the level.
     * @return a list of the blocks of the level.
     */
    @Override
    public List<Block> blocks() {
        pointList = new ArrayList<>();
        listOfBlocks = new ArrayList<>();
        blockWidth = width / 15;
        blocksHeight = 30.0;
        colorsList = new ArrayList<Color>(Arrays.asList(Color.cyan, Color.pink, Color.white,
                Color.green, Color.yellow, Color.red, Color.gray));
        xValueOfLeftPoint = blocksHeight;
        yValueOfLeftPoint = halfHeight - blocksHeight;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                b = new Block(new Point(xValueOfLeftPoint, yValueOfLeftPoint), (double) blockWidth, (double) blocksHeight);
                b.setColor(colorsList.get(i));
                listOfBlocks.add(b);
                xValueOfLeftPoint = xValueOfLeftPoint + blockWidth;
                numOfBlocks++;
            }
            yValueOfLeftPoint = yValueOfLeftPoint - blocksHeight;
            xValueOfLeftPoint = blocksHeight;
        }
        return listOfBlocks;
    }

    /**
     * Returns the number of blocks to remove.
     * @return the number of blocks to remove.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return numOfBlocks;
    }
}
