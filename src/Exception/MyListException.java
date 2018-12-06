package Exception;

public class MyListException extends MyException{
    private String msg;

    public MyListException(String m)
    {
        msg=m;
    }

    public String getMsg()
    {
        return msg;
    }
}
