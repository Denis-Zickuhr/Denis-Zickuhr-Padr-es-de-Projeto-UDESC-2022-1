package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Armed.SoldierArmedMachine;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Legs.LegBlue;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoBlue;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponBlue;
import Model.ConcreteModel.BuilderParts.Heads.HeadBlue;

public class BlueStrategy extends AbstractStrategy {

    public BlueStrategy() {
        super("Water Bot");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadBlue()).addLegs(new LegBlue()).addTorso(new TorsoBlue());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadBlue()).addLegs(new LegBlue()).addTorso(new TorsoBlue()).addRadio(new WeaponBlue());
        return machineBuilder.build();
    }

}