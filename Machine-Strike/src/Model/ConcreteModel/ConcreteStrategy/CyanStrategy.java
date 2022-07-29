package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Armed.SoldierArmedMachine;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadCyan;
import Model.ConcreteModel.BuilderParts.Legs.LegCyan;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponCyan;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoCyan;

public class CyanStrategy extends AbstractStrategy {

    public CyanStrategy() {
        super("Cyan Soldier Bot");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadCyan()).addLegs(new LegCyan()).addTorso(new TorsoCyan());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadCyan()).addLegs(new LegCyan()).addTorso(new TorsoCyan()).addRadio(new WeaponCyan());
        return machineBuilder.build();
    }

}