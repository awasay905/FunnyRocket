package Screens;

public class Screens {
    public static Screen startScreen, gameplayScreen;

    public static void initializeScreens(){
        startScreen = new StartScreen();
        gameplayScreen = new GameplayScreen();
    }
}
