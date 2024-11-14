// Ariel Lancer 206550030

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * FirstLevel class.
 */
public class FirstLevel implements LevelInformation {
    private int numOfBlocksToRemove=0,width,height;
    private List<Velocity> list;
    private List<Block> blockList;
    private Point pointOfFrame;
    private  int paddleSpeed=5,paddleWidth=60,numOfBalls=1;
    private FirstBackground background;

    /**
     * C-tor of FirstLevel.
     * @param point
     * @param width
     * @param height
     */
    public FirstLevel(Point point,int width,int height){
        this.pointOfFrame=point;
        this.width=width;
        this.height=height;
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
        Velocity v=new Velocity(0,-3);
        list=new ArrayList<>();
        list.add(v);
        return list;
    }

    /**
     * Returns the speed of the paddle.
     * @return the speed of the paddle.
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
        return paddleWidth;
    }

    /**
     * Returns the name of the level.
     * @return string of the name of the level.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * Initialize the background of the level.
     * @return Sprite of the background.
     */
    @Override
    public Sprite getBackground() {
        Rectangle backgroundBlock=new Rectangle(pointOfFrame,(double)width,(double)height);
        background=new FirstBackground(backgroundBlock);
        return background;
    }

    /**
     * Initialize the blocks of the level.
     * @return a list of the blocks of the level.
     */
    @Override
    public List<Block> blocks() {
        blockList=new ArrayList<Block>();
        Point blocksPoint=new Point((this.width/2)+10,(this.height/4)-20);
        Block block=new Block(blocksPoint,(double)40,(double)40);
        block.setColor(Color.red);
        blockList.add(block);
        this.numOfBlocksToRemove++;
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
