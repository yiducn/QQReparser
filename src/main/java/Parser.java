/**
 * Created by YiDu on 2016/8/15.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Parser {
    public static void main(String[] args){
        try {
            for(int i = 1; i <= 11 ; i ++) {
                for(int j = 1; j <= 10;j ++) {
                   // System.out.println("bcp QunInfo"+i+".dbo.QunList"+((i-1)*10+j)+" out c:\\data2\\qun_"+((i-1)*10+j)+" -T -c");
                    Process p = Runtime.getRuntime().exec("bcp QunInfo"+i+".dbo.QunList"+((i-1)*10+j)+" out c:\\data2\\qun_"+((i-1)*10+j)+" -T -c");
                    //Process p = Runtime.getRuntime().exec("bcp GroupData"+i+".dbo.Group"+((i-1)*100+j)+" out c:\\data\\group_"+((i-1)*100+j)+" -T -c");
                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(p.getInputStream()));
                    while ((reader.readLine()) != null) {}
                    int returnV = p.waitFor();
                    if(returnV != 0){
                        System.out.println("error"+i+"_"+j);
                    }
                }
            }

//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.106.128:1433;user=sa;password=1234;database=GroupData1");
//            System.out.println("test");
//            Statement sta = conn.createStatement();
//            String Sql = "select * from group1";
//            ResultSet rs = sta.executeQuery(Sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("Nick"));
//                break;
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
