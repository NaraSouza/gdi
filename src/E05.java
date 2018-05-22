
import java.io.File;
import java.sql.*;

public class E05 {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.oracledriver";
    static final String DB_URL = "jdbc:oracle:thin:@oracle11g.cin.ufpe.br:1521:Instance01";

    //  Database credentials
    static final String USER = "g181if685cc_eq01";
    static final String PASS = "qkcmjnwz";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            File foto_pessoa = new File("/home/CIN/nsa2/IdeaProjects/gdi/src/foto.png");
            Date data_nascimento = new Date(06/06/1996);
            sql = "INSERT INTO PESSOA VALUES('333.333.333-33', 'Danila Freitas', 'M', data_nascimento, 'Rua Aquarela', '420', 'Arco-íris', 'Colorida', 'Pernambuco', 'danila.freitas@email.com', foto_pessoa); SELECT nome_pessoa, foto_pessoa FROM PESSOA;";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String nome  = rs.getString("nome_pessoa");
                Blob foto = rs.getBlob("foto_pessoa");

                //Display values
                System.out.print("Nome: " + nome);
                System.out.print(", Foto: " + foto);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main
}//end FirstExample