package br.com.felipezanella.fileservicespringboot.endpoint;

import br.com.felipezanella.fileservicespringboot.model.Arquivo;
import br.com.felipezanella.fileservicespringboot.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("arquivo")
public class ArquivoEndpoint {

    @Autowired
    private ArquivoService arquivoService;

    @PostMapping
    public void insert(
            @RequestParam("file") MultipartFile multipartFile
    ) throws IOException {
        arquivoService.insert(multipartFile);
    }

    @GetMapping("{idArquivo}")
    public ResponseEntity<Resource> findById(@PathVariable("idArquivo") Long idArquivo) {
        Arquivo arquivo = arquivoService.findById(idArquivo);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + arquivo.getNomeArquivo() + "\"").body(arquivo.getResource());
    }
}
