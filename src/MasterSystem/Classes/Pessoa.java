package MasterSystem.Classes;
import java.time.LocalDate;

public class Pessoa {
	private String nome;
	private String cpf;
	private LocalDate dtNascimento;
	
	public Pessoa(String nome, String cpf, LocalDate dtNascimento) {
		setNome(nome);
		setCpf(cpf);
		setDtNascimento(dtNascimento);
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	private void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
}
