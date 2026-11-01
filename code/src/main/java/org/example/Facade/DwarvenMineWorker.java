package org.example.Facade;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class DwarvenMineWorker {

    public void wakeUp() {
        System.out.println(String.format("{%s} wakes up sleep.", name()));

    }

    public void goToMine() {
        System.out.println(String.format("{%s} goes to the mine", name()));

    }

    public void goHome() {
        System.out.println(String.format("{%s} goes home.", name()));


    }
    public void goToSleep() {
        System.out.println(String.format("{%s} goes to sleep.", name()));
    }



    private void action(Action action) {
        switch (action) {
            case GO_TO_SLEEP -> goToSleep();
            case WAKE_UP -> wakeUp();
            case GO_HOME -> goHome();
            case GO_TO_MINE -> goToMine();
            case WORK -> work();
            default -> System.out.println("Undefined action");
        }
    }

    public void action(Action... actions) {
        Arrays.stream(actions).forEach(this::action);
    }

    public abstract void work();

    public abstract String name();

    enum Action {
        GO_TO_SLEEP, WAKE_UP, GO_HOME, GO_TO_MINE, WORK
    }
}


class DwarvenTunnelDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println(String.format("{%s} creates another promising tunnel.", name()));
    }

    @Override
    public String name() {
        return "Dwarven tunnel digger";
    }
}

class DwarvenGoldDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println(String.format("{%s} digs for gold.", name()));
    }

    @Override
    public String name() {
        return "Dwarf gold digger";
    }
}
class DwarvenCartOperator extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.println(String.format("{%s} moves gold chunks out of the mine.", name()));

    }

    @Override
    public String name() {
        return "Dwarf cart operator";
    }
}
class Facade{

    private final List<DwarvenMineWorker> workers;

    public Facade() {
        workers = List.of(
                new DwarvenGoldDigger(),
                new DwarvenCartOperator(),
                new DwarvenTunnelDigger());
    }

    public void startNewDay() {
        makeActions(workers, DwarvenMineWorker.Action.WAKE_UP, DwarvenMineWorker.Action.GO_TO_MINE);
    }

    public void digOutGold() {
        makeActions(workers, DwarvenMineWorker.Action.WORK);
    }

    public void endDay() {
        makeActions(workers, DwarvenMineWorker.Action.GO_HOME, DwarvenMineWorker.Action.GO_TO_SLEEP);
    }

    private static void makeActions(Collection<DwarvenMineWorker> workers,
                                    DwarvenMineWorker.Action... actions) {
        workers.forEach(worker -> worker.action(actions));
    }
}

class client{
    public static void main (String [] args){
        var facade = new Facade();
        facade.startNewDay();
        facade.digOutGold();
        facade.endDay();
    }
}