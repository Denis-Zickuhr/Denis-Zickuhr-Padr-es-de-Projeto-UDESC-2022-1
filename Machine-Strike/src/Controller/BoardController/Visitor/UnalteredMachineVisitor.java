package Controller.BoardController.Visitor;

import Model.AbstractModel.Machine;
import Model.ConcreteModel.Armed.KingArmedMachine;
import Model.ConcreteModel.Basic.KingMachine;
import Model.ConcreteModel.Basic.QueenMachine;
import Model.ConcreteModel.Terrain;

import java.util.ArrayList;
import java.util.List;

public class UnalteredMachineVisitor implements MachineVisitor{

    Machine machine;

    @Override
    public void visit(Terrain terrain) throws Exception {
        Cloner<Machine> cloner = new Cloner<>(terrain.getMachine());
        machine = cloner.duplicate();
    }

    public Machine getMachineList() {
        return machine;
    }

    public MachineAbilities getMachineAbilities(){
        return new MachineAbilities(machine);
    }

    public record MachineAbilities(Machine machine) {

        public boolean canMove() {
            return machine.getMoveSpan() > 0 & machine.getMovements() > 0;
        }

        public boolean canAttack() {
            return machine.getAttacks() > 0;
        }

        public boolean canSpecialAttack() {
            return (machine.getClass() == KingMachine.class || machine.getClass() == QueenMachine.class || machine.getClass() == KingArmedMachine.class) & !machine.isSpecial();
        }

        public boolean canLongRange() {
            return machine.getAmmo() > 0;
        }

        public boolean canCancel() {
            return machine != null;
        }

        public boolean canOvercharge() {
            return !machine.isOvercharged();
        }
    }
}
