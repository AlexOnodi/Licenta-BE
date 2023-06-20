package BE.licenta.Service;
import BE.licenta.Dto.Tabela_utilizator_dto;
import BE.licenta.Entity.LogareReq;
import BE.licenta.Entity.Tabela_utilizator_entity;
import BE.licenta.Mapper.Tabela_utilizator_mapper;
import BE.licenta.Repository.Tabela_utilizator_repo;
import BE.licenta.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Tabela_utilizator_service  implements UserDetailsService {

    private final Tabela_utilizator_repo tabela_utilizator_repo;

    private final Tabela_utilizator_mapper tabela_utilizator_mapper;

    private final JwtUtil jwtUtil;



    @Autowired
    public Tabela_utilizator_service(Tabela_utilizator_repo tabela_utilizator_repo, Tabela_utilizator_mapper tabela_utilizator_mapper,JwtUtil jwtUtil) {
        this.tabela_utilizator_repo = tabela_utilizator_repo;
        this.tabela_utilizator_mapper = tabela_utilizator_mapper;
        this.jwtUtil=jwtUtil;
    }

    public Tabela_utilizator_entity creare_utilizator(Tabela_utilizator_dto tabela_utilizator_dto){

        return tabela_utilizator_repo.save(tabela_utilizator_mapper.entity_dto(tabela_utilizator_dto));
    }

    public List<Tabela_utilizator_dto> afisare_utilizator(){

        return tabela_utilizator_repo
                .findAll()
                .stream()
                .map(tabela_utilizator_mapper::dto_entity)
                .toList();
    }

    public void stergere_utilizator(int id){

        tabela_utilizator_repo.deleteById(id);
    }

    public int returneaza_id_utilizator(Tabela_utilizator_entity tabela_utilizator_entity){

        return tabela_utilizator_entity.getId();
    }

    public Tabela_utilizator_entity returneaza_utilizator_dupa_id(int id){

        return tabela_utilizator_repo
                .findById(id)
                .orElse(null);
    }

    public Tabela_utilizator_entity actualizare(int id , Tabela_utilizator_dto tabela_utilizator_dto){

        tabela_utilizator_dto.setId(id);

        return tabela_utilizator_repo.save(tabela_utilizator_mapper.entity_dto(tabela_utilizator_dto));

    }

    @Override
    public Tabela_utilizator_entity loadUserByUsername(String username) throws UsernameNotFoundException {
        Tabela_utilizator_entity user = null;

        try {
            user = tabela_utilizator_repo.findByEmail(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public String authenticate(LogareReq authenticationRequest) {
        final Tabela_utilizator_entity userDetails = loadUserByUsername(authenticationRequest.getUsername());

        return jwtUtil.generateToken(userDetails);
    }




}

