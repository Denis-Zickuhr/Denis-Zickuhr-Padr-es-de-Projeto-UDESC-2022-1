package Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine;

import Model.AbstractModel.AbstractMachine.Machine;
import Model.Terrain.Adapter.MovementAdapterSoldier;

public abstract class MachineSoldierEntity extends Machine {

    public MachineSoldierEntity(AbstractMachineBuilder machineBuilder) {
        setHealth(machineBuilder.getHealth());
        setAttackPoints(machineBuilder.getAttackPoints());
        setAttackDistance(machineBuilder.getAttackDistance());
        setMoveSpan(machineBuilder.getMoveSpan());
        setArmors(machineBuilder.getArmors());
        setBuffer(machineBuilder.getBuffer());
        setMovement(new MovementAdapterSoldier());
    }
}
