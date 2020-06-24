package MasterSystem.Classes;

import java.util.ArrayList;

public class Colegiado {
	private Curso curso;
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	
	public Colegiado(Curso curso, Professor professor) {
		setCurso(curso);
		inserirProfessor(professor);
	}
	
	private void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	private void inserirProfessor(Professor professor) {
		professores.add(professor);
	}
	
	public ArrayList<Professor> recuperarProfessores() {
		return professores;
	}
}
