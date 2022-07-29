package Model.ConcreteModel.Basic;

import Model.AbstractModel.MachineQueenEntity;

public class QueenMachine extends MachineQueenEntity {

    public QueenMachine() {
        super();
        setBuffer(new String[]{"Assets\\#queen.png"});
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
