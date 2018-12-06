package Repository;

import Model.PrgState;

public interface IRepo {
    PrgState getCurrentPrg();
    void add(PrgState s);
    void logPrgStateExec();
}
