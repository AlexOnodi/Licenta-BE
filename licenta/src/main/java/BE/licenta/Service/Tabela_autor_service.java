package BE.licenta.Service;

import BE.licenta.Dto.Tabela_autor_dto;
import BE.licenta.Entity.Tabela_autor_entity;
import BE.licenta.Mapper.Tabela_autor_mapper;
import BE.licenta.Repository.Tabela_autor_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Tabela_autor_service {

    private final Tabela_autor_repo tabela_autor_repo;

    private final Tabela_autor_mapper tabela_autor_mapper;

    @Autowired
    public Tabela_autor_service(Tabela_autor_repo tabela_autor_repo, Tabela_autor_mapper tabela_autor_mapper) {
        this.tabela_autor_repo = tabela_autor_repo;
        this.tabela_autor_mapper = tabela_autor_mapper;
    }

    public Tabela_autor_entity creare_autor(Tabela_autor_dto tabela_autor_dto){

        return tabela_autor_repo.save(tabela_autor_mapper.entity_dto(tabela_autor_dto));
    }

    public List<Tabela_autor_dto> afisare_autor(){

        return tabela_autor_repo
                .findAll()
                .stream()
                .map(tabela_autor_mapper::dto_entity)
                .toList();
    }

    public void stergere_autor(int id){

        tabela_autor_repo.deleteById(id);
    }

    public int returneaza_id_autor(Tabela_autor_entity tabela_autor_entity){

        return tabela_autor_entity.getId();
    }

    public Tabela_autor_entity returneaza_autor_dupa_id(int id){

        return tabela_autor_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_autor_entity actualizare(int id , Tabela_autor_dto tabela_autor_dto){

        tabela_autor_dto.setId(id);

        return tabela_autor_repo.save(tabela_autor_mapper.entity_dto(tabela_autor_dto));

    }
}

