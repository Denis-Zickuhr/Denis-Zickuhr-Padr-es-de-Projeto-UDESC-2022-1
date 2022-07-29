package Model.ConcreteModel;

import Model.AbstractModel.Machine;
import Model.AbstractModel.TeamMember;

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

    @Override
    public void blockAttacks() {
        for (Machine machine: getMachines()
        ) {
            machine.blockAttacks();
        }
    }

    @Override
    public void blockMovements() {
        for (Machine machine: getMachines()
        ) {
            machine.blockMovements();
        }
    }

    @Override
    public void reset() {
        for (Machine machine: getMachines()
        ) {
            machine.reset();
        }
    }

    public boolean isBlocked(){
        return (getMovements() + getAttacks()) == 0;
    }

    public void wipe(){
        this.machines.clear();
    }

    public boolean inTurn(Machine machine){
        for (Machine o: machines
             ) {
            if(machine == o){
                System.out.println("Peça em turno");
                return true;
            }
        }
        System.out.println("Peça fora de turno");
        return false;
    }

}
