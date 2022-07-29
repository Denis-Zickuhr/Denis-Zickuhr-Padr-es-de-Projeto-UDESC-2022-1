package Model.Terrain.Adapter;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineKingEntity;
import Model.AbstractModel.AbstractMachine.Machine;

public class MovementAdapterKing implements MovementBehaviourAdapter {

    MachineKingEntity adaptee;

    public MovementAdapterKing(MachineKingEntity adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void specialAttack(boolean reverse) {
        if(reverse){
            adaptee.kingDarken();
        }else{
            adaptee.KingShine();
        }
    }
}
