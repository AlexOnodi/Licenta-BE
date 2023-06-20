package BE.licenta.Repository;

import BE.licenta.Entity.Tabela_descriere_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tabela_descriere_repo extends JpaRepository<Tabela_descriere_entity,Integer> {
}