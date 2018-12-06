package Model.Statement;

import Model.*;
import Model.ADT.IMyDictionary;
import Model.ADT.IMyStack;
import Model.Expression.Exp;
import Exception.*;

public class PrintStmt implements IStmt{
    private Exp exp;

    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    public String toString()
    {
        return "print(" +exp.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException{
        IMyStack<IStmt> stk=state.getStk();
        IMyDictionary<Integer, Integer> heap=state.getHeap();
        IMyDictionary<String, Integer> tbl=state.getSymTable();
        if(!tbl.containsKey(exp.getVarName())) {
            throw new MyStmtExecException("The variable that you want to print does not exist");
        }
        int val=exp.eval(tbl,heap);
        state.getOutput().add(val);
        return state;
    }
}