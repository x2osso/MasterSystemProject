package MasterSystem.Classes;
import java.util.Date;
import java.util.Map;

public class Aula {
	String lab;
	Date dataHora;
	Disciplina disciplina;
	Map<String,Estudante> alunosAula;
	
	public Aula() {
		
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getLab() {
		return lab;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void addAluno(Estudante aluno) {
		
	}
	public Map<String,Estudante> getListaDeAlunos(){
		return alunosAula;
	}
	public Estudante getAluno(String RA) {/*duvida :(*/
		return null;
	}
}
