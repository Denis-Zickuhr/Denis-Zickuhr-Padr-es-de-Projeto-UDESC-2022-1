package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadCyan;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegCyan;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponCyan;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoCyan;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

public class CyanStrategy extends AbstractStrategy {

    public CyanStrategy() {
        super("Cyan Soldier Bot");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadCyan()).addLegs(new LegCyan()).addTorso(new TorsoCyan());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadCyan()).addLegs(new LegCyan()).addTorso(new TorsoCyan()).addRadio(new WeaponCyan());
        return machineBuilder.build();
    }

}