package pkg;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    private Conexao conexao = new Conexao();
    private JdbcTemplate con;
    private JFrame frame;
    private JLabel cpuLabel;
    private JLabel ramLabel;
    private JLabel diskLabel;
    private static boolean isUserLoggedIn = false;
    public Main() {
        con = conexao.getConexaoDoBanco();

        frame = new JFrame("Monitoramento de Máquina");
        frame.setLayout(new FlowLayout());

        cpuLabel = new JLabel("Uso de CPU: ");
        ramLabel = new JLabel("Uso de RAM: ");
        diskLabel = new JLabel("Uso de Disco: ");

        frame.add(cpuLabel);
        frame.add(ramLabel);
        frame.add(diskLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setVisible(true);
    }

    public void updateSystemData() {
        try {
            String selectTemp = "SELECT temp_value FROM Registros ORDER BY id DESC LIMIT 1";
            String selectRam = "SELECT ram_value FROM Registros ORDER BY id DESC LIMIT 1";
            String selectdisco = "SELECT disk_value FROM Registros ORDER BY id DESC LIMIT 1";

            Float resultTemp = con.queryForObject(selectTemp, Float.class);
            Float resultRam = con.queryForObject(selectRam, Float.class);
            Float resultDisk = con.queryForObject(selectdisco, Float.class);

            String resultStringTemp = String.valueOf(resultTemp);
            String resultStringRam = String.valueOf(resultRam);
            String resultStringDisco = String.valueOf(resultDisk);

            cpuLabel.setText("Uso de CPU: " + resultStringTemp + " °C");
            ramLabel.setText("Uso de Ram: " + resultStringRam + " GB");
            diskLabel.setText("Uso de Disco: " + resultStringDisco + " %");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        MenuLoginCadastro loginCadastro = new MenuLoginCadastro();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastro");
        System.out.println("2. Login");
        System.out.println("3. Sair");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                System.out.println("Digite seu nome: ");
                String nome = scanner.nextLine();

                System.out.println("Digite seu email: ");
                String email = scanner.nextLine();

                System.out.println("Digite seu senha: ");
                String senha = scanner.nextLine();

                loginCadastro.cadastrarUsuario(nome, email, senha);
                break;
            case 2:
                System.out.println("Digite seu nome para login:");
                String nomeUsuario = scanner.nextLine();

                System.out.println("Digite sua senha para login:");
                String senhaUsuario = scanner.nextLine();

                isUserLoggedIn = loginCadastro.getUsuario(nomeUsuario, senhaUsuario);
                break;
            case 3:
                System.out.println("Saindo do programa.");
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

        if (isUserLoggedIn){
            SwingUtilities.invokeLater(() -> {
                Main app = new Main();

                Timer timer = new Timer(3000, e -> app.updateSystemData());
                timer.start();
            });
        }
    }


}
