package br.com.felipezanella.fileservicespringboot.repository;

import br.com.felipezanella.fileservicespringboot.mapper.ArquivoMapper;
import br.com.felipezanella.fileservicespringboot.model.Arquivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ArquivoRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Arquivo findById(Long idArquivo) {
        String sql = "select * from arquivo where id_arquivo = :id_arquivo";

        Map<String, Object> params = new HashMap<>();
        params.put("id_arquivo", idArquivo);

        return namedParameterJdbcTemplate.queryForObject(sql, params, new ArquivoMapper());
    }

    public void insert(Arquivo arquivo) {
        String sql = "insert into arquivo (nome_arquivo, conteudo) values (:nome_arquivo, :conteudo)";

        Map<String, Object> params = new HashMap<>();
        params.put("nome_arquivo", arquivo.getNomeArquivo());
        params.put("conteudo", arquivo.getConteudo());

        namedParameterJdbcTemplate.update(sql, params);
    }

}
