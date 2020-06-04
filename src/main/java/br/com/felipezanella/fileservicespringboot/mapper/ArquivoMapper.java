package br.com.felipezanella.fileservicespringboot.mapper;

import br.com.felipezanella.fileservicespringboot.model.Arquivo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArquivoMapper implements RowMapper<Arquivo> {

    @Override
    public Arquivo mapRow(ResultSet resultSet, int i) throws SQLException {

        Arquivo arquivo = new Arquivo();
        arquivo.setIdArquivo(resultSet.getLong("ID_ARQUIVO"));
        arquivo.setNomeArquivo(resultSet.getString("NOME_ARQUIVO"));

        return arquivo;
    }
}
