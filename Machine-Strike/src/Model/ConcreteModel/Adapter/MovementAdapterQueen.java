package Model.ConcreteModel.Adapter;

import Model.AbstractModel.MachineQueenEntity;

public class MovementAdapterQueen implements MovementBehaviourAdapter {

    MachineQueenEntity adaptee;

    public MovementAdapterQueen(MachineQueenEntity adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void specialAttack(boolean reverse) {
        adaptee.stone(reverse);
    }
}
