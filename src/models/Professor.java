package models;
import java.time.LocalDate;

public class Professor extends Pessoa{
	private String nRegistro;
	private String titulação;
	private float horasSemanais;
	private double precoHora;
	
	public Professor(String nome, String cpf, String nRegistro, String titulacao, float horasSemanais, double precoHora, LocalDate dtNascimento) {
        super(nome, cpf, dtNascimento);
        setTitulacao(titulacao);
        setNregistro(nRegistro);
        setPrecoHora(precoHora);
        setHorasSemanais(horasSemanais);
	}
	
	private void setTitulacao(String titulação) {
		this.titulação = titulação;
	}
	
	private void setPrecoHora(double precoHora) {
		this.precoHora = precoHora;
	}
	
	private void setNregistro(String nRegistro) {
		this.nRegistro = nRegistro;
	}
	
	private void setHorasSemanais(float horasSemanais) {
		this.horasSemanais = horasSemanais;
	}
	
	public String getTitulação() {
		return titulação;
	}
	
	public double getPrecoHora() {
		return precoHora;
	}
	
	public String getnRegistro() {
		return nRegistro;
	}
	
	public float getHorasSemanais() {
		return horasSemanais;
	}
	
	public String getProfessor() {
		return getNome();
	}
}
