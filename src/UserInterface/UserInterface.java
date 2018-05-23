package UserInterface;

import DBCommunication.DataBaseCommunication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInterface {
    Blob foto;

    private JPanel Pessoa;
    private JLabel nomeLabel;
    private JLabel emailLabel;
    private JLabel sexoLabel;
    private JLabel cpfLabel;
    private JLabel dataNascLabel;
    private JLabel ruaLabel;
    private JLabel numeroLabel;
    private JLabel bairroLabel;
    private JLabel cidadeLabel;
    private JLabel estadoLabel;
    private JLabel fotoLabel;
    private JTextField ruaTextField;
    private JTextField numeroTextField;
    private JTextField bairroTextField;
    private JTextField cidadeTextField;
    private JTextField estadoTextField;
    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JTextField cpfTextField;
    private JTextField dataNascTextField;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femininoRadioButton;
    private JButton carregarFotoButton;
    private JButton enviarButton;

    public UserInterface() {
        foto = null;

        carregarFotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //abre diretório para usuário selecionar foto
                //TODO o arquivo selecionado deve ser colocado na variável foto
                foto = null;
            }
        });

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sexo;
                if(masculinoRadioButton.isSelected()) {
                    sexo = "H";
                } else {
                    sexo = "M";
                }

                Date data_nascimento = new Date(Long.parseLong(dataNascTextField.getText()));
                int numero = Integer.parseInt(numeroTextField.getText());

                //envia informações para o DB
                ResultSet resultSet = DataBaseCommunication.criarPessoa(cpfTextField.getText(), nomeTextField.getText(),
                        sexo, data_nascimento, ruaTextField.getText(), numero, bairroTextField.getText(),
                        cidadeTextField.getText(), estadoTextField.getText(), emailTextField.getText(), foto);

                showInfo(resultSet);
            }
        });
    }

    /**
     * Deve abrir uma nova tela (além do formulário de cadastro) para exibir as informações do perfil da pessoa cadastrada
     * @param resultSet retorno do método que cadastra pessoa
     */
    public void showInfo(ResultSet resultSet) {

        //Extraindo dados do ResultSet
        try {
            while(resultSet.next()){
                //Retrieve by column name
                String nome  = resultSet.getString("nome_pessoa");
                Blob foto = resultSet.getBlob("foto_pessoa");
                String cpf = resultSet.getString("cpf_pessoa");
                String sexo = resultSet.getString("sexo_pessoa");
                Date data_nascimento = resultSet.getDate("data_nascimento__pessoa");
                String email = resultSet.getString("email_pessoa");
                String rua = resultSet.getString("rua_pessoa");
                int numero = resultSet.getInt("numero_pessoa");
                String bairro = resultSet.getString("bairro_pessoa");
                String cidade = resultSet.getString("cidade_pessoa");
                String estado = resultSet.getString("estado_pessoa");

                //Exibe as informações de perfil
                //TODO exibir as informações em uma nova tela
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
