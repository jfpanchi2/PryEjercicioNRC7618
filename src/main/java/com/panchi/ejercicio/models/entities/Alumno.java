package com.panchi.ejercicio.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




@Entity
@Table(name="alumnos")
public class Alumno extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="identificador")
	@NotEmpty
	@Size(max=10)
	private String identificador;
	
	@OneToMany(mappedBy="estudiante", fetch=FetchType.LAZY)
	private List<Matricula> matriculas;
	
	
	public Alumno() {
		super();
	}

	public Alumno(Integer id) {
		super();
		this.setIdpersona(id);;
	}
	
	
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
	
	
	
}
