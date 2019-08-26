package mvp;

import accessories.Motion;
import music.Music;

public class Presenter implements Contract.PresenterIF {

    private View view;
    private Logic logic;

    private Motion motionTasker;
    private Music musicTasker;

    public Presenter(View view) {
        this.view = view;
    }

    public void startGame(String message, int tanksPerArmy) {

        logic = new Logic(message, tanksPerArmy);
        motionTasker = new Motion(view, logic);
        musicTasker = new Music();

        view.setMapScreen();
        logic.getLoader().load(logic.getTankMatrix(), logic.getTankList(), logic.getCreator());
        logic.getSerializer().serializeTankList(logic.getTankList());
        view.tankDrawer(logic.getTankMatrix());
        tankMovementController();
        musicPlayer();
    }

    public void tankMovementController() {
        motionTasker.getTimer().scheduleAtFixedRate(motionTasker, motionTasker.getDate(), 1000);
    }

    public void musicPlayer() {
        musicTasker.getTimer().scheduleAtFixedRate(musicTasker, musicTasker.getDate(), 251000);
    }

    public void finishGame() {
        motionTasker.getTimer().cancel();
        musicTasker.stopMusic();
        view.setEndScreen(logic.checkWinner());
    }
}
