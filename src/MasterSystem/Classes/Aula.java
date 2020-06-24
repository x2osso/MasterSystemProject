package MasterSystem.Classes;
import java.util.Date;
import java.util.HashMap;

public class Aula {
	private String lab;
	private Date dataHora;
	private Disciplina disciplina;
	private HashMap<String,Estudante> alunosAula = new HashMap<String, Estudante>();
	
	public Aula(String lab, Date dataHora, Disciplina disciplina) {
		setLab(lab);
		setDataHora(dataHora);
		setDisciplina(disciplina);
	}
	
	private void setLab(String lab) {
		this.lab = lab;
	}
	
	public String getLab() {
		return this.lab;
	}
	
	private void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	public Date getDataHora() {
		return this.dataHora;
	}
	
	private void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Disciplina getDisciplina() {
		return this.disciplina;
	}
	
	public void addAluno(Estudante aluno) {
		alunosAula.put(aluno.getRA(), aluno);
	}
	
	public HashMap<String,Estudante> getListaDeAlunos(){
		return alunosAula;
	}
	
	public Estudante getAluno(String RA) {
		return alunosAula.get(RA);
	}
}
