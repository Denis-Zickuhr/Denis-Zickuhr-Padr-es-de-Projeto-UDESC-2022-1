package Model.ConcreteModel.ConcreteMachine.Armed;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineKingEntity;

import java.util.Arrays;

public class KingArmedMachine extends MachineKingEntity {

    int ammo = 2;

    @Override
    public String toString() {
        return super.toString() +
                '\u204D' + "" + this.ammo;
    }

    public KingArmedMachine() {
        super();
        setBuffer(new String[]{"Assets\\#kingarmed.png"});
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo){
        this.ammo = ammo;
    }

    public void shoot(){
        this.ammo--;
    }

    public void reload(){
        this.ammo++;
    }

}
