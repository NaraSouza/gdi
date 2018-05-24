package UserInterface;

import javax.swing.*;

public class UserProfile {
    public JPanel profile;
    private JPanel fotoPanel;
    private JLabel nomeLabel;
    private JLabel cpfLabel;
    private JLabel sexoLabel;
    private JLabel dataNascLabel;
    private JLabel emailLabel;
    private JLabel enderecoLabel;
    private JLabel ruaLabel;
    private JLabel numeroLabel;
    private JLabel bairroLabel;
    private JLabel cidadeLabel;
    private JLabel estadoLabel;
    private JLabel fotoLabel;
    private JLabel nome_pessoa;
    private JLabel cpf_pessoa;
    private JLabel sexo_pessoa;
    private JLabel data_nascimento_pessoa;
    private JLabel email_pessoa;
    private JLabel rua_pessoa;
    private JLabel numero_pessoa;
    private JLabel bairro_pessoa;
    private JLabel cidade_pessoa;
    private JLabel estado_pessoa;

    public UserProfile() {

    }

    /**
     * Exibe Perfil do usuário com todas as informações passadas retornadas do ResultSete e tratadas no RegisterForm
     * @param nome nome da pessoa
     * @param fotoIcon foto da pessoa
     * @param cpf cpf da pessoa
     * @param sexo sexo da pessoa
     * @param data_nascimento data de nascimento da pessoa
     * @param email email da pessoa
     * @param rua rua da pessoa
     * @param numero numero da pessoa
     * @param bairro bairro da pessoa
     * @param cidade cidade da pessoa
     * @param estado estado da pessoa
     */
    public void showProfile(String nome, Icon fotoIcon, String cpf, String sexo, String data_nascimento,
                                   String email, String rua, int numero, String bairro, String cidade, String estado) {

        nome_pessoa.setText(nome);
        fotoLabel.setIcon(fotoIcon);
        cpf_pessoa.setText(cpf);
        sexo_pessoa.setText(sexo);
        data_nascimento_pessoa.setText(data_nascimento);
        email_pessoa.setText(email);
        rua_pessoa.setText(rua);
        numero_pessoa.setText(String.valueOf(numero));
        bairro_pessoa.setText(bairro);
        cidade_pessoa.setText(cidade);
        estado_pessoa.setText(estado);
    }
}
