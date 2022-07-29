package Model.ConcreteModel.Adapter;

import Model.AbstractModel.MachineKingEntity;

public class MovementAdapterKing implements MovementBehaviourAdapter {

    MachineKingEntity adaptee;

    public MovementAdapterKing(MachineKingEntity adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void specialAttack(boolean reverse) {
        adaptee.KingShine(reverse);
    }
}
