package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoBlack;
import Model.ConcreteModel.ConcreteMachine.Radioactive.SoldierRadioactiveMachine;

public class BlackStrategy extends AbstractStrategy {

    public BlackStrategy() {
        super("Burrower Strike");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadBlack()).addLegs(new LegBlack()).addTorso(new TorsoBlack());//.buildArmor();
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() {
        SoldierRadioactiveMachine.MachineBuilder machineBuilder = new SoldierRadioactiveMachine.MachineBuilder();
        machineBuilder.addHead(new HeadBlack()).addLegs(new LegBlack());//.buildTorso().buildArmor();
        return machineBuilder.build();
    }

}
