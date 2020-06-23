package MasterSystem.Classes;

public class Disciplina {
	
	String nome;
	int cargaHoraria;
	Professor professor;
	
	public Disciplina() {
	}
	public Disciplina(String nome, int cargaHoraria, Professor professor) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Professor getProfessor() {
		return professor;
	}
	public String getNome() {
		return nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
}
