package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoBlack;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

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
