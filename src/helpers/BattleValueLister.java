package helpers;

import accessories.Creator;
import accessories.Tank;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BattleValueLister {

    public List<Tank> sampleList;
    public Creator sampleCreator;

    public BattleValueLister() {

        sampleList = new ArrayList<>();
        sampleCreator = new Creator();

        fillSampleList();

    }

    public void fillSampleList() {

        sampleList.add(sampleCreator.createTank("Panzer3"));
        sampleList.add(sampleCreator.createTank("Panzer4"));
        sampleList.add(sampleCreator.createTank("Panther"));
        sampleList.add(sampleCreator.createTank("Tiger"));
        sampleList.add(sampleCreator.createTank("KingTiger"));
        sampleList.add(sampleCreator.createTank("Grant"));
        sampleList.add(sampleCreator.createTank("Sherman"));
        sampleList.add(sampleCreator.createTank("Firefly"));
        sampleList.add(sampleCreator.createTank("Pershing"));
        sampleList.add(sampleCreator.createTank("T34"));
        sampleList.add(sampleCreator.createTank("KV"));
        sampleList.add(sampleCreator.createTank("KV2"));
        sampleList.add(sampleCreator.createTank("IS2"));

    }

    public void listStatistics() {

        Consumer<Tank> t1 = tank -> System.out.print(tank.getType() + ": ");
        Consumer<Tank> t2 = tank -> System.out.print(tank.getBattleValue() + "\n");

        for (Tank tank : sampleList) {
            t1.accept(tank);
            t2.accept(tank);
        }
    }
}
