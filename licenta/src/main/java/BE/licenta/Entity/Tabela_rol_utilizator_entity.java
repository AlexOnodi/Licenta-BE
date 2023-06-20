package BE.licenta.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tabela_rol_utilizator")

public class Tabela_rol_utilizator_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rol;

    @OneToOne
    @JoinColumn(name = "id_utilizator")
    @JsonBackReference
    private Tabela_utilizator_entity  tabela_utilizator_entity_id2;
}
