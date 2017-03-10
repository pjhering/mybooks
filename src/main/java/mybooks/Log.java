package mybooks;

import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log
{
    public static final int NONE = 0;
    public static final int FATAL = 1;
    public static final int SEVERE = 2;
    public static final int WARNING = 3;
    public static final int DEBUG = 4;
    public static final int INFO = 5;
    public static final int ALL = 6;
    
    private static final String[] LABEL = {
        "   NONE",
        "  FATAL",
        " SEVERE",
        "WARNING",
        "  DEBUG",
        "   INFO",
        "    ALL"
    };
    
    private static final SimpleDateFormat FMT = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    
    private final String name;
    private final int level;
    
    public Log(Class c, int level)
    {
        this.name = c == null? "Anonymous": c.getName();
        this.level = max(NONE, min(ALL, level));
    }
    
    public void write(int l, Object obj)
    {
        if(l > NONE && l <= level)
        {
            out.print(LABEL[l]);
            out.print(":[");
            out.print(FMT.format(new Date()));
            out.print("/");
            out.print(name);
            out.print("] ");
            out.println(obj);
            out.flush();
        }
    }
}
