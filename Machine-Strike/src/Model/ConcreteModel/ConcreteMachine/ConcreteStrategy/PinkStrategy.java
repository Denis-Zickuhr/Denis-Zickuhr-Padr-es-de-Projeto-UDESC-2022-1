package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadPink;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegPink;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponPink;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoPink;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

public class PinkStrategy extends AbstractStrategy {

    public PinkStrategy() {
        super("Pashion Bot");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadPink()).addLegs(new LegPink()).addTorso(new TorsoPink());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadPink()).addLegs(new LegPink()).addTorso(new TorsoPink()).addRadio(new WeaponPink());
        return machineBuilder.build();
    }

}
