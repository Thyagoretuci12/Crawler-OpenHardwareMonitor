package pkg;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuLoginCadastro {
    private Conexao conexao = new Conexao();
    private JdbcTemplate con;
    private Scanner leitor = new Scanner(System.in);
    private List<Usuario> usuarios;
    public MenuLoginCadastro() {
        this.usuarios = new ArrayList<>();
        this.con = conexao.getConexaoDoBanco();
    }

    public Boolean getUsuario (String nome, String senha){
        String querySql = "SELECT * FROM Usuario WHERE nome = ? AND senha = ?";

        Usuario isCadastrado = con.queryForObject(querySql, new BeanPropertyRowMapper<>(Usuario.class), nome, senha);

        if (Objects.isNull(isCadastrado)){
            return false;
        } else {
            return true;
        }
    }

    public void cadastrarUsuario(String nome, String email, String senha){
        String querySql = "INSERT INTO Usuario (nome, email, senha) VALUES (?, ?, ?)";
        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.add(usuario);

        con.update(querySql, nome, email, senha);
    }
}
