package api.SaveOurOcean.dto;

import api.SaveOurOcean.model.Voluntario;

public record DadosListVoluntarioDTO(
        Long id,
        String nome,
        String email,
        String celular,
        String interesseArea
) {
    public DadosListVoluntarioDTO(Voluntario voluntario){
        this(voluntario.getId(), voluntario.getNome(), voluntario.getEmail(), voluntario.getCelular(), voluntario.getInteresseArea());
    }
}
