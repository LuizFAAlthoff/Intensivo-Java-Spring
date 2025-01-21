package com.intensivojavaspring.dslist.dto;
// DTO É O OBJETO MÍNIMO DE UMA ENTIDADE PARA ECONOMIZAR RECURSOS DE API/BANDA
import com.intensivojavaspring.dslist.entities.Game;

// cria-se uma classe igual à entidade, mas com um subconjunto de atributos
public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
