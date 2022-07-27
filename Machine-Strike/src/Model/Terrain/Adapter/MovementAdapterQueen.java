package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineQueenEntity;
import Model.AbstractModel.AbstractMachine.Machine;

public class MovementAdapterQueen implements MovementBehaviourAdapter {

    MachineQueenEntity adaptee;

    public MovementAdapterQueen(MachineQueenEntity adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public boolean specialAttack(Machine... machine) {
        adaptee.Stone();
        return false;
    }
}
