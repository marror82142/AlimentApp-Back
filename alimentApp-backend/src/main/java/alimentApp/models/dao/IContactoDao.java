package alimentApp.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import alimentApp.models.entity.Contacto;
import alimentApp.models.entity.Usuario;

public interface IContactoDao extends CrudRepository<Contacto, Long>{

}
