package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadRed;
import Model.ConcreteModel.BuilderParts.Legs.LegRed;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponRed;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoRed;
import Model.ConcreteModel.Armed.SoldierArmedMachine;

public class RedStrategy extends AbstractStrategy {

    public RedStrategy() {
        super("Crimson Robot");
    }

    @Override
    public MachineSoldierEntity build() {
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadRed()).addLegs(new LegRed()).addTorso(new TorsoRed());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadRed()).addLegs(new LegRed()).addTorso(new TorsoRed()).addRadio(new WeaponRed());
        return machineBuilder.build();
    }

}
