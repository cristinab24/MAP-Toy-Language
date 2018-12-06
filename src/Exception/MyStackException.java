package Exception;

public class MyStackException extends MyException {
    private String msg;

    public MyStackException(String m)
    {
        msg=m;
    }

    public String getMsg()
    {
        return msg;
    }
}
