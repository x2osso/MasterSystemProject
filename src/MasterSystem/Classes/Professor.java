package MasterSystem.Classes;
import java.time.LocalDate;
import java.util.Date;

public class Professor extends Pessoa{
	String nRegistro;
	String titula��o;
	String horasSemanais;
	String precoHora;
	int status;
	
	public Professor(String nome, String cpf, String nRegistro,String titula��o,String horasSemanais,
	String precoHora,int status) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.nRegistro = nRegistro;
        this.titula��o = titula��o;
        this.horasSemanais = horasSemanais;
        this.precoHora = precoHora;
        this.status = status;
	}
	public void setTitula��o(String titula��o) {
		this.titula��o = titula��o;
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
	public String getTitula��o() {
		return titula��o;
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
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}
	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}
	@Override
	public Date getDtNascimento() {
		// TODO Auto-generated method stub
		return super.getDtNascimento();
	}
	@Override
	public void setCpf(String cpf) {
		// TODO Auto-generated method stub
		super.setCpf(cpf);
	}
	@Override
	public void setDtNascimento(Date dtNascimento) {
		// TODO Auto-generated method stub
		super.setDtNascimento(dtNascimento);
	}
	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		super.setNome(nome);
	}
	public String getProfessor() {
		return getNome();
	}
}
