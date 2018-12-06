package Model.Statement;

import Model.ADT.IMyStack;
import Model.Expression.Exp;
import Model.*;
import Exception.*;

public class IfStmt implements IStmt{
    private Exp exp;
    private IStmt thenS;
    private IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el)
    {
        exp=e;
        thenS=t;
        elseS=el;
    }

    public String toString()
    {
        return "IF("+ exp.toString()+") THEN(" +thenS.toString() +")ELSE("+elseS.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException {
        IMyStack<IStmt> stk=state.getStk();
        int res=exp.eval(state.getSymTable(),state.getHeap());
        if(res!=0)
            thenS.execute(state);
        else
            elseS.execute(state);
        return state;
    }
}
