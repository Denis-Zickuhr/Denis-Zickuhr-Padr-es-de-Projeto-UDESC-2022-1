package Model.ConcreteModel.Basic;

import Model.AbstractModel.AbstractMachineBuilder;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.BuilderParts.Weapons.Weapon;

public class SoldierMachine extends MachineSoldierEntity {


    public SoldierMachine(MachineBuilder machineBuilder) {
        super(machineBuilder);
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

    public static class MachineBuilder extends AbstractMachineBuilder {

        @Override
        public AbstractMachineBuilder addRadio(Weapon weapon) throws Exception {
            throw new Exception("operation not supported");
        }

        @Override
        public SoldierMachine build() {
            return new SoldierMachine(this);
        }

    }
}
