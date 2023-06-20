package BE.licenta.Repository;

import BE.licenta.Entity.Tabela_produs_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tabela_produs_repo extends JpaRepository<Tabela_produs_entity,Integer> {

    List<Tabela_produs_entity>findByDenumireContainingIgnoreCase(String denumire_produs);

}