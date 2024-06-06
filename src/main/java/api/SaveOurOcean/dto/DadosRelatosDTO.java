package api.SaveOurOcean.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosRelatosDTO(
        @NotBlank
        String tipo,
        @NotBlank
        String descricao,
        @NotBlank
        String latitude,
        @NotBlank
        String longitude
) {
}
