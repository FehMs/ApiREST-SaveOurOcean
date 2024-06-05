package api.SaveOurOcean.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
