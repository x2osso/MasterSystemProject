package MasterSystem.Classes;
import java.util.ArrayList;

public class Curso {
	private String nomeCurso;
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Curso(String nomeCurso, Disciplina disciplina) {
		setNomeCurso(nomeCurso);
		inserirDisciplina(disciplina);
	}
	
	private void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	private void inserirDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public ArrayList<Disciplina> recuperarDisciplinas() {
		return disciplinas;
	}
}