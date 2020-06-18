package MasterSystem.Classes;

public class Professor extends Pessoa{
	String nRegistro;
	String titulação;
	String horasSemanais;
	String precoHora;
	
	public Professor() {
		
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
