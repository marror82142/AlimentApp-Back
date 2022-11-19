package alimentApp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alimentApp.models.dao.IContactoDao;
import alimentApp.models.dao.IDonacionDao;
import alimentApp.models.dao.IUsuarioDao;
import alimentApp.models.entity.Donacion;
import alimentApp.models.entity.Usuario;

@Service
public class DonacionServiceImpl implements IDonacionService {

	@Autowired
	private IDonacionDao donacionDao;
	
	@Override
	@Transactional
	public Donacion createDonacion(Donacion donacion) {
		EmailSenderService sender = new EmailSenderService();
		
		sender.sendEmail(donacion.getUsuario().getInfoContacto().getCorreoPersonal(),
							"Donacion Registrada",
							"La donacion ha sido registrada y se ha enviado al banco de alimentos");
		
		sender.sendEmail("esteban_vasquez82171@elpoli.edu.co",
						"Donacion Registrada",
								"Una donacion de " + donacion.getDescripcion()
								+" ha sido registrada por " + donacion.getUsuario().getNombre()
								+" para recoleccion el dia " 
								+ donacion.getFechaRecoleccion().getDay()
								+"/"+donacion.getFechaRecoleccion().getMonth()
								+"/"+donacion.getFechaRecoleccion().getYear()
								+" a las " 
								+ donacion.getFechaRecoleccion().getHours()+":"+donacion.getFechaRecoleccion().getMinutes()
								+"En la direccion " + donacion.getUsuario().getInfoContacto().getDireccion()
								+ " ciudad " + donacion.getUsuario().getInfoContacto().getCiudadResidencia()
								+ "-" + donacion.getUsuario().getInfoContacto().getDepartamentoResidencia());
		return donacionDao.save(donacion);
	}
	
}
