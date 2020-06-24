package MasterSystem.Classes;

import java.util.ArrayList;

public class Colegiado {
	Curso curso;
	public static ArrayList<Professor> professores = new ArrayList<Professor>();
	
	public Colegiado() {
		
	}
	public static void setProfessores(ArrayList<Professor> professores) {
		Colegiado.professores = professores;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public static ArrayList<Professor> getProfessores() {
		return professores;
	}
	public Curso getCurso() {
		return curso;
	}
}
