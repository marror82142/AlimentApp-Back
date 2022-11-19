package alimentApp.models.dao;

import org.springframework.data.repository.CrudRepository;

import alimentApp.models.entity.Donacion;

public interface IDonacionDao extends CrudRepository<Donacion, Long>{

}
