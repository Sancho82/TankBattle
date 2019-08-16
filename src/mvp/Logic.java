package mvp;

import accessories.*;
import music.Music;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    private Music music;
    private Creator creator;
    private Loader loader;
    private Serializer serializer;
    // private Mover mover;
    private Decider decider;

    private List<Tank> tankList;
    private Tank[][] tankMatrix;

    public Logic(String message, int tanksPerArmy) {

        music = new Music();
        creator = new Creator();
        loader = new Loader(message, tanksPerArmy);
        serializer = new Serializer();
        // mover = new Mover();
        decider = new Decider();

        tankList = new ArrayList<>();
        tankMatrix = new Tank[6][tanksPerArmy];
    }

    //region Getters

    public Music getMusic() {
        return music;
    }

    public Creator getCreator() {
        return creator;
    }

    public Loader getLoader() {
        return loader;
    }

    public Serializer getSerializer() {
        return serializer;
    }

    /*
    public Mover getMover() {
        return mover;
    }
    */

    public Decider getDecider() {
        return decider;
    }

    public List<Tank> getTankList() {
        return tankList;
    }

    public Tank[][] getTankMatrix() {
        return tankMatrix;
    }

    //endregion

    public void drawTankMatrix() {
        for (int i = 0; i < tankMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < tankMatrix[i].length; j++) {
                System.out.print(tankMatrix[i][j] == null ? "O" : "T");
            }
        }
        System.out.println();
    }

    public String checkWinner() {

        String winner = decider.announceWinner(tankList);
        return winner;
    }
}
