package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadWhite;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegWhite;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoBlack;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoWhite;
import Model.ConcreteModel.ConcreteMachine.Radioactive.SoldierRadioactiveMachine;

public class WhiteStrategy extends AbstractStrategy {

    public WhiteStrategy() {
        super("Grazer Strike");
    }

    @Override
    public MachineSoldierEntity build() {
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadWhite()).addLegs(new LegWhite()).addTorso(new TorsoWhite());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() {
        SoldierRadioactiveMachine.MachineBuilder machineBuilder = new SoldierRadioactiveMachine.MachineBuilder();
        machineBuilder.addHead(new HeadWhite());//.buildLegs().buildTorso().buildArmor();
        return machineBuilder.build();
    }

}
