package BE.licenta.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tabela_subcategorie")



public class Tabela_subcategorie_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String denumire_subcategorie;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categorie")
    @JsonBackReference
    private Tabela_categorie_entity tabela_categorie_entity_id;

    @OneToMany(mappedBy = "tabela_subcategorie_entity_id",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tabela_produs_entity> tabela_produs_entity_list;

}
