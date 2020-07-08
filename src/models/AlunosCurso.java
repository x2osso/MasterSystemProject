package models;
import java.util.HashMap;

public class AlunosCurso {
	private Curso curso;
	private HashMap<String,Estudante> alunosCurso = new HashMap<String, Estudante>();
	
	public AlunosCurso(Curso curso) {
		setCurso(curso);
	
	}
	
	private void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public void inserirEstudante(Estudante estudante) {
		alunosCurso.put(estudante.getRA(), estudante);
	}
	
	public HashMap<String,Estudante> recuperarListaAlunos() {
		return alunosCurso;
	}
	
	public Estudante recuperarAluno(String RA) {
		return alunosCurso.get(RA);
	}
}
