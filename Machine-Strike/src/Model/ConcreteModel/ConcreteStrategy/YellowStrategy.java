package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Armed.SoldierArmedMachine;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadYellow;
import Model.ConcreteModel.BuilderParts.Legs.LegYellow;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponYellow;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoYellow;

public class YellowStrategy extends AbstractStrategy {

    public YellowStrategy() {
        super("Yellow Bot");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadYellow()).addLegs(new LegYellow()).addTorso(new TorsoYellow());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadYellow()).addLegs(new LegYellow()).addTorso(new TorsoYellow()).addRadio(new WeaponYellow());
        return machineBuilder.build();
    }

}