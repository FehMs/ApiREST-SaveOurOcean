package api.SaveOurOcean.controller;

import api.SaveOurOcean.dto.DadosAttRelatosDTO;
import api.SaveOurOcean.dto.DadosListagemRelatosDTO;
import api.SaveOurOcean.dto.DadosRelatosDTO;
import api.SaveOurOcean.exception.ResourceNotFoundException;
import api.SaveOurOcean.model.Relato;
import api.SaveOurOcean.repository.RelatosRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("relatos")
public class RelatoController {

    @Autowired
    private RelatosRepository repository;

    @PostMapping
    @Transactional
    public void relatar(@RequestBody @Valid DadosRelatosDTO dados){
        Relato relato = new Relato(dados);
        repository.save(relato);
    }

    
    @GetMapping
    public Page<DadosListagemRelatosDTO> listar(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAll(paginacao).map(relato -> {
            DadosListagemRelatosDTO dto = new DadosListagemRelatosDTO(relato);
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RelatoController.class).listarPorId(relato.getId())).withSelfRel();
            dto.add(selfLink);
            return dto;
        });
    }

    @GetMapping("/{id}")
    public Relato listarPorId(@PathVariable Long id) {
        Relato relato = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relato não encontrado com id " + id));
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RelatoController.class).listarPorId(id)).withSelfRel();
        relato.add(selfLink);
        return relato;
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAttRelatosDTO dados){
        var relato = repository.findById(dados.id())
                .orElseThrow(() -> new ResourceNotFoundException("Relato não encontrado com id " + dados.id()));
        relato.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Relato não encontrado com id " + id);
        }
        repository.deleteById(id);
    }
}
