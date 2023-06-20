package BE.licenta.Dto;

import BE.licenta.Entity.Tabela_autor_entity;
import BE.licenta.Entity.Tabela_descriere_entity;
import BE.licenta.Entity.Tabela_favorite_entity;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data

public class Tabela_produs_dto {

    private int id;

    private int tabela_subcategorie_entity_id;

    private String denumire;

    private Date data_adaugare;

    private double pret;

    private String string_poza;

    private List<Tabela_autor_entity> tabela_autor_entity_list;

    private List<Tabela_descriere_entity>tabela_descriere_entity_list;

    private List<Tabela_favorite_entity>tabela_favorite_entity_list;


}
