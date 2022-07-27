package Controller.BoardController.Visitor;

import Model.AbstractModel.AbstractMachine.Machine;
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
}
