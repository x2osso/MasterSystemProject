package models;

import java.util.ArrayList;

public class Colegiado {
	private Curso curso;
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	
	public Colegiado(Curso curso) {
		setCurso(curso);
	}
	
	private void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void inserirProfessor(Professor professor) {
		professores.add(professor);
	}
	
	public ArrayList<Professor> recuperarProfessores() {
		return professores;
	}
}
