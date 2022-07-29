package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineQueenEntity;

public class MovementAdapterQueen implements MovementBehaviourAdapter {

    MachineQueenEntity adaptee;

    public MovementAdapterQueen(MachineQueenEntity adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void specialAttack(boolean reverse) {
        if(reverse){
            adaptee.destone();
        }
        else{
            adaptee.stone();
        }
    }
}
