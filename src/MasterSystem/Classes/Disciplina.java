package MasterSystem.Classes;

public class Disciplina {
	private String nome;
	private int cargaHoraria;
	private Professor professor;
	
	public Disciplina(String nome, int cargaHoraria, Professor professor) {
		setNome(nome);
		setCargaHoraria(cargaHoraria);
		setProfessor(professor);
	}
	
	private void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public String getProfessor() {
		return professor.getProfessor();
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	private void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public String getDisciplina() {
		return getNome();
	}
	
}
