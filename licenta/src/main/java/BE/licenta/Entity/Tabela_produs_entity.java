package BE.licenta.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tabela_produs")

public class Tabela_produs_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "denumire_produs")
    private String denumire;

    private Date data_adaugare;

    private double pret;

    private String string_poza;

    @ManyToOne
    @JoinColumn(name = "id_subcategorie")
    @JsonBackReference
    private Tabela_subcategorie_entity tabela_subcategorie_entity_id;

    @OneToMany(mappedBy = "tabela_produs_entity_id", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tabela_autor_entity> tabela_autor_entity_list;

    @OneToMany(mappedBy = "tabela_produs_entity_id",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tabela_descriere_entity>tabela_descriere_entity_list;

    @OneToMany(mappedBy = "tabela_produs_entity_id")
    @JsonManagedReference
    private List<Tabela_favorite_entity>tabela_favorite_entity_list;


}
