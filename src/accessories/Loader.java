package accessories;

import java.util.List;

public class Loader {

    private String message;
    private int tanksPerArmy;

    public Loader(String message, int tanksPerArmy) {
        this.message = message;
        this.tanksPerArmy = tanksPerArmy;
    }

    public void load(Tank[][] tankMatrix, List<Tank> tankList, Creator creator) {

    }

    public void loadGermanTanks(Tank[][] tankMatrix, List<Tank> tankList, Creator creator) {
        for (int i = 0; i < tanksPerArmy; i++) {
            int random = (int)(Math.random() * 12) + 1;
            Tank tank;

            if (random <= 5) {
                tank = creator.createTank("Panzer3");

            } else if (random <= 8) {
                tank = creator.createTank("Panzer4");

            } else if (random <= 10) {
                tank = creator.createTank("Panther");

            } else if (random <= 11) {
                tank = creator.createTank("Tiger");

            } else {
                tank = creator.createTank("KingTiger");
            }

            tankList.add(tank);

            if (message.equals("US_GE")) {tankMatrix[5][i] = tank;}
            else tankMatrix[0][i] = tank;
        }
    }

    public void loadUSTanks(Tank[][] tankMatrix, List<Tank> tankList, Creator creator) {
        for (int i = 0; i < tanksPerArmy; i++) {
            int random = (int)(Math.random() * 12) + 1;
            Tank tank;

            if (random <= 3) tank = creator.createTank("Grant");
            else if (random <= 10) tank = creator.createTank("Sherman");
            else if (random <= 11) tank = creator.createTank("Firefly");
            else tank = creator.createTank("Pershing");

            tankList.add(tank);
            tankMatrix[0][i] = tank;

        }
    }

    public void loadSovietTanks(Tank[][] tankMatrix, List<Tank> tankList, Creator creator) {
        for (int i = 0; i < tanksPerArmy; i++) {
            int random = (int)(Math.random() * 12) + 1;
            Tank tank;

            if (random <= 2) tank = creator.createTank("KV");
            else if (random <= 4) tank = creator.createTank("KV2");
            else if (random <= 11) tank = creator.createTank("T34");
            else tank = creator.createTank("IS2");

            tankList.add(tank);
            tankMatrix[5][i] = tank;

        }
    }
}
