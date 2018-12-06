package Controller;

import Model.PrgState;
import Model.ADT.*;
import Model.Statement.*;
import Repository.IRepo;
import Exception.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;


public class Ctrl {
    private IRepo repo;

    public Ctrl(IRepo repo) {
        this.repo = repo;
    }

    private PrgState oneStep(PrgState state) throws MyException {
        IMyStack<IStmt> stk = state.getStk();
        if (stk.empty())
            throw new MyStmtExecException("Execution stack is empty");
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }

    public void allStep() throws MyException {
        PrgState prg = repo.getCurrentPrg(); // repo is the controller field of type MyRepoInterface
        while (!prg.getStk().empty()) {
            oneStep(prg);
            prg.getHeap().setContent(conservativeGarbageCollector(
                    prg.getSymTable().getContent().values(),
                    prg.getHeap().getContent()));
            repo.logPrgStateExec();
        }
        prg.getFileTable().getValues().stream().map(Pair::getElement1).forEach(bufferedReader ->
        {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        prg.getFileTable().getValues().clear();
        repo.logPrgStateExec();
    }

    private Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,
                                                               Map<Integer, Integer> heap) {
        Map<Integer, Integer> map;
        map = heap.entrySet().stream()
                .filter(e -> symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return map;
    }

    //public boolean isFinished()
    //{
    //    return repo.getCurrentPrg().getStk().empty();
    //}

    //public PrgState getPrgState()
    //{
    //    return repo.getCurrentPrg();
    //}
}
