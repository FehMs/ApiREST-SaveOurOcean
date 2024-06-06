package api.SaveOurOcean.dto;

import api.SaveOurOcean.model.Relato;
import org.springframework.hateoas.RepresentationModel;

public class DadosListagemRelatosDTO extends RepresentationModel<DadosListagemRelatosDTO> {
    private Long id;
    private String tipo;
    private String descricao;
    private String latitude;
    private String longitude;

    public DadosListagemRelatosDTO(Relato relato) {
        this.id = relato.getId();
        this.tipo = relato.getTipo();
        this.descricao = relato.getDescricao();
        this.latitude = relato.getLatitude();
        this.longitude = relato.getLongitude();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
