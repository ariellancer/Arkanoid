// Ariel Lancer 206550030

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SecLevel class.
 */
public class SecLevel implements LevelInformation {
    private int numOfBlocksToRemove = 15, width, height, blocksWidth, xValueOfLeftPoint, heightInScreenOfBlocks;
    private List<Velocity> list;
    private List<Point> pointList;
    private List<Block> blockList;
    private List<Color> colorList;
    private Point pointOfFrame, point;
    private int paddleSpeed = 2, paddleWidth, numOfBalls = 10;
    private Color color;
    private SecBackground background;

    /**
     * C-tor off SecLevel.
     *
     * @param point
     * @param width
     * @param height
     */
    public SecLevel(Point point, int width, int height) {
        this.pointOfFrame = point;
        this.width = width;
        this.height = height;
        this.paddleWidth= width - 100;
        this.xValueOfLeftPoint= (int) pointOfFrame.getX();
        this.heightInScreenOfBlocks=height/3;
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
        int j = -10;
        list = new ArrayList<Velocity>();
        for (int i = 0; i < numOfBalls; i++) {
            if (j == -6) {
                j = j * (-1);
            }
            list.add(new Velocity(j, - 5));
            j++;
        }
        return list;
    }

    /**
     *  Returns the speed of the paddle.
     *  @return the speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * Returns the width of the paddle.
     * @return the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * Returns the name of the level.
     * @return string of the name of the level.
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     *  Initialize the background of the level.
     *  @return Sprite of the background.
     */
    @Override
    public Sprite getBackground() {
        Rectangle backgroundBlock=new Rectangle(pointOfFrame,(double)width,(double)height);
        background=new SecBackground(backgroundBlock,heightInScreenOfBlocks);
        return background;
    }

    /**
     * Initialize the blocks of the level.
     * @return a list of the blocks of the level.
     */
    @Override
    public List<Block> blocks() {
        int j=0;
        blockList = new ArrayList<Block>();
        pointList=new ArrayList<Point>();
        colorList=new ArrayList<Color>(Arrays.asList(Color.red,Color.orange,Color.yellow,
                Color.green,Color.blue,Color.pink,Color.cyan));
        blocksWidth = width / numOfBlocksToRemove;
        for (int i = 0; i < numOfBlocksToRemove; i++) {
            pointList.add(new Point(xValueOfLeftPoint,heightInScreenOfBlocks));
            xValueOfLeftPoint=xValueOfLeftPoint+blocksWidth;
            blockList.add(new Block(pointList.get(i), (double) blocksWidth, 20.0));
            }
        for (int i=0;i<numOfBlocksToRemove;i=i+2){
            if(i==6){
                blockList.get(i).setColor(colorList.get(j));
                blockList.get(i+1).setColor(colorList.get(j));
                blockList.get(i+2).setColor(colorList.get(j));
                i++;
                j++;
                continue;
            }
            blockList.get(i).setColor(colorList.get(j));
            blockList.get(i+1).setColor(colorList.get(j));
            j++;
        }

        return blockList;
    }

    /**
     * Returns the number of blocks to remove.
     * @return the number of blocks to remove.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.numOfBlocksToRemove;
    }
}
