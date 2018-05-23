
import java.io.File;
import java.sql.*;

public class E05 {
    // Driver JDBC e URL do banco de dados
    static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@itapissuma.cin.ufpe.br:1521:dbdisc";

    // Credenciais da equipe
    static final String USER = "g181if685cc_eq01";
    static final String PASSWORD = "qkcmjnwz";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            //Registrando o driver
            Class.forName(JDBC_DRIVER);

            //Abrindo a conexão
            connection = DriverManager.getConnection(DB_URL,USER, PASSWORD);

            //Executando a query
            statement = connection.createStatement();
            File foto_pessoa = new File("/home/CIN/nsa2/IdeaProjects/gdi/src/foto.png");
            Date data_nascimento_pessoa = new Date(06/06/1996);
            String sql = "INSERT INTO PESSOA VALUES('333.333.333-33', 'Danila Freitas', 'M', data_nascimento_pessoa," +
                    " 'Rua Aquarela', '420', 'Arco-íris', 'Colorida', 'Pernambuco', 'danila.freitas@email.com', " +
                    "foto_pessoa); SELECT * FROM PESSOA;";
            ResultSet rs = statement.executeQuery(sql);

            //Extraindo dados do ResultSet
            while(rs.next()){
                //Retrieve by column name
                String nome  = rs.getString("nome_pessoa");
                Blob foto = rs.getBlob("foto_pessoa");
                String cpf = rs.getString("cpf_pessoa");
                String sexo = rs.getString("sexo_pessoa");
                Date data_nascimento = rs.getDate("data_nascimento__pessoa");
                String email = rs.getString("email_pessoa");
                String rua = rs.getString("rua_pessoa");
                int numero = rs.getInt("numero_pessoa");
                String bairro = rs.getString("bairro_pessoa");
                String cidade = rs.getString("cidade_pessoa");
                String estado = rs.getString("estado_pessoa");

                //Display values
                System.out.print("Nome: " + nome);
                System.out.print(", Foto: " + foto);
                System.out.print(", CPF: " + cpf);
                System.out.print(", Sexo: " + sexo);
                System.out.print(", Data de nascimento: " + data_nascimento);
                System.out.print(", E-mail: " + email);
                System.out.print(", Rua: " + rua);
                System.out.print(", Número: " + numero);
                System.out.print(", Bairro: " + bairro);
                System.out.print(", Cidade: " + cidade);
                System.out.print(", Estado: " + estado);
            }
            //Fechando ResultSet, Statement e Conexão
            rs.close();
            statement.close();
            connection.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}