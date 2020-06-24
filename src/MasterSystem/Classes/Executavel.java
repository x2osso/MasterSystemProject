package MasterSystem.Classes;
import java.time.LocalDate;
import java.util.ArrayList;
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
			System.out.println("     (1)Cadastros;");
			System.out.println("     (2)Pesquisas;");
			System.out.println("     (3)Exit;");
			System.out.println("------------------------");
			System.out.println("Digite uma Opcao:");
			escolha = sc.next();
			
			switch(escolha) {
				case "1":
					loop = 1;//quebra do loop;
					Menu_Cadastro();
					break;
				case "2":
					loop = 1;//quebra do loop;
					Menu_Pesquisas();
					break;
				case "3":
					
					break;
				default:
					System.out.println("Entrada invalida !!");
					loop = 0;
			}
		}while(loop == 0);
		
	}
	
	public static void Menu_Pesquisas() {
		int loop = 0;
		int escolha=0;
		do {
			
			System.out.println("----MENU DE PESQUISA----");
			System.out.println("(1)Listar professor;");
			System.out.println("(2)Listar Disciplina;");
			System.out.println("------------------------");
			escolha = sc.nextInt();
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
		System.out.println("(1)Voltar ao Menu Principal");
		System.out.println("(2)Encerrar Sistema");
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
			case "1":
				loop = 1;//quebra do loop;
				Menu_Principal();
				break;
			case "2":
				System.out.println("Sistema Finalizado !!");
				loop=1;
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
            System.out.printf("\n\n----Cadastro  %d Professor----\n",contador);
            System.out.println("Digite o Nome:");
            String nome = sc.next();
            
            System.out.println("Digite o numero de cpf:");
            String cpf = sc.next(); 
            
            System.out.println("Digite data de nascimento utilizando ' / ' Exemplo:18/08/1998:");
            String dataString = sc.next(); 
            String [] dataSeparada = dataString.split("/");
            LocalDate  dtNascimento = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
            System.out.println(dtNascimento);
            
            System.out.println("Digite o numero de registro:");
            String nRegistro = sc.next(); 
            
            System.out.println("Digite titulação:");
            String titulação = sc.next(); 
            
            System.out.println("Digite Horas Semanais:");
            float horasSemanais = sc.nextFloat();
            
            System.out.println("Digite Preço por Hora, exemplo: 4,50 :");
            double precoHora = sc.nextDouble();

            contador++;
            Professor professor = new Professor(nome, cpf,nRegistro,titulação,horasSemanais,precoHora, dtNascimento);
            professores.add(professor);
    		System.out.println("\n--------------------------");
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
	
	@SuppressWarnings("unlikely-arg-type")
	public static void Cadastro_Diciplina() {
		int loop = 0;
		int escolhaProf;
		Professor professorD = null;
		do {
	                System.out.printf("\n----Cadastro  de  Disciplina----\n");
	                System.out.println("Digite o nome da materia:");
	                String nomeDic = sc.next();
	                System.out.println("Digite a carga horaria da materia:");
	                int cargaHorariaDic = sc.nextInt();
	                System.out.println("Selhecionar professor:");
	                System.out.println("(1)Cadastrar novo Professor; \n(2)Selecionar professor utilizando CPF;");
	                escolhaProf = sc.nextInt();
	                switch(escolhaProf) {
	                case 1:
	                	professorD = Cadastro_Professor_Disciplina();
	                	break;
	                case 2:
	                	if(professores.size() < 1) {
	                    	System.out.println("!! NENHUMA PROFESSOR CADASTRADO!! ");
	    	                System.out.println("\n(1)Cadastrar NOVO Professor\n(2)Voltar ao menu principal");
	    	                int escolha = sc.nextInt();
	    	                if(escolha == 2) {
	    	                		loop = 1;
	    	                		Menu_Principal();
	    	                }else {
	    	                	Cadastro_Professor();
	    	                }
	                    	
	                	}else {
	                		contador=1;
		                	for(int i = 0; i < professores.size() ;i++){
		                        System.out.printf("\n -- %d Professor --\n",contador);
		                        System.out.printf("Nome:");
		                        System.out.print(professores.get(i).getNome() + "\n");
		                        System.out.printf("CPF:");
		                        System.out.print(professores.get(i).getCpf() + "\n");
		    	        		System.out.println("\n--------------------------");
		                    } 
		                	System.out.println("Digite o CPF do professor escolhido: ");
		                	String escolha = sc.next();
		                	professorD = professores.get(professores.indexOf(escolha));
		                	contador++;
		                	break;
	                	}
	                	
	                default:
	                	System.out.println("Opção invalida!!");
	                }
	                
	                Disciplina disciplina = new Disciplina(nomeDic,cargaHorariaDic,professorD);
	                disciplinas.add(disciplina);
	                
	        		System.out.println("\n--------------------------");
	        		System.out.println("\n!!! DICIPLINA CADASTRADA COM SUCESSO !!!");
	        		
	                System.out.println("\n(1)Cadastrar NOVA Disciplina\n(2)Voltar ao menu principal");
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
            	
            }   	
        }else{
        	for(int i = 0; i < professores.size() ;i++){
        		System.out.println("--------------------------");
                System.out.printf("\n -- %d Professor --\n",contador);
                System.out.printf("Nome:");
                System.out.print(professores.get(i).getNome() + "\n");
                System.out.printf("CPF:");
                System.out.print(professores.get(i).getCpf() + "\n");
                System.out.printf("Data:");
                System.out.print(professores.get(i).getDtNascimento() + "\n");
        		System.out.println("\n--------------------------");
            }
            System.out.println("(1)Voltar ao menu principal");
            System.out.println("(2)Voltar ao menu de Pesquisas");
            int escolha = sc.nextInt();
            if(escolha==1) {
            	Menu_Principal();
            }else {
				Menu_Pesquisas();
            }
        }
	}

	public static void Lista_Disciplina() {
        if(disciplinas.size() < 1) {
        	System.out.println("!! NENHUMA DICIPLINA CADASTRADA !! ");
    		System.out.println("\n----Digite uma opção----"); 
        	System.out.println("(1)Cadastrar uma nova Disciplina");
            System.out.println("(2)Voltar ao menu principal");
            int escolhaList = sc.nextInt();
            if(escolhaList==1) {
            	Cadastro_Diciplina();
            }else {
            	Menu_Principal();
            }
        	
        }else{
        	for(int i = 0; i < disciplinas.size() ;i++){
                System.out.println("\n----Diciplinas Cadastradas----"); 
                System.out.printf("Nome:");
                System.out.print(disciplinas.get(i).getNome() + "\n");
                System.out.printf("Carga Horaria:");
                System.out.print(disciplinas.get(i).getCargaHoraria() + "\n");
                System.out.printf("Professor:");
                System.out.println(disciplinas.get(i).getProfessor());
        		System.out.println("\n--------------------------");
            } 
            System.out.println("(1)Voltar ao menu principal");
            System.out.println("(2)Voltar ao menu de Pesquisas");
            int escolha = sc.nextInt();
            if(escolha==1) {
            	Menu_Principal();
            }else {
				Menu_Pesquisas();
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
        float horasSemanais = sc.nextFloat();
        
        System.out.println("Digite precoHora");
        double precoHora = sc.nextDouble();

        Professor professor = new Professor(nome, cpf,nRegistro,titulação,horasSemanais,precoHora, dtNascimento);
        professores.add(professor);

        return professor; 
	
	}
}
