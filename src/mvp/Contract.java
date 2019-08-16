package mvp;

import accessories.Tank;

public interface Contract {

    interface ViewIF {
        void setSetupScreen();
        void setMapScreen();
        void mapDrawer();
        void tankDrawer(Tank[][] tankMatrix);
        void setEndScreen(String announcement);
    }

    interface PresenterIF {
        void startGame(String message, int tanksPerArmy);
        void tankMovementController();
        void finishGame();
    }
}

