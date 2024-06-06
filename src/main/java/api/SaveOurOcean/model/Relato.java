package api.SaveOurOcean.model;

import api.SaveOurOcean.dto.DadosAttRelatosDTO;
import api.SaveOurOcean.dto.DadosRelatosDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Table(name = "relatos")
@Entity(name = "Relato")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Relato extends RepresentationModel<Relato> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descricao;
    private String latitude;
    private String longitude;

    public Relato(DadosRelatosDTO dados) {
        this.tipo = dados.tipo();
        this.descricao = dados.descricao();
        this.latitude = dados.latitude();
        this.longitude = dados.longitude();
    }

    public void atualizarInformacoes(DadosAttRelatosDTO dados) {
        if (dados.tipo() != null) {
            this.tipo = dados.tipo();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.latitude() != null) {
            this.latitude = dados.latitude();
        }
        if (dados.longitude() != null) {
            this.longitude = dados.longitude();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }
}
