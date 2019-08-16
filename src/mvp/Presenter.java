package mvp;

import accessories.Tasker;

public class Presenter implements Contract.PresenterIF {

    private View view;
    private Logic logic;

    private Tasker tasker;

    public Presenter(View view) {
        this.view = view;
    }

    public void startGame(String message, int tanksPerArmy) {

        logic = new Logic(message, tanksPerArmy);
        tasker = new Tasker(view, logic);

        view.setMapScreen();
        logic.getLoader().load(logic.getTankMatrix(), logic.getTankList(), logic.getCreator());
        logic.getSerializer().serializeTankList(logic.getTankList());
        view.tankDrawer(logic.getTankMatrix());
        tankMovementController();
    }

    public void tankMovementController() {
        tasker.getTimer().scheduleAtFixedRate(tasker, tasker.getDate(), 1000);
    }

    public void finishGame() {
        tasker.getTimer().cancel();
        view.setEndScreen(logic.checkWinner());
    }
}
