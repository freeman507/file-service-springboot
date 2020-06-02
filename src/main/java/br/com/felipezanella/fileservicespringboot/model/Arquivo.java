package br.com.felipezanella.fileservicespringboot.model;

import lombok.Data;
import org.springframework.core.io.Resource;

@Data
public class Arquivo {

    private Long idArquivo;

    private String nomeArquivo;

    private byte[] conteudo;

    private Resource resource;
}
