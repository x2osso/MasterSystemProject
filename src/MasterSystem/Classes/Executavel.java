package MasterSystem.Classes;
import java.awt.peer.ScrollbarPeer;
import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Executavel {
	
	public static ArrayList<Professor> professores = new ArrayList<Professor>();
	public static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public static Scanner sc = new Scanner(System.in);
    public static int tam=1;
    public static int contador =1;
	
	public static void main(String[] args) {
		Menu_Principal();
	}
	
	public static void Menu_Principal() {	
		int loop = 0;
		String escolha;
		do {
			System.out.println("\n\n-----Menu-Principal-----");
			System.out.println("     (a)Cadastros");
			System.out.println("     (b)Pesquisas");
			System.out.println("     (c)Exit");
			System.out.println("------------------------");
			System.out.println("Digite uma Opcao:");
			escolha = sc.next();
			
			switch(escolha) {
				case "a":
					loop = 1;//quebra do loop;
					Menu_Cadastro();
					break;
				case "b":
					loop = 1;//quebra do loop;
					Lista_Disciplina();
					break;
				default:
					System.out.println("Entrada invalida !!");
					loop = 0;
			}
		}while(loop == 0);
		
	}
	
	public static void Menu_Pesquisas() {
		int loop = 0;
		
		do {
			
			System.out.println("----MENU DE PESQUISA----");
			System.out.println("(1)Listar professor;");
			System.out.println("(2)Listar Disciplina;");
			int escolha = sc.nextInt();
			switch(escolha) {
			case 1:
				loop = 1;
				Lista_Professores();
				break;
			case 2:
				loop = 1;
				Lista_Disciplina();
				break;
			default:
				System.out.println("Entrada invalida!!!!");
			}
			
			
		}while(loop == 0);
	}
	
public static void Menu_Cadastro(){
		int loop = 0;
		String escolha;
		
		do {
		System.out.println("\n\n-----Menu-De-Cadastro-----");
		System.out.println("(a)Cadastro de Professores");
		System.out.println("(b)Cadastro de Disciplinas");
		System.out.println("(c)Cadastro de Cursos");
		System.out.println("(d)Cadastro de Aulas");
		System.out.println("(e)Cadastro de Colegiados");
		System.out.println("(f)Cadastro de Estudantes");
		System.out.println("(g)Cadastro de Alunos no Curso");
		System.out.println("--------------------------");
		System.out.println("(0)Voltar ao Menu Principal");
		System.out.println("(1)Encerrar Sistema");
		System.out.println("--------------------------");
		System.out.println("Digite uma Opcao:");
		escolha = sc.next();
		
		switch(escolha) {
			case "a":
					Cadastro_Professor();
				break;
			case "b":
					Cadastro_Diciplina();
				loop = 1;
				break;
			case "0":
				loop = 1;//quebra do loop;
				Menu_Principal();
				break;
			default:
				System.out.println("Entrada invalida !!");
				loop = 0;	
		}
		}while(loop == 0);
	}
	
	public static void Cadastro_Professor() {
        int loop = 0;
        int escolha = 0;

        do {
            System.out.printf("----Cadastro  %d Professor----\n",contador);
            System.out.println("Digite o Nome:");
            String nome = sc.next();
            System.out.println("Digite o cpf:");
            String cpf = sc.next(); 
            System.out.println("Digite data de nascimento:");
            String dataString = sc.next(); 
            String [] dataSeparada = dataString.split("/");
            LocalDate  dtNascimento = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
            System.out.println(dtNascimento);
            System.out.println("Digite registro:");
            String nRegistro = sc.next(); 
            System.out.println("Digite titulação");
            String titulação = sc.next(); 
            System.out.println("Digite horasSemanais");
            String horasSemanais = sc.next();
            System.out.println("Digite precoHora");
            String precoHora = sc.next();
            int status = 1;

            contador++;
            Professor professor = new Professor(nome, cpf,nRegistro,titulação,horasSemanais,precoHora,status);
            professores.add(professor);
            System.out.println("(1)Cadastrar um novo professor");
            System.out.println("(2)Voltar ao menu de cadastro");
            escolha = sc.nextInt();
            if(escolha==1) {

            }else {
                loop = 1;
                Menu_Cadastro();
            }
            
        }while(loop == 0);
	}
	
	public static void Cadastro_Diciplina() {
		int loop = 0;
		int escolhaProf;
		Professor professorD = null;
		do {
	                System.out.printf("----Cadastro  de  Disciplina----\n");
	                System.out.println("Digite o nome da materia:");
	                String nomeDic = sc.next();
	                System.out.println("Digite a carga horaria da materia:");
	                int cargaHorariaDic = sc.nextInt();
	                System.out.println("Selhecionar professor:");
	                System.out.println("(1)Cadastrar novo Professor; \n(2)Listar professor;");
	                escolhaProf = sc.nextInt();
	                switch(escolhaProf) {
	                case 1:
	                	professorD = Cadastro_Professor_Disciplina();
	                	break;
	                case 2:
	                	
	                	for(int i = 0; i < professores.size() ;i++){
	                        System.out.printf("\n%d Professor\n",contador);
	                        System.out.printf("Nome:");
	                        System.out.print(professores.get(i).getNome() + "\n");
	                        System.out.printf("CPF:");
	                        System.out.print(professores.get(i).getCpf() + "\n");
	                    } 
	                	System.out.println("Digite o CPF do professor escolhido: ");
	                	String escolha = sc.next();
	                	professorD = professores.get(professores.indexOf(escolha));
	                	/*em teoria ta certo*/
	                	break;
	                default:
	                	System.out.println("Opção invalida!!");
	                }
	                
	                Disciplina disciplina = new Disciplina(nomeDic,cargaHorariaDic,professorD);
	                disciplinas.add(disciplina);
	                
	                System.out.println("(1)Cadastrar outra Disciplina\n(2)Voltar ao menu");
	                int voltar = sc.nextInt();
	                if(voltar == 2) {
	                		loop = 1;
	                		Menu_Principal();
	                }
		}while(loop == 0);
	}
	
	public static void Lista_Professores() {
        contador =1;
        System.out.println("----Professores Cadastrados----"); 
        if(professores.size() < 1) {
        	System.out.println("Nenhum Professor Cadastrado :c");
        	System.out.println("(1)Cadastrar um novo professor");
            System.out.println("(2)Voltar ao menu de cadastro");
            int escolhaList = sc.nextInt();
            if(escolhaList==1) {
            	
            }else {
            	Menu_Cadastro();
            }
        	
        }else{
        	for(int i = 0; i < professores.size() ;i++){
                System.out.printf("\n%d Professor\n",contador);
                System.out.printf("Nome:");
                System.out.print(professores.get(i).getNome() + "\n");
                System.out.printf("CPF:");
                System.out.print(professores.get(i).getCpf() + "\n");
                System.out.printf("Data:");
                System.out.print(professores.get(i).getDtNascimento() + "\n");
            } 
        }
	}

	public static void Lista_Disciplina() {
		
		System.out.println("----Disciplinas Cadastradas----"); 
        if(professores.size() < 1) {
        	System.out.println("Nenhuma diciplina Cadastrada ");
        	System.out.println("(1)Cadastrar uma nova Disciplina");
            System.out.println("(2)Voltar ao menu de cadastro");
            int escolhaList = sc.nextInt();
            if(escolhaList==1) {
            	
            }else {
            	Menu_Cadastro();
            }
        	
        }else{
        	for(int i = 0; i < disciplinas.size() ;i++){
                System.out.printf("\nDisciplinas\n");
                System.out.printf("Nome:");
                System.out.print(disciplinas.get(i).getNome() + "\n");
                System.out.printf("Carga Horaria:");
                System.out.print(disciplinas.get(i).getCargaHoraria() + "\n");
                System.out.printf("Professor:");
                System.out.println(disciplinas.get(i).getProfessor());/*FUNCIONAAAAAAAAAAAAAAAAAAAA GARAIO*/
            } 
        }
	}
public static Professor Cadastro_Professor_Disciplina() {

   
        System.out.printf("----Cadastro  %d Professor----\n",contador);
        System.out.println("Digite o Nome:");
        String nome = sc.next();
        System.out.println("Digite o cpf:");
        String cpf = sc.next(); 
        System.out.println("Digite data de nascimento:");
        String dataString = sc.next(); 
        String [] dataSeparada = dataString.split("/");
        LocalDate  dtNascimento = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
        System.out.println(dtNascimento);
        System.out.println("Digite registro:");
        String nRegistro = sc.next(); 
        System.out.println("Digite titulação");
        String titulação = sc.next(); 
        System.out.println("Digite horasSemanais");
        String horasSemanais = sc.next();
        System.out.println("Digite precoHora");
        String precoHora = sc.next();
        int status = 1;

        Professor professor = new Professor(nome, cpf,nRegistro,titulação,horasSemanais,precoHora,status);
        professores.add(professor);

        return professor; 
	
	}
}
