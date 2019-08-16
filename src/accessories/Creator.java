package accessories;

public class Creator {

    public Creator() {}

    public Tank createTank(String type) {
        Tank tank = new Tank();

        switch (type) {
            case "Panzer3":     tank.setType("Panzer3");
                tank.setNation("Germany");
                tank.setFirepower(50);
                tank.setArmor(50);
                tank.setSpeed(40);
                break;

            case "Panzer4":     tank.setType("Panzer4");
                tank.setNation("Germany");
                tank.setFirepower(75);
                tank.setArmor(65);
                tank.setSpeed(38);
                break;

            case "Panther":     tank.setType("Panther");
                tank.setNation("Germany");
                tank.setFirepower(75);
                tank.setArmor(90);
                tank.setSpeed(46);
                break;

            case "Tiger":       tank.setType("Tiger");
                tank.setNation("Germany");
                tank.setFirepower(88);
                tank.setArmor(100);
                tank.setSpeed(40);
                break;

            case "KingTiger":   tank.setType("King Tiger");
                tank.setNation("Germany");
                tank.setFirepower(88);
                tank.setArmor(150);
                tank.setSpeed(38);
                break;

            case "Grant":       tank.setType("M3 Grant");
                tank.setNation("United States");
                tank.setFirepower(75);
                tank.setArmor(51);
                tank.setSpeed(42);
                break;

            case "Sherman":     tank.setType("M4 Sherman");
                tank.setNation("United States");
                tank.setFirepower(75);
                tank.setArmor(65);
                tank.setSpeed(41);
                break;

            case "Firefly":     tank.setType("M4 Firefly");
                tank.setNation("United States");
                tank.setFirepower(76);
                tank.setArmor(89);
                tank.setSpeed(32);
                break;

            case "Pershing":    tank.setType("M26 Pershing");
                tank.setNation("United States");
                tank.setFirepower(90);
                tank.setArmor(89);
                tank.setSpeed(48);
                break;

            case "T34":         tank.setType("T34");
                tank.setNation("Soviet Union");
                tank.setFirepower(76);
                tank.setArmor(56);
                tank.setSpeed(53);
                break;

            case "KV":          tank.setType("KV");
                tank.setNation("Soviet Union");
                tank.setFirepower(76);
                tank.setArmor(85);
                tank.setSpeed(35);
                break;

            case "KV2":         tank.setType("KV2");
                tank.setNation("Soviet Union");
                tank.setFirepower(152);
                tank.setArmor(93);
                tank.setSpeed(25);
                break;

            case "IS2":         tank.setType("IS2");
                tank.setNation("Soviet Union");
                tank.setFirepower(122);
                tank.setArmor(110);
                tank.setSpeed(37);
                break;
        }

        return tank;
    }
}
