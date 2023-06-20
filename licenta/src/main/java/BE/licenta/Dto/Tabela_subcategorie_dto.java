package BE.licenta.Dto;

import BE.licenta.Entity.Tabela_produs_entity;
import lombok.Data;

import java.util.List;

@Data

public class Tabela_subcategorie_dto {

    private int id;

    private int tabela_categorie_entity_id;

    private String denumire_subcategorie;

    private List<Tabela_produs_entity> tabela_produs_entity_list;

}
