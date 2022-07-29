package Controller.BoardController.Visitor;

import Model.AbstractModel.Machine;

public class Cloner<T extends Machine> {

        private final T clone;

        public Cloner(T clone) {
            this.clone = clone;
        }

        public Machine duplicate() throws Exception {
            return  clone.clone();
    }
}
