package com.panchi.ejercicio.models.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_persona")
	private Integer idpersona;
	
	@Column(name="nombre")
	@NotEmpty
	@Size(max=35)
	private String nombre;
	
	@Column(name="apellido")
	@Size(max=35)
	private String apellido;
	
	@Column(name="cedula")
	@NotEmpty
	@Size(max=10)
	private String cedula;
	
	@Column(name="lugar_nacimiento")
	private String lugarNacimiento;
	
	@Column(name="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaNacimiento;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="email")
	@Email
	private String email;
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name="telefono")
	private String telefono;
	
	public Persona() {
		super();
	}
	
	public Persona (Integer id) {
		super();
		this.idpersona =id;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return this.getApellido()+ " "+this.getNombre();
	}
	
	public String fechaNac() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fechaNacimiento.getTime());
	}
	
}
