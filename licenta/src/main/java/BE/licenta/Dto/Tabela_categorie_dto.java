package BE.licenta.Dto;

import BE.licenta.Entity.Tabela_subcategorie_entity;
import lombok.Data;

import java.util.List;

@Data

public class Tabela_categorie_dto {

    private int id;

    private String denumire;

    private List<Tabela_subcategorie_entity> tabela_subcategorie_entity_list;
}
