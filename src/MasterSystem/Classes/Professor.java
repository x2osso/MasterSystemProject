package MasterSystem.Classes;
import java.time.LocalDate;
import java.util.Date;

public class Professor extends Pessoa{
	String nRegistro;
	String titulação;
	String horasSemanais;
	String precoHora;
	int status;
	
	public Professor(String nome, String cpf, String nRegistro,String titulação,String horasSemanais,
	String precoHora,int status) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.nRegistro = nRegistro;
        this.titulação = titulação;
        this.horasSemanais = horasSemanais;
        this.precoHora = precoHora;
        this.status = status;
	}
	public void setTitulação(String titulação) {
		this.titulação = titulação;
	}
	public void setPrecoHora(String precoHora) {
		this.precoHora = precoHora;
	}
	public void setnRegistro(String nRegistro) {
		this.nRegistro = nRegistro;
	}
	public void setHorasSemanais(String horasSemanais) {
		this.horasSemanais = horasSemanais;
	}
	public String getTitulação() {
		return titulação;
	}
	public String getPrecoHora() {
		return precoHora;
	}
	public String getnRegistro() {
		return nRegistro;
	}
	public String getHorasSemanais() {
		return horasSemanais;
	}
}
