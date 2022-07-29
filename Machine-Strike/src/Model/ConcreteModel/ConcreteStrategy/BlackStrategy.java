package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Armed.SoldierArmedMachine;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadBlack;
import Model.ConcreteModel.BuilderParts.Legs.LegBlack;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponBlack;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoBlack;

public class BlackStrategy extends AbstractStrategy {

    public BlackStrategy() {
        super("Dark Robot");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadBlack()).addLegs(new LegBlack()).addTorso(new TorsoBlack());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadBlack()).addLegs(new LegBlack()).addTorso(new TorsoBlack()).addRadio(new WeaponBlack());
        return machineBuilder.build();
    }

}
