package BE.licenta.Repository;

import BE.licenta.Entity.Tabela_utilizator_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tabela_utilizator_repo extends JpaRepository<Tabela_utilizator_entity,Integer> {

    Tabela_utilizator_entity findByEmail(String email);

}
