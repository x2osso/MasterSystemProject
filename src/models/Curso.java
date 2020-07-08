package models;
import java.util.ArrayList;

public class Curso {
	private String nomeCurso;
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Curso(String nomeCurso) {
		setNomeCurso(nomeCurso);
	}
	
	private void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void inserirDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public ArrayList<Disciplina> recuperarDisciplinas() {
		return disciplinas;
	}
}