// Ariel Lancer 206550030

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * FirstBackground class.
 */
public class FirstBackground implements Sprite {
    private Rectangle block;
    private Ball ball1, ball2, ball3;
    private Point pointOfCenter, firstPointOfSidewaysLine, endPointOfSidewaysLine,
            firstPointOfUpLine, endPointOfUpLIne;

    /**
     * C-tor of FirstBackground.
     *
     * @param b
     */
    public FirstBackground(Rectangle b) {
        this.block = b;
    }

    /**
     * The method is in charge of setting up the image of the background.
     */
    private void setImage() {
        pointOfCenter = new Point((this.block.getWidth()/2)+30, this.block.getHeight() / 4);
        ball1 = new Ball(pointOfCenter, 75, Color.blue);
        ball2 = new Ball(pointOfCenter, 95, Color.blue);
        ball3 = new Ball(pointOfCenter, 115, Color.blue);
        firstPointOfSidewaysLine = new Point(pointOfCenter.getX() - 130, pointOfCenter.getY());
        endPointOfSidewaysLine = new Point(pointOfCenter.getX() + 130, pointOfCenter.getY());
        firstPointOfUpLine = new Point(pointOfCenter.getX(), pointOfCenter.getY() - 130);
        endPointOfUpLIne = new Point(pointOfCenter.getX(), pointOfCenter.getY() + 130);
    }

    /**
     *  Do One Frame on the given surface.
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        setImage();
        d.setColor(Color.black);
        d.fillRectangle((int) this.block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        d.drawRectangle((int) block.getUpperLeft().getX(), (int) block.getUpperLeft().getY(),
                (int) block.getWidth(), (int) block.getHeight());
        d.setColor(Color.blue);
        d.drawCircle(ball1.getX(), ball1.getY(), ball1.getSize());
        d.drawCircle(ball2.getX(), ball2.getY(), ball2.getSize());
        d.drawCircle(ball3.getX(), ball3.getY(), ball3.getSize());
        d.drawLine((int) firstPointOfSidewaysLine.getX(), (int) firstPointOfSidewaysLine.getY(),
                (int) endPointOfSidewaysLine.getX(), (int) endPointOfSidewaysLine.getY());
        d.drawLine((int) firstPointOfUpLine.getX(), (int) firstPointOfUpLine.getY(),
                (int) endPointOfUpLIne.getX(), (int) endPointOfUpLIne.getY());
    }

    /**
     * Is in charge of stop condition.
     */
    @Override
    public void timePassed() {
        return;
    }
}
