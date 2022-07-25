package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadYellow;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegYellow;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponYellow;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoYellow;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

public class YellowStrategy extends AbstractStrategy {

    public YellowStrategy() {
        super("Yellow Bot");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadYellow()).addLegs(new LegYellow()).addTorso(new TorsoYellow());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadYellow()).addLegs(new LegYellow()).addTorso(new TorsoYellow()).addRadio(new WeaponYellow());
        return machineBuilder.build();
    }

}