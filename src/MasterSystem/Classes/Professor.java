package MasterSystem.Classes;

public class Professor extends Pessoa{
	String nRegistro;
	String titula��o;
	String horasSemanais;
	String precoHora;
	
	public Professor() {
		
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
}
