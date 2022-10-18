package alimentApp.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacto")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="correo_personal")
	private String correoPersonal;
	private String direccion;
	@Column(name="pais_residencia")
	private String paisResidencia;
	@Column(name="departamento_residencia")
	private String departamentoResidencia;
	@Column(name="ciudad_residencia")
	private String ciudadResidencia;
	private String telefono;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorreoPersonal() {
		return correoPersonal;
	}
	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPaisResidencia() {
		return paisResidencia;
	}
	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}
	public String getDepartamentoResidencia() {
		return departamentoResidencia;
	}
	public void setDepartamentoResidencia(String departamentoResidencia) {
		this.departamentoResidencia = departamentoResidencia;
	}

}
