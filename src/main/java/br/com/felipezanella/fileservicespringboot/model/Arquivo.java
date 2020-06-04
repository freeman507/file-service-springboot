package br.com.felipezanella.fileservicespringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.core.io.Resource;

@Data
public class Arquivo {

    private Long idArquivo;

    private String nomeArquivo;

    @JsonIgnore
    private byte[] conteudo;

    @JsonIgnore
    private Resource resource;
}
