package Config;

/**
 * database config
 * should be gotted by nacos
 */
public final class DbConfig {
    public static final String jdbc_url = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false";
    public static final int UserNums = 250;
    public static final int maxResultSet = 20; // 只显示20条数据
}
