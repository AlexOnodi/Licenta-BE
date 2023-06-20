package BE.licenta.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tabela_favorite")

public class Tabela_favorite_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @ManyToOne
    @JoinColumn(name = "id_produs")
    @JsonBackReference
    private Tabela_produs_entity tabela_produs_entity_id;


}
