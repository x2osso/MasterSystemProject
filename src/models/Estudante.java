package models;

import java.time.LocalDate;

public class Estudante extends Pessoa {
	private String RA;
	private String periodo;
	private Curso curso;
	
	public Estudante(String nome, String cpf, LocalDate dtNascimento, String RA, String periodo, Curso curso) {
		super(nome, cpf, dtNascimento);
		setRA(RA);
		setPeriodo(periodo);
		setCurso(curso);
	}
	
	private void setRA(String RA) {
		this.RA = RA;
	}
	
	public String getRA() {
		return this.RA;
	}
	
	private void setPeriodo(String periodo2) {
		this.periodo = periodo2;
	}
	
	public String getPeriodo() {
		return this.periodo;
	}
	
	private void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public String toString() {
		return this.getNome();
	}
}
