package api.SaveOurOcean.controller;

import api.SaveOurOcean.dto.DadosListVoluntarioDTO;
import api.SaveOurOcean.dto.DadosVoluntarioDTO;
import api.SaveOurOcean.model.Voluntario;
import api.SaveOurOcean.repository.VoluntarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("voluntario")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository repository;

    @PostMapping
    @Transactional
    public void CadVoluntario(@RequestBody @Valid DadosVoluntarioDTO dados){
        repository.save(new Voluntario(dados));
    }

    @GetMapping
    public Page<DadosListVoluntarioDTO> listar(@PageableDefault Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListVoluntarioDTO::new);
    }


}
