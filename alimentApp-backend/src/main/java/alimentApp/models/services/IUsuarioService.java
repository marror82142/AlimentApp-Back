package alimentApp.models.services;

import java.util.List;

import alimentApp.models.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(Long cedula);
	
	public void delete(Long cedula);

	public Usuario recuperarContrasena(String correo);
}
