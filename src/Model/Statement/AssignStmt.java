package Model.Statement;

import Model.*;
import Model.ADT.IMyDictionary;
//import Model.ADT.IMyStack;
import Model.Expression.Exp;
import Exception.*;

public class AssignStmt implements IStmt{
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    public String toString()
    {
        return id+"="+ exp.toString();
    }

    public PrgState execute(PrgState state) throws MyException {
        //IMyStack stk=state.getStk();
        IMyDictionary<String,Integer> symTbl= state.getSymTable();
        IMyDictionary<Integer,Integer> heap =state.getHeap();
        int val = exp.eval(symTbl,heap);
        if (symTbl.containsKey(id))
            symTbl.update(id, val);
        else
            symTbl.put(id,val);
        return state;
    }
}

