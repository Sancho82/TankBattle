package accessories;

import mvp.Logic;
import mvp.View;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Motion extends TimerTask {

    private Date date;
    private Timer timer;

    private int startingNumber;
    private final int THRESHOLD = 20;
    private Logic logic;
    private View view;

    public Motion(View view, Logic logic) {

        date = new Date();
        timer = new Timer();
        startingNumber = 0;
        this.logic = logic;
        this.view = view;

    }

    public void run() {
        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (startingNumber++ < THRESHOLD) {

            logic.getMover().moveTanks(logic.getTankMatrix());
            view.tankDrawer(logic.getTankMatrix());

        } else {
            timer.cancel();
        }
    }

    public Date getDate() {
        return date;
    }

    public Timer getTimer() {
        return timer;
    }

}