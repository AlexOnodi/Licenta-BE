package BE.licenta.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tabela_adresa")


public class Tabela_adresa_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tara;

    private String judet;

    private String domiciliu;

    private String string_adresa;

    @ManyToOne
    @JoinColumn(name = "id_utilizator")
    @JsonBackReference
    private Tabela_utilizator_entity tabela_utilizator_entity_id;

}
