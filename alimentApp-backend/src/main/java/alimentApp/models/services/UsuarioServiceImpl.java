package alimentApp.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alimentApp.models.dao.IContactoDao;
import alimentApp.models.dao.IUsuarioDao;
import alimentApp.models.entity.Donacion;
import alimentApp.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long cedula) {
		return usuarioDao.findById(cedula).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long cedula) {
		usuarioDao.deleteById(cedula);
	}
	
	@Transactional
	public Usuario findByNombre(String nombre) {
		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDao.findAll();
		for(int i = 0; i < listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i).getNombre().equals(nombre)){
				return listaUsuarios.get(i);
			}
		}
		return null;
	}
	
	@Transactional
	public Usuario recuperarContrasena(String correo) {
		Usuario usr = null;
		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDao.findAll();
		for(int i = 0; i < listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i).getInfoContacto().getCorreoPersonal().equals(correo)){
				Random rnd = new Random();
				int codigo = rnd. nextInt(999999);
				EmailSenderService sender = new EmailSenderService();
				usr = listaUsuarios.get(i);
				usr.setCodigoRecuperacion(codigo);
				sender.sendEmail(correo, "Recuperacion de contrasena",
									"Este es su codigo de recuperacion " + codigo);
			}
		}
		return usr;
	}
	

}
