package MasterSystem.Classes;

public class Estudante {
	String RA;
	int periodo;
	Curso curso;
	
	public Estudante() {
		
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getRA() {
		return RA;
	}
	public int getPeriodo() {
		return periodo;
	}
	public Curso getCurso() {
		return curso;
	}
	
}
