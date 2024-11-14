// Ariel Lancer 206550030

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation class.
 */
public class KeyPressStoppableAnimation implements Animation {
    private boolean stop;
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;

    /**
     * C-tor of KeyPressStoppableAnimation.
     * @param sensor
     * @param key
     * @param animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.keyboardSensor = sensor;
        this.stop = false;
    }

    /**
     * Do One Frame on the given surface.
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * Is in charge of stop condition.
     * @return boolean.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
