package Model.Statement;

import Model.ADT.IMyDictionary;
import Exception.*;
import Model.Expression.Exp;
import Model.PrgState;
import Model.Statement.IStmt;

public class WriteHeapStmt implements IStmt {
    private String var;
    private Exp exp;

    public WriteHeapStmt(String var, Exp exp) {
        this.var = var;
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyDictionary<String,Integer> tbl=state.getSymTable();
        IMyDictionary<Integer,Integer> heap=state.getHeap();
        int addr=tbl.get(var);
        if(!heap.containsKey(addr))
            throw new MyExprException("Invalid address");
        heap.update(addr,exp.eval(tbl,heap));
        return state;
    }

    @Override
    public String toString() {
        return "wH("+var+", "+exp.toString()+")";
    }
}
