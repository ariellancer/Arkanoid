// Ariel Lancer 206550030

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * FourthBackground class.
 */
public class FourthBackground implements Sprite {
    private Rectangle block;
    private int halfHeight, height, width, numOfLines = 10;
    private Ball ball1, ball2, ball3, ball4, ball5;
    private List<Line> listOfLines;
    private Point firstPoint, secPoint;

    /**
     * C-tor of FourthBackground.
     * @param b
     */
    public FourthBackground(Rectangle b) {
        this.block = b;
        height = (int) b.getBottomLeft().getY();
        halfHeight = (int) (b.getBottomLeft().getY() / 2);
        width = (int) b.getBottomRight().getX();
    }

    /**
     * The method is in charge of setting up the left cloud of the background.
     */
    private void setLeftCloud() {
        listOfLines=new ArrayList<>();
        int j = 0;
        ball1 = new Ball(new Point(100, halfHeight + 90), 25, Color.lightGray);
        ball2 = new Ball(new Point(125, halfHeight + 115), 27, Color.lightGray);
        ball3 = new Ball(new Point(150, halfHeight + 85), 32, Color.gray.brighter());
        ball4 = new Ball(new Point(170, halfHeight + 110), 23, Color.gray);
        ball5 = new Ball(new Point(190, halfHeight + 93), 35, Color.gray);
        for (int i = 0; i < numOfLines; i++) {
            firstPoint = new Point(100 + j, halfHeight + 90);
            secPoint = new Point(70 + j, height);
            listOfLines.add(new Line(firstPoint, secPoint));
            j = j + 10;
        }
    }

    /**
     * The method is in charge of setting up the right cloud of the background.
     */
    private void setRightCloud() {
        listOfLines=new ArrayList<>();
        int j = 0;
        ball1 = new Ball(new Point(width - 150, halfHeight + 145), 20, Color.lightGray);
        ball2 = new Ball(new Point(width - 132, halfHeight + 170), 27, Color.lightGray);
        ball3 = new Ball(new Point(width - 108, halfHeight + 145), 32, Color.gray.brighter());
        ball4 = new Ball(new Point(width - 83, halfHeight + 163), 23, Color.gray);
        ball5 = new Ball(new Point(width - 60, halfHeight + 150), 35, Color.gray);
        for (int i = 0; i < numOfLines; i++) {
            firstPoint = new Point(width - 150 + j, halfHeight + 145);
            secPoint = new Point(width - 180 + j, height);
            listOfLines.add(new Line(firstPoint, secPoint));
            j = j + 10;
        }
    }

    /**
     * Do One Frame on the given surface.
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.blue.brighter().brighter());
        d.fillRectangle((int) this.block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        d.drawRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        setLeftCloud();
        d.setColor(Color.white);
        for (int i = 0; i < numOfLines; i++) {
            d.drawLine((int) listOfLines.get(i).start().getX(), (int) listOfLines.get(i).start().getY(),
                    (int) listOfLines.get(i).end().getX(), (int) listOfLines.get(i).end().getY());
        }
        d.setColor(ball1.getColor());
        d.drawCircle(ball1.getX(), ball1.getY(), ball1.getSize());
        d.fillCircle(ball1.getX(), ball1.getY(), ball1.getSize());
        d.drawCircle(ball2.getX(), ball2.getY(), ball2.getSize());
        d.fillCircle(ball2.getX(), ball2.getY(), ball2.getSize());
        d.setColor(ball3.getColor());
        d.drawCircle(ball3.getX(), ball3.getY(), ball3.getSize());
        d.fillCircle(ball3.getX(), ball3.getY(), ball3.getSize());
        d.setColor(ball4.getColor());
        d.drawCircle(ball4.getX(), ball4.getY(), ball4.getSize());
        d.fillCircle(ball4.getX(), ball4.getY(), ball4.getSize());
        d.drawCircle(ball5.getX(), ball5.getY(), ball5.getSize());
        d.fillCircle(ball5.getX(), ball5.getY(), ball5.getSize());
        setRightCloud();
        d.setColor(Color.white);
        for (int i = 0; i < numOfLines; i++) {
            d.drawLine((int) listOfLines.get(i).start().getX(), (int) listOfLines.get(i).start().getY(),
                    (int) listOfLines.get(i).end().getX(), (int) listOfLines.get(i).end().getY());
        }
        d.setColor(ball1.getColor());
        d.drawCircle(ball1.getX(), ball1.getY(), ball1.getSize());
        d.fillCircle(ball1.getX(), ball1.getY(), ball1.getSize());
        d.drawCircle(ball2.getX(), ball2.getY(), ball2.getSize());
        d.fillCircle(ball2.getX(), ball2.getY(), ball2.getSize());
        d.setColor(ball3.getColor());
        d.drawCircle(ball3.getX(), ball3.getY(), ball3.getSize());
        d.fillCircle(ball3.getX(), ball3.getY(), ball3.getSize());
        d.setColor(ball4.getColor());
        d.drawCircle(ball4.getX(), ball4.getY(), ball4.getSize());
        d.fillCircle(ball4.getX(), ball4.getY(), ball4.getSize());
        d.drawCircle(ball5.getX(), ball5.getY(), ball5.getSize());
        d.fillCircle(ball5.getX(), ball5.getY(), ball5.getSize());
        setRightCloud();

    }

    /**
     * Is in charge of stop condition.
     */
    @Override
    public void timePassed() {
        return;
    }
}
