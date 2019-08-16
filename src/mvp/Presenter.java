package mvp;

public class Presenter implements Contract.PresenterIF {

    private View view;
    private Logic logic;

    public Presenter(View view) {
        this.view = view;
    }

    @Override
    public void startGame(String message, int tanksPerArmy) {

    }

    @Override
    public void tankMovementController() {

    }

    @Override
    public void finishGame() {

    }
}
