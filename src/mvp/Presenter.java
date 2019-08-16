package mvp;

public class Presenter implements Contract.PresenterIF {

    private View view;
    private Logic logic;

    public Presenter(View view) {
        this.view = view;
    }

    public void startGame(String message, int tanksPerArmy) {

        logic = new Logic(message, tanksPerArmy);

        view.setMapScreen();
        logic.getLoader().load(logic.getTankMatrix(), logic.getTankList(), logic.getCreator());
        logic.getSerializer().serializeTankList(logic.getTankList());
        view.tankDrawer(logic.getTankMatrix());
        tankMovementController();
    }

    @Override
    public void tankMovementController() {

    }

    public void finishGame() {
        view.setEndScreen(logic.checkWinner());
    }
}
