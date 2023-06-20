package BE.licenta.Service;

import BE.licenta.Dto.Tabela_descriere_dto;
import BE.licenta.Entity.Tabela_descriere_entity;
import BE.licenta.Mapper.Tabela_descriere_mapper;
import BE.licenta.Repository.Tabela_descriere_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Tabela_descriere_service {

    private final Tabela_descriere_repo tabela_descriere_repo;

    private final Tabela_descriere_mapper tabela_descriere_mapper;

    @Autowired
    public Tabela_descriere_service(Tabela_descriere_repo tabela_descriere_repo, Tabela_descriere_mapper tabela_descriere_mapper) {
        this.tabela_descriere_repo = tabela_descriere_repo;
        this.tabela_descriere_mapper = tabela_descriere_mapper;
    }

    public Tabela_descriere_entity creare_descriere(Tabela_descriere_dto tabela_descriere_dto){

        return tabela_descriere_repo.save(tabela_descriere_mapper.entity_dto(tabela_descriere_dto));
    }

    public List<Tabela_descriere_dto> afisare_descriere(){

        return tabela_descriere_repo
                .findAll()
                .stream()
                .map(tabela_descriere_mapper::dto_entity)
                .toList();
    }

    public void stergere_descriere(int id){

        tabela_descriere_repo.deleteById(id);
    }

    public int returneaza_id_descriere(Tabela_descriere_entity tabela_descriere_entity){

        return tabela_descriere_entity.getId();
    }

    public Tabela_descriere_entity returneaza_descriere_dupa_id(int id){

        return tabela_descriere_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_descriere_entity actualizare(int id , Tabela_descriere_dto tabela_descriere_dto){

        tabela_descriere_dto.setId(id);

        return tabela_descriere_repo.save(tabela_descriere_mapper.entity_dto(tabela_descriere_dto));

    }


}
