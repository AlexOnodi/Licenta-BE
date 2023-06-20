package BE.licenta.Dto;

import lombok.Data;

@Data
public class Tabela_descriere_dto {

    private int id;

    private int tabela_produs_entity_id;

    private String titlu_descriere;

    private String text_descriere;
}
