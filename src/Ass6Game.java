// Ariel Lancer 206550030

import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * Ass5 class.
 */
public class Ass6Game {
    /**
     * The main of the ass_5 game.
     *
     * @param args
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Game", 800, 600);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        AnimationRunner runner = new AnimationRunner(gui, 60);
        LevelInformation levelInformation;
        Counter scoreCounter = new Counter();
        List<LevelInformation> levels = new ArrayList<>();
        int widthOfLevelsScreen = 740, heightOfGame = 570;
        Point point = new Point(800 - 30 - widthOfLevelsScreen, 600 - heightOfGame);
        if (args.length == 0) {
            levelInformation = new FirstLevel(point, widthOfLevelsScreen, heightOfGame);
            levels.add(levelInformation);
            levelInformation = new SecLevel(point, widthOfLevelsScreen, heightOfGame);
            levels.add(levelInformation);
            levelInformation = new ThirdLevel(point, widthOfLevelsScreen, heightOfGame);
            levels.add(levelInformation);
            levelInformation = new FourthLevel(point, widthOfLevelsScreen, heightOfGame);
            levels.add(levelInformation);
        } else {
            for (String cha : args) {
                switch (cha) {
                    case "1":
                        levelInformation = new FirstLevel(point, widthOfLevelsScreen, heightOfGame);
                        levels.add(levelInformation);
                        break;
                    case "2":
                        levelInformation = new SecLevel(point, widthOfLevelsScreen, heightOfGame);
                        levels.add(levelInformation);
                        break;

                    case "3":
                        levelInformation = new ThirdLevel(point, widthOfLevelsScreen, heightOfGame);
                        levels.add(levelInformation);
                        break;

                    case "4":
                        levelInformation = new FourthLevel(point, widthOfLevelsScreen, heightOfGame);
                        levels.add(levelInformation);
                        break;
                    default:
                        levelInformation = new FirstLevel(point, widthOfLevelsScreen, heightOfGame);
                        levels.add(levelInformation);
                        levelInformation = new SecLevel(point, widthOfLevelsScreen, heightOfGame);
                        levels.add(levelInformation);
                        levelInformation = new ThirdLevel(point, widthOfLevelsScreen, heightOfGame);
                        levels.add(levelInformation);
                        levelInformation = new FourthLevel(point, widthOfLevelsScreen, heightOfGame);
                        levels.add(levelInformation);
                        break;
                }
            }
        }

        GameFlow gameFlow = new GameFlow(runner, keyboardSensor, scoreCounter);
        gameFlow.runLevels(levels);
        gui.close();

    }
}
