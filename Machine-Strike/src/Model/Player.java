package Model;

import Model.AbstractModel.AbstractMachine.Machine;

import java.util.ArrayList;
import java.util.List;

public class Player extends TeamMember {

    private final List<Machine> machines = new ArrayList<>(32);

    public Player() {
    }

    public void addMachine(Machine machine) {
        machines.add(machine);
    }

    public void removeMachine(Machine machine) {
        machines.remove(machine);
    }

    public void removeMachine(int index) {
        machines.remove(index);
    }

    public List<Machine> getMachines() {
        return machines;
    }

    @Override
    public int getPoints() {
        int points = 0;
        for (Machine machine: getMachines()
             ) {
            points += machine.getPoints();
        }
        return points;
    }

    @Override
    public int getAttacks() {
        int attacks = 0;
        for (Machine machine: getMachines()
        ) {
            attacks += machine.getAttacks();
        }
        return attacks;
    }

    @Override
    public int getMovements() {
        int movements = 0;
        for (Machine machine: getMachines()
        ) {
            movements += machine.getMovements();
        }
        return movements;
    }

    @Override
    public void resetMovements() {
        for (Machine machine: getMachines()
        ) {
            machine.resetMovements();
        }
    }

    @Override
    public void resetAttacks() {
        for (Machine machine: getMachines()
        ) {
            machine.resetAttacks();
        }
    }

    @Override
    public void block() {
        for (Machine machine: getMachines()
        ) {
            machine.block();
        }
    }

    public boolean isBlocked(){
        return (getMovements() + getAttacks()) == 0;
    }

}
