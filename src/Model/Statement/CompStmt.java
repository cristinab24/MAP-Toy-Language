package Model.Statement;

import Model.*;
import Model.ADT.IMyStack;
import Exception.*;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt snd;

    public CompStmt(IStmt first, IStmt snd) {
        this.first = first;
        this.snd = snd;
    }

    public String toString()
    {
        return "("+first.toString() + ";" + "\n" + snd.toString()+")";
    }

    public PrgState execute(PrgState state) throws MyException{
        IMyStack<IStmt> stk=state.getStk();
        stk.push(snd);
        stk.push(first);
        return state;
    }
}

