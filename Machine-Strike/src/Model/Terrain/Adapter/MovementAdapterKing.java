package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineKingEntity;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public class MovementAdapterKing implements MovementBehaviourAdapter {

    MachineKingEntity adaptee;

    public MovementAdapterKing(MachineKingEntity adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public boolean specialAttack(Machine... machine) {
        adaptee.KingShine();
        return false;
    }
}
