package Repository;

import Model.ADT.*;
import Model.PrgState;

import java.io.*;
import java.util.*;

public class Repo implements IRepo {
    private Vector<PrgState> programs;
    private int crt;
    private File logFilePath;

    public Repo(PrgState prg, String path) {
        this.programs = new Vector<>();
        add(prg);
        this.crt = 0;
        //logFilePath= new File("C:\\Users\\crist\\Desktop\\Facultate\\An 2\\Sem 1\\Metode avansate de programare\\Lab3\\file.txt");
        logFilePath=new File(path);
        //logFilePath.getParentFile().mkdirs();
    }

    public PrgState getCurrentPrg()
    {
        return programs.get(crt);
    }

    public void add(PrgState s)
    {
        programs.add(s);
    }

    public void logPrgStateExec(){
        PrgState crt=getCurrentPrg();
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            IMyStack<String> stack=crt.getStk();
            IMyList<String> list=crt.getOutput();
            IMyDictionary<String, Integer> dict=crt.getSymTable();
            IMyDictionary<Integer, Integer> heap=crt.getHeap();
            IMyDictionary<Integer, Pair<String,BufferedReader>> fileTable=crt.getFileTable();
            logFile.println("Execution stack: \n");
            logFile.println(stack.toString());
            logFile.println("\nSymbol table: \n");
            logFile.println(dict.toString());
            logFile.println("\nOutput: \n");
            logFile.println(list.toString());
            logFile.println("\nFile table: \n");
            logFile.println(fileTable.toString());
            logFile.println("\n\n");
            logFile.println("\nHeap: \n");
            logFile.println(heap.toString());
            logFile.close();
        }
        catch (IOException ignored){
        }
    }
}
