package BE.licenta.Repository;

import BE.licenta.Entity.Tabela_favorite_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tabela_favorite_repo extends JpaRepository<Tabela_favorite_entity,Integer> {
}