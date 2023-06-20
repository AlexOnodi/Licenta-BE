package BE.licenta.Repository;

import BE.licenta.Entity.Tabela_autor_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tabela_autor_repo extends JpaRepository<Tabela_autor_entity,Integer> {
}
