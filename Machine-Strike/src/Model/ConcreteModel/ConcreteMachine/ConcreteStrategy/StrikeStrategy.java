package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.Head;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadDestroyerOfWorld;
import Model.ConcreteModel.ConcreteMachine.Radioactive.SoldierRadioactiveMachine;

public class StrikeStrategy extends AbstractStrategy {

    public StrikeStrategy() {
        super("Grazer Strike");
    }

    @Override
    public MachineSoldierEntity build() throws ClassNotFoundException {
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.buildHead((Class<Head>) Class.forName("Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadDefault"));//.buildLegs().buildTorso().buildArmor();
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() {
        SoldierRadioactiveMachine.MachineBuilder machineBuilder = new SoldierRadioactiveMachine.MachineBuilder();
        //machineBuilder.buildHead(new HeadDestroyerOfWorld());//.buildLegs().buildTorso().buildArmor();
        return machineBuilder.build();
    }

}
