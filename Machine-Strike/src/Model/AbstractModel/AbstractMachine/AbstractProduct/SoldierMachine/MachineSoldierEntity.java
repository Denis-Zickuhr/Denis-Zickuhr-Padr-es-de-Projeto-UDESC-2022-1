package Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.Terrain.Adapter.MovementAdapterKing;
import Model.Terrain.Adapter.MovementAdapterSoldier;

import java.util.Arrays;

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
