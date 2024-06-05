package api.SaveOurOcean.Controller;


import api.SaveOurOcean.DTO.DadosListagemRelatosDTO;
import api.SaveOurOcean.DTO.DadosRelatosDTO;
import api.SaveOurOcean.Model.Relato;
import api.SaveOurOcean.Repository.RelatosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("relatos")
public class RelatoController {

    @Autowired
    private RelatosRepository repository;

    @PostMapping
    @Transactional
    public void relatar(@RequestBody @Valid DadosRelatosDTO dados){
        repository.save(new Relato(dados));
    }

    @GetMapping
    public List<Relato> listar(){
        return repository.findAll();
    }
}
