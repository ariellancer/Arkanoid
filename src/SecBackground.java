// Ariel Lancer 206550030

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * SecBackground class.
 */
public class SecBackground implements Sprite{
    private Rectangle block;
    private int heightInScreenOfBlocks,numOfLines;
    private Ball ball1, ball2, ball3;
    private  Point pointOfCenter,firstPoint;
    private List<Point> listOfPoints;


    /**
     * C-tor of SecBackground.
     * @param b
     * @param heightInScreenOfBlocks
     */
    public SecBackground(Rectangle b,int heightInScreenOfBlocks){
        this.block=b;
        this.heightInScreenOfBlocks=heightInScreenOfBlocks;
    }

    /**
     * The method is in charge of setting up the image of the background.
     */
    private void setImage(){
        listOfPoints=new ArrayList<>();
        pointOfCenter=new Point(block.getUpperLeft().getX()+80,heightInScreenOfBlocks/2);
        ball1=new Ball(pointOfCenter,40, Color.yellow);
        ball2=new Ball(pointOfCenter,47, Color.yellow.darker());
        ball3=new Ball(pointOfCenter,54, Color.yellow.darker().darker());
        for (int i=0;i<block.getWidth();i=i+10){
            firstPoint=new Point(i,heightInScreenOfBlocks);
            listOfPoints.add(firstPoint);
            numOfLines++;
        }
    }

    /**
     * Do One Frame on the given surface.
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        setImage();
        d.setColor(Color.white);
        d.fillRectangle((int) this.block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        d.drawRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        d.setColor(Color.yellow);
        for (int i=0;i<numOfLines;i++){
            d.drawLine((int) listOfPoints.get(i).getX(), (int) listOfPoints.get(i).getY(),
                    (int) pointOfCenter.getX(), (int) pointOfCenter.getY());
        }
        d.setColor(ball3.getColor());
        d.drawCircle(ball3.getX(), ball3.getY(), ball3.getSize());
        d.fillCircle(ball3.getX(),ball3.getY(),ball3.getSize());
        d.setColor(ball2.getColor());
        d.drawCircle(ball2.getX(), ball2.getY(), ball2.getSize());
        d.fillCircle(ball2.getX(),ball2.getY(),ball2.getSize());
        d.setColor(ball1.getColor());
        d.drawCircle(ball1.getX(), ball1.getY(), ball1.getSize());
        d.fillCircle(ball1.getX(),ball1.getY(),ball1.getSize());
        numOfLines=0;
    }

    /**
     * Is in charge of stop condition.
     */
    @Override
    public void timePassed() {
        return;
    }
}
