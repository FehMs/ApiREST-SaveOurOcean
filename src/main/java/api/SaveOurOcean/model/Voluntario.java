package api.SaveOurOcean.model;

import api.SaveOurOcean.dto.DadosVoluntarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "voluntarios")
@Entity(name = "voluntario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Voluntario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String celular;
    private String interesseArea;

    public Voluntario(DadosVoluntarioDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.celular = dados.celular();
        this.interesseArea = dados.interesseArea();
    }
}
