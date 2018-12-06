package Model.Statement;

import Model.ADT.IMyDictionary;
import Model.ADT.IMyStack;
import Model.Expression.Exp;
import Model.PrgState;
import Exception.*;

public class WhileStmt implements IStmt {
    private Exp condition;
    private IStmt statement;

    public WhileStmt(Exp condition, IStmt statement) {
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyDictionary<String, Integer> tbl=state.getSymTable();
        IMyDictionary<Integer,Integer> heap=state.getHeap();
        IMyStack<IStmt> stack=state.getStk();
        if (condition.eval(tbl,heap)!=0){
            stack.push(this);
            stack.push(statement);
        }
        return state;
    }

    @Override
    public String toString()
    {
        return "while("+condition.toString()+")"+statement.toString();
    }
}
