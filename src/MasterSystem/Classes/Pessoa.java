package MasterSystem.Classes;
import java.util.Date;

public class Pessoa {
	String nome;
	String cpf;
	Date dtNascimento;
	
	public Pessoa() {
		
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public String getCpf() {
		return cpf;
	}
}
