package api.SaveOurOcean.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosVoluntarioDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String celular,
        @NotBlank
        String interesseArea
) {
}
