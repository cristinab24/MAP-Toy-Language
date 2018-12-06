package View;

import Controller.Ctrl;
import Model.ADT.MyDictionary;
import Model.ADT.MyList;
import Model.ADT.MyStack;
import Model.PrgState;
import Model.Statement.*;
import Repository.Repo;
import Model.Expression.*;

public class Start {
   /* private static void  printMenu()
    {
        System.out.println("1. One Step");
        System.out.println("2. All step");
    }

    private static void printState(PrgState state)
    {
        System.out.println("stack: "+state.getStk().toString());
        System.out.println("symbol table: "+state.getSymTable().toString());
        System.out.println("output: "+state.getOutput().toString());
        System.out.println("file table: "+state.getFileTable().toString());
    }
*/
    public static void main(String[] args)
    {
        /*Scanner in=new Scanner(System.in);
//        IStmt statement= new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(
//                new VarExp("v")));
//        IStmt statement=new CompStmt(new AssignStmt("a", new ArithExp(new ConstExp(2),
//         new ArithExp(new ConstExp(3), new ConstExp(5),3),1)),
//         new CompStmt(new AssignStmt("b",new ArithExp(new VarExp("a"),
//         new ConstExp(1),1)), new PrintStmt(new VarExp("b"))));
//        IStmt statement= new CompStmt(new AssignStmt("a", new ArithExp(new ConstExp(2), new
//                ConstExp(2),2)),
//               new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
//                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
//        IStmt statement=new CompStmt(new OpenFileStmt("a.txt","f_a"),new CompStmt(
//                new ReadFileStmt("f_a","a"),new CompStmt(new PrintStmt(new VarExp("a")),
//                new CloseRFile("f_a"))));
        IStmt statement=new CompStmt(
                new OpenFileStmt("test.in", "var_f"),
                new CompStmt(
                        new ReadFileStmt(new VarExp("var_f"), "var_c"),
                        new CompStmt(
                                new PrintStmt(new VarExp("var_c")),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("var_c"),
                                                new CompStmt(
                                                        new ReadFileStmt(new VarExp("var_f"), "var_c"),
                                                        new PrintStmt(new VarExp("var_c"))
                                                ),
                                                new PrintStmt(new ConstExp(0))
                                        ),
                                        new CloseRFile(new VarExp("var_f"))
                                )
                        )
                )
        );
        MyStack<IStmt> stack=new MyStack<>();
        MyList<Integer> out=new MyList<>();
        MyDictionary<String, Integer> dict = new MyDictionary<>();
        MyDictionary<Integer, Pair<String, BufferedReader>> filetable=new MyDictionary<>();
        PrgState state=new PrgState(stack,dict,out, filetable,statement);
        Repo r=new Repo(state,"file.txt");
        r.add(state);
        Ctrl c=new Ctrl(r);
        while (!c.isFinished()){
            printMenu();
            int val=in.nextInt();
            if(val==1){
                try {
                    c.oneStep(c.getPrgState());
                }
                catch (MyException e){
                    System.out.println(e.getMsg());
                }
            }
            else if(val==2){
                try {
                    c.allStep();
                }
                catch (MyException e){
                    System.out.println(e.getMsg());
                }
            }
            printState(c.getPrgState());
        }
*/


        IStmt ex1=new CompStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(
                new VarExp("v")));
        PrgState prg1 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex1);
        Repo repo1 = new Repo(prg1,"log1.txt");
        Ctrl ctr1 = new Ctrl(repo1);
        IStmt ex2=new CompStmt(new AssignStmt("a", new ArithExp(new ConstExp(2),
         new ArithExp(new ConstExp(3), new ConstExp(5),3),1)),
         new CompStmt(new AssignStmt("b",new ArithExp(new VarExp("a"),
         new ConstExp(1),1)), new PrintStmt(new VarExp("b"))));
        PrgState prg2 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex2);
        Repo repo2 = new Repo(prg2,"log2.txt");
        Ctrl ctr2 = new Ctrl(repo2);
        IStmt ex3= new CompStmt(new AssignStmt("a", new ArithExp(new ConstExp(2), new
                ConstExp(2),2)),
               new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
                        AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
        PrgState prg3 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex3);
        Repo repo3 = new Repo(prg3,"log3.txt");
        Ctrl ctr3 = new Ctrl(repo3);

        IStmt ex4 = new CompStmt(
                new OpenFileStmt("test.in", "var_f"),
                new CompStmt(
                        new ReadFileStmt(new VarExp("var_f"), "var_c"),
                        new CompStmt(
                                new PrintStmt(new VarExp("var_c")),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("var_c"),
                                                new CompStmt(
                                                        new ReadFileStmt(new VarExp("var_f"), "var_c"),
                                                        new PrintStmt(new VarExp("var_c"))
                                                ),
                                                new PrintStmt(new ConstExp(0))
                                        ),
                                        new CloseRFile(new VarExp("var_f"))
                                )
                        )
                )
        );
        PrgState programState4 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex4);
        Repo repo4 = new Repo(programState4,"log4.txt");
        Ctrl ctrl4 = new Ctrl(repo4);


        IStmt ex5 = new CompStmt(
                new OpenFileStmt("test.in", "var_f"),
                new CompStmt(
                        new ReadFileStmt(new ArithExp(new VarExp("var_f"),new ConstExp( 2),1), "var_c"),
                        new CompStmt(
                                new PrintStmt(new VarExp("var_c")),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("var_c"),
                                                new CompStmt(
                                                        new ReadFileStmt(new VarExp("var_f"), "var_c"),
                                                        new PrintStmt(new VarExp("var_c"))),
                                                new PrintStmt(new ConstExp(0))),
                                        new CloseRFile(new VarExp("var_f")))
                        )
                )
        );
        PrgState programState5 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex5);
        Repo repo5 = new Repo(programState5,"log5.txt");
        Ctrl ctrl5 = new Ctrl(repo5);


        IStmt ex6=new CompStmt(new AssignStmt("v", new ConstExp(5)),
                new CompStmt(new AllocateHeap("v", new ConstExp(20)),
                        new CompStmt(new AllocateHeap("a", new ConstExp(22)),
                                new CompStmt(new WriteHeapStmt("a", new ConstExp(30)),
                                        new CompStmt(new PrintStmt(new VarExp("a")),
                                                new PrintStmt(new ReadHeapExp("a")))))));
        PrgState programState6 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex6);
        Repo repo6 = new Repo(programState6,"log6.txt");
        Ctrl ctrl6 = new Ctrl(repo6);

        IStmt ex7=new CompStmt(new AssignStmt("v", new ConstExp(5)),
                new CompStmt(new AllocateHeap("v", new ConstExp(20)),
                        new CompStmt(new AllocateHeap("a", new ConstExp(22)),
                                new CompStmt(new WriteHeapStmt("a", new ConstExp(30)),
                                        new CompStmt(new PrintStmt(new VarExp("a")),
                                                new CompStmt(new PrintStmt(new ReadHeapExp("a")),
                                                        new AssignStmt("a",new ConstExp(0))))))));
        PrgState programState7 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex7);
        Repo repo7 = new Repo(programState7,"log7.txt");
        Ctrl ctrl7 = new Ctrl(repo7);

        IStmt ex8=new CompStmt(new AssignStmt("v",new ConstExp(6)),
                new CompStmt(new WhileStmt(new ArithExp(new VarExp("v"),new ConstExp(4),2),
                        new CompStmt(new PrintStmt(new VarExp("v")),
                                new AssignStmt("v", new ArithExp(new VarExp("v"), new ConstExp(1),2)))),
                        new PrintStmt(new VarExp("v"))));
//        IStmt ex8=new CompStmt(new AssignStmt("v",new ConstExp(6)),
//                new CompStmt(new AssignStmt("v", new ArithExp(new VarExp("v"), new ConstExp(2),2)),
//                        new PrintStmt(new VarExp("v"))));
        PrgState programState8 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex8);
        Repo repo8 = new Repo(programState8,"log8.txt");
        Ctrl ctrl8 = new Ctrl(repo8);

        IStmt ex9=new CompStmt(new OpenFileStmt("test.in", "var_f"),new AssignStmt("a", new ConstExp(5)));
        PrgState programState9 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(), ex9);
        Repo repo9 = new Repo(programState9,"log9.txt");
        Ctrl ctrl9 = new Ctrl(repo9);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctr1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctr2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctr3));
        menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
        menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));
        menu.addCommand(new RunExample("6",ex6.toString(),ctrl6));
        menu.addCommand(new RunExample("7",ex7.toString(),ctrl7));
        menu.addCommand(new RunExample("8",ex8.toString(),ctrl8));
        menu.addCommand(new RunExample("9",ex9.toString(),ctrl9));
        menu.show();
    }
}
