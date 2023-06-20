package BE.licenta.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tabela_descriere")

public class Tabela_descriere_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String titlu_descriere;

    private String text_descriere;

    @ManyToOne
    @JoinColumn(name = "id_produs")
    @JsonBackReference
    private Tabela_produs_entity tabela_produs_entity_id;
}
