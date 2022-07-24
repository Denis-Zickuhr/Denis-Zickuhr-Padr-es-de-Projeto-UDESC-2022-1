package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadDestroyerOfWorld;
import Model.ConcreteModel.ConcreteMachine.Radioactive.SoldierRadioactiveMachine;

public class GrazerStrikeStrategy extends AbstractStrategy {

    public GrazerStrikeStrategy() {
        super("Grazer Strike");
    }

    @Override
    public MachineSoldierEntity build() {
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        //machineBuilder.buildHead(new HeadDestroyerOfWorld());//.buildLegs().buildTorso().buildArmor();
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() {
        SoldierRadioactiveMachine.MachineBuilder machineBuilder = new SoldierRadioactiveMachine.MachineBuilder();
        //machineBuilder.buildHead(new HeadDestroyerOfWorld());//.buildLegs().buildTorso().buildArmor();
        return machineBuilder.build();
    }

}
