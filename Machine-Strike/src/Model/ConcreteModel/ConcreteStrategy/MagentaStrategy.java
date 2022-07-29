package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Armed.SoldierArmedMachine;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadMagenta;
import Model.ConcreteModel.BuilderParts.Legs.LegMagenta;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponMagenta;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoMagenta;

public class MagentaStrategy extends AbstractStrategy {

    public MagentaStrategy() {
        super("Magenta Droid");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadMagenta()).addLegs(new LegMagenta()).addTorso(new TorsoMagenta());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadMagenta()).addLegs(new LegMagenta()).addTorso(new TorsoMagenta()).addRadio(new WeaponMagenta());
        return machineBuilder.build();
    }

}