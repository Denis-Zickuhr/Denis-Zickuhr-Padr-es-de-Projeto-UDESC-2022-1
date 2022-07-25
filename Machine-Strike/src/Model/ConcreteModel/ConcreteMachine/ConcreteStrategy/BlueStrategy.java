package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadBlue;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegBlue;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponBlue;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoBlue;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

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