package api.SaveOurOcean.Model;

import api.SaveOurOcean.DTO.DadosRelatosDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "relatos")
@Entity(name = "Relato")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Relato {

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
}
