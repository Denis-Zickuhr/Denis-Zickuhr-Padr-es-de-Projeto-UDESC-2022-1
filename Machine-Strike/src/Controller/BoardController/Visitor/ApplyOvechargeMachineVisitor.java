package Controller.BoardController.Visitor;

import Model.AbstractModel.AbstractMachine.Machine;
import Model.Terrain.Terrain;

public class ApplyOvechargeMachineVisitor implements MachineVisitor{

    Machine machine;

    @Override
    public void visit(Terrain terrain) throws Exception {
        Cloner<Machine> cloner = new Cloner<>(terrain.getMachine());
        machine = cloner.duplicate();
        machine.setHealth(machine.getHealth()-2);
        machine.resetMovements();
        machine.setMoveSpan(machine.getMoveSpan() + 1);
    }

    public Machine getMachine() {
        return machine;
    }
}
