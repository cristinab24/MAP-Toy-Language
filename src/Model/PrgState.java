package Model;

import Model.ADT.*;
import Model.Statement.IStmt;

import java.io.BufferedReader;

public class PrgState {
    private IMyStack<IStmt> exeStack;
    private IMyDictionary<String, Integer> symTable;
    private IMyList<Integer> out;
    private IMyDictionary<Integer,Pair<String, BufferedReader>> fileTable;
    private IMyDictionary<Integer, Integer> heap;
    private int fd;
    private int firstFree;

    public PrgState(IMyStack<IStmt> stk, IMyDictionary<String,Integer> symtbl, IMyList<Integer> ot, IMyDictionary<Integer,Pair<String,BufferedReader>> filetbl, IStmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        fd=0;
        firstFree=1;
        fileTable=filetbl;
        heap=new MyDictionary<>();
        //originalProgram=deepCopy(prg);//recreate the entire original prg
        stk.push(prg);
    }

    public IMyStack getStk(){
        return exeStack;
    }

    public IMyDictionary getSymTable(){
        return symTable;
    }

    public IMyList getOutput(){
        return out;
    }

    public IMyDictionary<Integer, Pair<String, BufferedReader>> getFileTable() {
        return fileTable;
    }

    public IMyDictionary<Integer,Integer> getHeap(){return heap;}

    public int getNextFD(){
        return fd++;
    }

    public int getFirstFree(){return firstFree++;
    }
}
