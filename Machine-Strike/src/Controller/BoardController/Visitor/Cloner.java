package Controller.BoardController.Visitor;

import Model.AbstractModel.AbstractMachine.Machine;

public class Cloner<T extends Machine> {

        private T clone;

        public Cloner(T base) {
            this.clone = base;
        }

        public T duplicate() throws Exception {
            return  (T) clone.clone();
    }
}
