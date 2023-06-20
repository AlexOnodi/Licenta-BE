package BE.licenta.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tabela_autor")

public class Tabela_autor_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String nume;

    private String prenume;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produs")
    @JsonBackReference
    private Tabela_produs_entity tabela_produs_entity_id;

}
