package Model.Statement;
import Model.PrgState;
import Exception.*;

public interface IStmt {
    PrgState execute(PrgState state) throws MyException; //which is the execution method for a statement.
    String toString();
}