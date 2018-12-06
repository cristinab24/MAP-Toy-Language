package Model.Statement;

import Model.ADT.IMyDictionary;
import Model.Expression.Exp;
import Model.PrgState;
import Exception.*;

public class AllocateHeap implements IStmt {
    private String var;
    private Exp exp;

    public AllocateHeap(String variable, Exp expression) {
        this.var = variable;
        this.exp = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyDictionary<String,Integer> symTbl= state.getSymTable();
        IMyDictionary<Integer, Integer> heap=state.getHeap();
        int val = exp.eval(symTbl,heap);
//        if (symTbl.containsKey(var)) //if a variable with that name already exists
//            throw new MyStmtExecException("Variable already exists.\n");
//        else{
            int freeMemory=state.getFirstFree();
            if(!symTbl.containsKey(var))
                symTbl.put(var,freeMemory);
            else
                symTbl.update(var,freeMemory);
            heap.put(freeMemory,exp.eval(symTbl, heap));
//        }
        return state;
    }

    @Override
    public String toString()
    {
        return "new("+var+","+exp.toString()+")";
    }
}
