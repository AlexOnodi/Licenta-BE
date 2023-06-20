package BE.licenta.Repository;

import BE.licenta.Entity.Tabela_categorie_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tabela_categorie_repo extends JpaRepository<Tabela_categorie_entity,Integer> {

    List<Tabela_categorie_entity>findByDenumireContainingIgnoreCase(String denumre_categorie);
}
