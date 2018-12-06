package Model.Expression;

import Model.ADT.IMyDictionary;
import Exception.*;

public class ReadHeapExp extends Exp {
    private String var;

    public ReadHeapExp(String var) {
        this.var = var;
    }

    @Override
    public String getVarName() {
        return var;
    }

    @Override
    public String toString() {
        return "rH("+var+")";
    }

    @Override
    public int eval(IMyDictionary<String, Integer> tbl, IMyDictionary<Integer, Integer> heap) throws MyException {
        int address=tbl.get(var);
        return heap.get(address);
    }
}
