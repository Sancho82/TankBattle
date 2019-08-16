package accessories;

import java.util.Random;

public class Mover {

    public void moveTanks(Tank[][] tankMatrix) {
        for (int i = 0; i < tankMatrix.length; i++) {
            for (int j = 0; j < tankMatrix[i].length; j++) {

                int number = new Random().nextInt(4);
                Tank tank = tankMatrix[i][j];

                if (number == 0 && tank != null) {
                    if (i == 0 || i == tankMatrix.length - 2) {
                        tankMatrix[i + 1][j] = tank;
                        tankMatrix[i][j] = null;

                    } else if (i == 1 || i == tankMatrix.length - 1) {
                        tankMatrix[i - 1][j] = tank;
                        tankMatrix[i][j] = null;

                    }
                }
            }
        }
    }
}
