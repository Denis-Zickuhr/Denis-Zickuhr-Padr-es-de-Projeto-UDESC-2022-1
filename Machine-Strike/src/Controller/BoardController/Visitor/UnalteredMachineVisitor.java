package Controller.BoardController.Visitor;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.Terrain.Terrain;

public class UnalteredMachineVisitor implements MachineVisitor{

    Machine machine;

    @Override
    public void visit(Terrain terrain) {
        machine = terrain.getMachine();
    }

    public Machine getMachine() {
        return machine;
    }
}
