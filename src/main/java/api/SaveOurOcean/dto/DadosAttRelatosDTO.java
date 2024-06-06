package api.SaveOurOcean.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAttRelatosDTO(
        @NotNull
        Long id,
        String tipo,
        String descricao,
        String latitude,
        String longitude) {
}
