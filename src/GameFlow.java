//Ariel Lancer 206550030

import biuoop.KeyboardSensor;
import java.util.List;

/**
 * GameFlow class.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter scoreCounter;

    /**
     * C-tor of GameFlow.
     * @param ar
     * @param ks
     * @param scoreCounter
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, Counter scoreCounter) {
        this.animationRunner=ar;
        this.keyboardSensor=ks;
        this.scoreCounter=scoreCounter;
    }

    /**
     * The method run the levels.
     * @param levels
     */
    public void runLevels(List<LevelInformation> levels) {
        if (levels==null){
            return;
        }
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner,this.scoreCounter);
            level.initialize(levelInfo);
            while (level.getNumOfBalls()!=0&&level.getNumOfBlocks()!=0){
                level.run();
            }
            if (level.getNumOfBalls()==0){
                this.animationRunner.run(new KeyPressStoppableAnimation(
                        this.keyboardSensor," ",new EndScreen(false,scoreCounter.getValue())));
                break;
            }

        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor," ",
                new EndScreen(true,scoreCounter.getValue())));
    }
}
