package Controller.BoardController.Visitor;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.Terrain.Terrain;

public class AlterMachineVisitor implements MachineVisitor{

    Machine machine;

    @Override
    public void visit(Terrain terrain) {
        machine = terrain.getMachine();
        int statusEffect = terrain.getTerrainType().value();
        machine.setAttackPoints(statusEffect);
        if(machine.getAttackPoints() < 0){
            machine.setAttackPoints(0);
        }
    }

    public Machine getMachine() {
        return machine;
    }
}
