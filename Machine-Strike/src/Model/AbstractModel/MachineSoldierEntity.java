package Model.AbstractModel;

import Model.ConcreteModel.Adapter.MovementAdapterSoldier;

public abstract class MachineSoldierEntity<T extends Machine> extends Machine {

    public MachineSoldierEntity(AbstractMachineBuilder machineBuilder) {
        setHealth(machineBuilder.getHealth());
        setAttackPoints(machineBuilder.getAttackPoints());
        setAttackDistance(machineBuilder.getAttackDistance());
        setMoveSpan(machineBuilder.getMoveSpan());
        setBuffer(machineBuilder.getBuffer());
        setMovement(new MovementAdapterSoldier());
    }
}
