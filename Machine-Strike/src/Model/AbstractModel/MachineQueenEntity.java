package Model.AbstractModel;

import Model.ConcreteModel.Adapter.MovementAdapterQueen;

public abstract class MachineQueenEntity extends Machine {

    public MachineQueenEntity() {
        setHealth(2);
        setAttackPoints(8);
        setAttackDistance(1);
        setMoveSpan(7);
        setMovement(new MovementAdapterQueen(this));
    }

    public void stone(boolean reverse){
        if(reverse){
            destone();
        }else{
            rock();
        }
    }
    private void destone(){
        setHealth(getHealth()-10);
        setHealth(getMoveSpan()+3);
        setSpecial(false);
    }

    private void rock(){
        System.out.println(getHealth()+10);
        setHealth(getHealth()+10);
        setHealth(getMoveSpan()-3);
        setSpecial(true);
    }

}
