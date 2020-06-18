package MasterSystem.Classes;
import java.util.Scanner;

public class Executavel {
	
	public static void main(String[] args) {
		Menu();
	}
	
	public static void Menu() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int loop = 0;
		String escolha;
		
		do {
			System.out.println("-----Menu-----\n");
			System.out.println("(a)Cadastro do curso");
			System.out.println("(b)Cadastro dos alunos no curso");
			System.out.println("(c)Cadastro do colegiado (professores) do curso");
			System.out.println("(d)Cadastro das disciplinas do curso");
			System.out.println("(e)Cadastro de uma aula deste curso");
			System.out.println("(f)Listagem dos alunos do curso");
			System.out.println("(g)Listagem das disciplinas do curso");
			System.out.println("(h)Listagem do colegiado do curso");
			System.out.println("(i)Listagem da aula do curso");
			escolha = sc.next();
			
			switch(escolha) {
				case "a":
					loop = 1;//quebra do loop;
					
					break;
				case "b":
					loop = 1;//quebra do loop;
					break;
				case "c":
					loop = 1;//quebra do loop;
					break;
				case "d":
					loop = 1;//quebra do loop;
					break;
				case "e":
					loop = 1;//quebra do loop;
					break;
				case "f":
					loop = 1;//quebra do loop;
					break;
				case "g":
					loop = 1;//quebra do loop;
					break;
				case "h":
					loop = 1;//quebra do loop;
					break;
				case "i":
					loop = 1;//quebra do loop;
					break;
				default:
					System.out.println("Entrada invalida !!");
					loop = 0;
			}
		}while(loop == 0);
		
	}
}
