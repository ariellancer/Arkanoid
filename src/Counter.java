// Ariel Lancer 206550030

/**
 * Counter class.
 */
public class Counter {
    private int count = 0;
    /**
     * Add number to current count.
     * @param number
     */
    void increase(int number) {
        count = count + number;
    }

    /**
     * Subtract number from current count.
     * @param number
     */
    void decrease(int number) {
        count = count - number;
    }

    /**
     * Get current count.
     * @return current count.
     */
    int getValue() {
        return this.count;
    }
}