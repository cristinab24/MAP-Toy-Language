package Model.Statement;

import Model.ADT.IMyDictionary;
import Model.ADT.Pair;
import Model.Expression.Exp;
import Model.PrgState;
import Exception.*;

import java.io.BufferedReader;
import java.util.Collection;

public class CloseRFile implements IStmt {
    private Exp fileName;

    public CloseRFile(Exp fileName) {
        super();
        this.fileName = fileName;
    }

    public PrgState execute(PrgState state) throws MyException {
        boolean found=false;
        //IMyStack stk=state.getStk();
        IMyDictionary<String,Integer> symTbl= state.getSymTable();
        IMyDictionary<Integer, Pair<String, BufferedReader>> fileTable=state.getFileTable();
        IMyDictionary<Integer,Integer> heap=state.getHeap();
        Collection<Pair<String,BufferedReader>> values=fileTable.getValues();
        for(Pair<String, BufferedReader> pair :values){
            if(fileTable.getKeyByValue(pair).equals(fileName.eval(symTbl,heap))) {
                fileTable.remove(fileTable.getKeyByValue(pair));
                symTbl.remove(pair.getElement0());
                found=true;
                break;
            }
        }
        if(!found) throw new MyStmtExecException("File not open");

        return state;
    }

    public String toString()
    {
        return "closeRFile("+"\""+fileName.toString()+"\")";
    }
}
