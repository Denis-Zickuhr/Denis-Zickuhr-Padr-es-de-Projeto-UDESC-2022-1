package Model.ConcreteModel.Basic;

import Model.AbstractModel.MachineKingEntity;

public class KingMachine extends MachineKingEntity {

    public KingMachine() {
        super();
        setBuffer(new String[]{"Assets\\#king.png"});
    }

    @Override
    public int getAmmo() {
        return 0;
    }

    @Override
    public void setAmmo(int ammo) {

    }

    @Override
    public void shoot() {

    }

    @Override
    public void reload() {

    }
}
