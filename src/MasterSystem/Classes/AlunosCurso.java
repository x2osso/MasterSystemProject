package MasterSystem.Classes;
import java.util.Map;

public class AlunosCurso {
	Curso curso;
	Map<String,Estudante> alunosCurso;
	
	public AlunosCurso() {
		
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Curso getCurso() {
		return curso;
	}
	public void inserirAluno(Estudante estudante) {
		
	}
	public Map<String,Estudante> recuperarListaAlunos() {
		return alunosCurso;
	}
	public Estudante recuperaAluno(String RA) {/*DUVIDA AQUI GUYS*/
		return null;
	}
	
}
