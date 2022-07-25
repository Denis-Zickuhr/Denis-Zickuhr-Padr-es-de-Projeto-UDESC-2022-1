package Model.ConcreteModel.ConcreteMachine.ConcreteStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads.HeadGreen;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.LegGreen;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Weapons.WeaponGreen;
import Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos.TorsoGreen;
import Model.ConcreteModel.ConcreteMachine.Armed.SoldierArmedMachine;

public class GreenStrategy extends AbstractStrategy {

    public GreenStrategy() {
        super("Green Trooper");
    }

    @Override
    public MachineSoldierEntity build(){
        SoldierMachine.MachineBuilder machineBuilder = new SoldierMachine.MachineBuilder();
        machineBuilder.addHead(new HeadGreen()).addLegs(new LegGreen()).addTorso(new TorsoGreen());
        return machineBuilder.build();
    }

    @Override
    public MachineSoldierEntity buildRadio() throws Exception {
        SoldierArmedMachine.MachineBuilder machineBuilder = new SoldierArmedMachine.MachineBuilder();
        machineBuilder.addHead(new HeadGreen()).addLegs(new LegGreen()).addTorso(new TorsoGreen()).addRadio(new WeaponGreen());
        return machineBuilder.build();
    }

}