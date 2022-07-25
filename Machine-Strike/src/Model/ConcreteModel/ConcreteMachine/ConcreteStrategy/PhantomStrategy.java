package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadPhantom;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegPhantom;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponPhantom;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoPhantom;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

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