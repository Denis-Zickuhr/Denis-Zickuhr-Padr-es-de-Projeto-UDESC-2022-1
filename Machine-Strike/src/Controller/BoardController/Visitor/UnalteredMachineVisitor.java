package Controller.BoardController.Visitor;

import Model.AbstractModel.AbstractMachine.Machine;
import Model.ConcreteModel.ConcreteMachine.Armed.KingArmedMachine;
import Model.ConcreteModel.ConcreteMachine.Basic.KingMachine;
import Model.ConcreteModel.ConcreteMachine.Basic.QueenMachine;
import Model.Terrain.Terrain;

public class UnalteredMachineVisitor implements MachineVisitor{

    Machine machine;

    @Override
    public void visit(Terrain terrain) throws Exception {
        Cloner<Machine> cloner = new Cloner<>(terrain.getMachine());
        machine = cloner.duplicate();
    }

    public Machine getMachine() {
        return machine;
    }

    public MachineAbilities getMachineAbilities(){
        return new MachineAbilities(this.machine);
    }

    public record MachineAbilities(Machine machine) {

        public boolean canMove() {
            return machine.getMoveSpan() > 0 & machine.getMovements() > 0;
        }

        public boolean canAttack() {
            return machine.getAttacks() > 0;
        }

        public boolean canSpecialAttack() {
            return machine.getClass() == KingMachine.class || machine.getClass() == QueenMachine.class || machine.getClass() == KingArmedMachine.class;
        }

        public boolean canCancel() {
            return machine != null;
        }

        public boolean canOvercharge() {
            return !machine.isOvercharged();
        }
    }
}
