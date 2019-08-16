package accessories;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Serializer {

    public void serializeTankList(List<Tank> tankList) {

        for(Tank tank: tankList) {
            stampSerial(tank, tankList);
        }
    }

    public boolean serialExists(String serial, List<Tank> tankList) {
        List<String> serialList = tankList.stream()
                .filter(tank -> tank.getSerial() != null)
                .map(Tank::getSerial)
                .collect(Collectors.toList());

        return serialList.contains(serial);
    }

    public void stampSerial(Tank tank, List<Tank> tankList) {
        String serial = new Random().nextInt(500) + 1 + "";
        if (tank.getNation().equals("Germany")) {
            serial = "GE" + serial;

        } else if(tank.getNation().equals("United States")) {
            serial = "US" + serial;

        } else if(tank.getNation().equals("Soviet Union")) {
            serial = "SU" + serial;
        }

        if (!serialExists(serial, tankList)) {
            tank.setSerial(serial);

        } else {
            stampSerial(tank, tankList);
        }
    }
}
