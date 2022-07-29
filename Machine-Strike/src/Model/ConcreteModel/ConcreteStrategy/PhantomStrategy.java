package Model.ConcreteModel.ConcreteStrategy;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.MachineSoldierEntity;
import Model.ConcreteModel.Basic.SoldierMachine;
import Model.ConcreteModel.BuilderParts.Heads.HeadPhantom;
import Model.ConcreteModel.BuilderParts.Legs.LegPhantom;
import Model.ConcreteModel.BuilderParts.Weapons.WeaponPhantom;
import Model.ConcreteModel.BuilderParts.Torsos.TorsoPhantom;
import Model.ConcreteModel.Armed.SoldierArmedMachine;

public class PhantomStrategy extends AbstractStrategy {

    public PhantomStrategy() {
        super("Ghost");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadPhantom()).addLegs(new LegPhantom()).addTorso(new TorsoPhantom());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadPhantom()).addLegs(new LegPhantom()).addTorso(new TorsoPhantom()).addRadio(new WeaponPhantom());
        return machineBuilder.build();
    }

}