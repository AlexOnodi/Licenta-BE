package BE.licenta.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tabela_categorie")

public class Tabela_categorie_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "denumire_categorie")
    private String denumire;

    @OneToMany(mappedBy = "tabela_categorie_entity_id",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tabela_subcategorie_entity> tabela_subcategorie_entity_list;
}
