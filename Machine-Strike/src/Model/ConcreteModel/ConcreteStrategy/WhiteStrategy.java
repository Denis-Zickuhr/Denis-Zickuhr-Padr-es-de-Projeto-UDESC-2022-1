package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadWhite;
import Model.ConcreteModel.BuilderParts.Legs.LegWhite;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponWhite;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoWhite;
import Model.ConcreteModel.Armed.SoldierArmedMachine;

public class WhiteStrategy extends AbstractStrategy {

    public WhiteStrategy() {
        super("Pale Rocker Bot");
    }

    @Override
    public MachineSoldierEntity build() {
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadWhite()).addLegs(new LegWhite()).addTorso(new TorsoWhite());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadWhite()).addLegs(new LegWhite()).addTorso(new TorsoWhite()).addRadio(new WeaponWhite());
        return machineBuilder.build();
    }

}
