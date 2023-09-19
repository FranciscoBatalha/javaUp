package com.example.cadastroautores.controller;
import com.example.cadastroautores.model.Autor;
import com.example.cadastroautores.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173")//Endereço do front
@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorRepository AutorRepository;
    @GetMapping
    public List<Autor> listarVeiculos() {
        return AutorRepository.findAll();
    }
    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        return AutorRepository.save(autor);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAutor(@PathVariable Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return ResponseEntity.ok("Autor deletado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizarVeiculo(@PathVariable Long id, @RequestBody Autor autorAtualizado) {
        if (veiculoRepository.existsById(id)) {
            Autor autor = autorRepository.findById(id).get();
            autor.setEdicao(autorAtualizado.getEdicao());
            autor.setEditora(autorAtualizado.getEditora());
            autor.setColecao(autorAtualizado.getColecao());
            autor.setAno(autorAtualizado.getAno());

            Autor autorAtualizadoBD = autorRepository.save(autor);
            return ResponseEntity.ok(autorAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
