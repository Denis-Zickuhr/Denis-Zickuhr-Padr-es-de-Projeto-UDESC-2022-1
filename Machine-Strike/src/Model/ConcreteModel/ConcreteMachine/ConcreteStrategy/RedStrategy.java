package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadRed;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadWhite;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegRed;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoRed;
import Model.ConcreteModel.ConcreteMachine.Radioactive.SoldierRadioactiveMachine;

public class RedStrategy extends AbstractStrategy {

    public RedStrategy() {
        super("Grazer Strike");
    }

    @Override
    public MachineSoldierEntity build() {
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadRed()).addLegs(new LegRed()).addTorso(new TorsoRed());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() {
        SoldierRadioactiveMachine.MachineBuilder machineBuilder = new SoldierRadioactiveMachine.MachineBuilder();
        machineBuilder.addHead(new HeadWhite());//.buildLegs().buildTorso().buildArmor();
        return machineBuilder.build();
    }

}
