// Ariel Lancer 206550030

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * ThirdBackground class.
 */
public class ThirdBackground implements Sprite {
    private int xValueOfPointOfBigBlock, yValueOfPointOfBigBlock, widthOfBigBlock,widthOfWindows,heightOfWindows,
            numOfWindows, heightOfBigBlock, temp1,temp2,x,y;
    private Rectangle block, blockOfImage;
    private Point point;
    private List<Rectangle> listOfBlocks, windows;
    private Ball ball1, ball2, ball3;

    /**
     * ThirdBackground C-tor.
     * @param b
     * @param xOfFirstBlock
     */
    public ThirdBackground(Rectangle b, int xOfFirstBlock) {
        this.block = b;
        this.xValueOfPointOfBigBlock = xOfFirstBlock;
    }

    /**
     * The method is in charge of setting up the big block of the background.
     */
    private void setFirstBlock() {
        widthOfBigBlock = 2 * xValueOfPointOfBigBlock;
        widthOfWindows= widthOfBigBlock /12;
        heightOfBigBlock = 3 * xValueOfPointOfBigBlock;
        heightOfWindows= heightOfBigBlock /6;
        yValueOfPointOfBigBlock = (int) this.block.getHeight() - (heightOfBigBlock);
        point = new Point(xValueOfPointOfBigBlock, yValueOfPointOfBigBlock);
        blockOfImage = new Rectangle(point, widthOfBigBlock, heightOfBigBlock);
    }

    /**
     * The method is in charge of setting up the other blocks of the background.
     * @return list of blocks.
     */
    private List<Rectangle> setSecBlocks() {
        listOfBlocks = new ArrayList<>();
        temp1 = (widthOfBigBlock- widthOfWindows) / 9;
        x = xValueOfPointOfBigBlock + temp1;
        temp2 = (heightOfBigBlock-heightOfWindows) / 20;
        y = yValueOfPointOfBigBlock + temp2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                blockOfImage = new Rectangle(new Point(x, y), widthOfWindows, heightOfWindows);
                listOfBlocks.add(blockOfImage);
                x = x + widthOfWindows+temp1;
                numOfWindows++;
            }
            x = x - (5 * (widthOfWindows+temp1));
            y = y + heightOfWindows+temp2;
        }
        return listOfBlocks;
    }

    /**
     * Do One Frame on the given surface.
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green.darker());
        d.fillRectangle((int) this.block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        d.drawRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        d.setColor(Color.black);
        setFirstBlock();
        d.fillRectangle((int) this.blockOfImage.getUpperLeft().getX(), (int) this.blockOfImage.getUpperLeft().getY(),
                (int) this.blockOfImage.getWidth(), (int) this.blockOfImage.getHeight());
        d.drawRectangle((int) this.blockOfImage.getUpperLeft().getX(), (int) this.blockOfImage.getUpperLeft().getY(),
                (int) this.blockOfImage.getWidth(), (int) this.blockOfImage.getHeight());
        d.setColor(Color.white);
        windows = setSecBlocks();
        for (int i = 0; i < numOfWindows; i++) {
            d.fillRectangle((int) windows.get(i).getUpperLeft().getX(), (int) windows.get(i).getUpperLeft().getY(),
                    (int) windows.get(i).getWidth(), (int) windows.get(i).getHeight());
            d.drawRectangle((int) windows.get(i).getUpperLeft().getX(), (int) windows.get(i).getUpperLeft().getY(),
                    (int) windows.get(i).getWidth(), (int) windows.get(i).getHeight());
        }
        numOfWindows=0;
        d.setColor(Color.gray.darker().darker());
        x=xValueOfPointOfBigBlock + (widthOfBigBlock/2)-15;
        y= yValueOfPointOfBigBlock-60;
        blockOfImage=new Rectangle(new Point(x,y),30,60);
        d.fillRectangle((int) this.blockOfImage.getUpperLeft().getX(), (int) this.blockOfImage.getUpperLeft().getY(),
                (int) this.blockOfImage.getWidth(), (int) this.blockOfImage.getHeight());
        d.drawRectangle((int) this.blockOfImage.getUpperLeft().getX(), (int) this.blockOfImage.getUpperLeft().getY(),
                (int) this.blockOfImage.getWidth(), (int) this.blockOfImage.getHeight());
        d.setColor(Color.gray.darker());
        x=x+10;
        y=y-150;
        blockOfImage=new Rectangle(new Point(x,y),10,150);
        d.fillRectangle((int) this.blockOfImage.getUpperLeft().getX(), (int) this.blockOfImage.getUpperLeft().getY(),
                (int) this.blockOfImage.getWidth(), (int) this.blockOfImage.getHeight());
        d.drawRectangle((int) this.blockOfImage.getUpperLeft().getX(), (int) this.blockOfImage.getUpperLeft().getY(),
                (int) this.blockOfImage.getWidth(), (int) this.blockOfImage.getHeight());
        x= xValueOfPointOfBigBlock + (widthOfBigBlock/2);
        y=y-9;
        ball1=new Ball(new Point(x,y),12,Color.yellow.darker());
        ball2=new Ball(new Point(x,y),8,Color.red);
        ball3=new Ball(new Point(x,y),4,Color.white);
        d.setColor(ball1.getColor());
        d.drawCircle(ball1.getX(), ball1.getY(), ball1.getSize());
        d.fillCircle(ball1.getX(), ball1.getY(), ball1.getSize());
        d.setColor(ball2.getColor());
        d.drawCircle(ball2.getX(), ball2.getY(), ball2.getSize());
        d.fillCircle(ball2.getX(), ball2.getY(), ball2.getSize());
        d.setColor(ball3.getColor());
        d.drawCircle(ball3.getX(), ball3.getY(), ball3.getSize());
        d.fillCircle(ball3.getX(), ball3.getY(), ball3.getSize());
    }

    /**
     * Is in charge of stop condition.
     */
    @Override
    public void timePassed() {
        return;
    }
}
