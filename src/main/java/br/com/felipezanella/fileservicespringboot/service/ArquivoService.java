package br.com.felipezanella.fileservicespringboot.service;

import br.com.felipezanella.fileservicespringboot.model.Arquivo;
import br.com.felipezanella.fileservicespringboot.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    public void insert(Arquivo arquivo) {
        arquivoRepository.insert(arquivo);
    }

    public void insert(MultipartFile multipartFile) throws IOException {

        Arquivo arquivo = new Arquivo();

        arquivo.setNomeArquivo(multipartFile.getOriginalFilename());

        arquivo.setConteudo(multipartFile.getBytes());

        insert(arquivo);
    }

    public Arquivo findById(Long idArquivo) {

        Arquivo arquivo = arquivoRepository.findById(idArquivo);

        InputStream inputStream = new ByteArrayInputStream(arquivo.getConteudo());

        arquivo.setResource(new InputStreamResource(inputStream));

        return arquivo;
    }

}
