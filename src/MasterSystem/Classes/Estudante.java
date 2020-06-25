package MasterSystem.Classes;

import java.time.LocalDate;

public class Estudante extends Pessoa {
	private String RA;
	private int periodo;
	private Curso curso;
	
	public Estudante(String nome, String cpf, LocalDate dtNascimento, String RA, int periodo, Curso curso) {
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
	
	private void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public int getPeriodo() {
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
