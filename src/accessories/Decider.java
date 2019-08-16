package accessories;

import java.util.List;
import java.util.function.Predicate;

public class Decider {

    public String announceWinner(List<Tank> tankList) {
        String winner = "";

        Predicate<Tank> germanPred = tank -> tank.getNation().equals("Germany");
        Predicate<Tank> americanPred = tank -> tank.getNation().equals("United States");
        Predicate<Tank> sovietPred = tank -> tank.getNation().equals("Soviet Union");

        int germanVal = tankList.stream().filter(germanPred).mapToInt(Tank::getBattleValue).sum();
        int americanVal = tankList.stream().filter(americanPred).mapToInt(Tank::getBattleValue).sum();
        int sovietVal = tankList.stream().filter(sovietPred).mapToInt(Tank::getBattleValue).sum();

        if (germanVal > americanVal && germanVal > sovietVal)  winner = "Germans";
        if (americanVal > germanVal && americanVal > sovietVal)  winner = "Americans";
        if (sovietVal > germanVal && sovietVal > americanVal)  winner = "Soviets";

        return "The " + winner + " are victorious!";
    }
}
