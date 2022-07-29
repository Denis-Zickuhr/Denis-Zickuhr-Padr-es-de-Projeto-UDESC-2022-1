package Model.AbstractModel;

import Model.ConcreteModel.Adapter.MovementAdapterKing;

public abstract class MachineKingEntity extends Machine {

    public MachineKingEntity() {
        setHealth(3);
        setAttackPoints(5);
        setAttackDistance(1);
        setMoveSpan(3);
        setMovement(new MovementAdapterKing(this));
    }

    public void KingShine(boolean reverse){
        if(reverse){
            kingDarken();
        }else{
            kingLighten();
        }
    }

    private void kingLighten(){
        setHealth(getHealth()+3);
        setAttackPoints(getAttackPoints()+5);
        setAttackDistance(getAttackDistance()+1);
        setMoveSpan(getMoveSpan()+3);
        setSpecial(true);
    }

    private void kingDarken(){
        setHealth(getHealth()-3);
        setAttackPoints(getAttackPoints()-5);
        setAttackDistance(getAttackDistance()-1);
        setMoveSpan(getMoveSpan()-3);
        setSpecial(false);
    }

}
