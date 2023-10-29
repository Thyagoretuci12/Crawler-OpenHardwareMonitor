package pkg;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {
    private JdbcTemplate conexaoDoBanco;
    public Conexao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("Crawler");
        dataSource.setUser("ScrapUser");
        dataSource.setPassword("Scrap2023");

        conexaoDoBanco = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
}
