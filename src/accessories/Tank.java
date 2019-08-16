package accessories;

public class Tank {

    private String type;
    private String nation;
    private String serial;
    private int firepower;
    private int armor;
    private int speed;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getFirepower() {
        return firepower;
    }

    public void setFirepower(int firepower) {
        this.firepower = firepower;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBattleValue() {
        return firepower + armor + speed;
    }

    public String toStringBasic() {
        return "<html>" + this.type + "<br>" + this.serial + "</html>";
    }

    public String toString() {
        return "type: " + this.type
                + ", nation: " + this.nation
                + ", serial: " + this.serial
                + ", firepower: " + this.firepower + " mm"
                + ", armor: " + this.armor + " mm"
                + ", speed: " + this.speed + " km/h";
    }
}
