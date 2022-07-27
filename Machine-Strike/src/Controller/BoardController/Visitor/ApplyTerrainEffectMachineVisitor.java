package Controller.BoardController.Visitor;

import Model.AbstractModel.AbstractMachine.Machine;
import Model.Terrain.Terrain;

public class ApplyTerrainEffectMachineVisitor implements MachineVisitor{

    Machine machine;

    @Override
    public void visit(Terrain terrain) throws Exception {
        Cloner<Machine> cloner = new Cloner<>(terrain.getMachine());
        machine = cloner.duplicate();
        int statusEffect = terrain.getTerrainType().value();
        machine.setAttackPoints(statusEffect + machine.getAttackPoints());
        if(machine.getAttackPoints() < 0){
            machine.setAttackPoints(0);
        }
    }

    public Machine getMachine() {
        return machine;
    }
}
