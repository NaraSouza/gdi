package DBCommunication;

import UserInterface.RegisterForm;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class DataBaseCommunication {
    // Driver JDBC e URL do banco de dados
    static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@oracle11g.cin.ufpe.br:1521:Instance01";

    // Credenciais da equipe
    static final String USER = "g181if685cc_eq01";
    static final String PASSWORD = "qkcmjnwz";

    /**
     * Recebe as informações da interface do usuário e envia query de cadastro de pessoa para o DB
     * @param cpf cpf da pessoa
     * @param nome nome da pessoa
     * @param sexo sexo da pessoa
     * @param dataNascimento data de nascimento da pessoa
     * @param rua rua da pessoa
     * @param numero numero da pessoa
     * @param bairro bairro da pessoa
     * @param cidade cidade da pessoa
     * @param estado estado da pessoa
     * @param email email da pessoa
     * @param foto foto da pessoa
     * @return retorna um ResultSet com as informações da pessoa que acabou de ser inserida no DB
     */
    public static ResultSet criarPessoa (String cpf, String nome, String sexo, Date dataNascimento, String rua,
                                         int numero, String bairro, String cidade, String estado, String email, Blob foto) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //Registrando o driver
            Class.forName(JDBC_DRIVER);

            //Abrindo a conexão
            connection = DriverManager.getConnection(DB_URL,USER, PASSWORD);

            //Executando a query
            String sql = "INSERT INTO PESSOA (CPF_PESSOA, NOME_PESSOA, SEXO_PESSOA, DATA_NASCIMENTO_PESSOA, RUA_PESSOA," +
                    " NUMERO_PESSOA, BAIRRO_PESSOA, CIDADE_PESSOA, ESTADO_PESSOA, EMAIL_PESSOA, FOTO_PESSOA) VALUES " +
                    "(?, ?, ?, ?, ?, ? ,? ,?, ?, ?, ?); SELECT * FROM PESSOA WHERE CPF_PESSOA = ?;";

            statement = connection.prepareStatement(sql);

            statement.setString(1, cpf);
            statement.setString(2, nome);
            statement.setString(3, sexo);
            statement.setDate(4, dataNascimento);
            statement.setString(5, rua);
            statement.setInt(6, numero);
            statement.setString(7, bairro);
            statement.setString(8, cidade);
            statement.setString(9, estado);
            statement.setString(10, email);
            statement.setBlob(11, foto);
            statement.setString(12, cpf);

            resultSet = statement.executeQuery(sql);

            resultSet.close();
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

        //retorna o ResultSet com as informações da pessoa criada
        return resultSet;
    }
}