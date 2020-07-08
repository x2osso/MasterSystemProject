package app;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import controllers.ProfessorController;
import models.AlunosCurso;
import models.Aula;
import models.Colegiado;
import models.Curso;
import models.Disciplina;
import models.Estudante;
import models.Professor;

public class Executavel {
	
	/* FUNCIONA CARALHO */
	
	
	private static ProfessorController professores = new ProfessorController();
	
	
	public static List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
	public static ArrayList<Colegiado> colegiados = new ArrayList<Colegiado>();
	public static ArrayList<Estudante> estudantes = new ArrayList<Estudante>();
	public static ArrayList<AlunosCurso> alunosCurso = new ArrayList<AlunosCurso>();
	public static ArrayList<Aula> aulas = new ArrayList<Aula>();
	
		
	public static Scanner sc = new Scanner(System.in);
    public static int contador =1;
	
	public static void main(String[] args) {
		Cadastro_Automatico_Professor();	
	}
	
	public static void Menu_Principal() {	
		
		int loop = 0;
		int escolha;
		do {
			System.out.println("\n\n-----Menu-Principal-----");
			System.out.println("     (1)Cadastros;");
			System.out.println("     (2)Pesquisas;");
			System.out.println("     (3)Exit;");
			System.out.println("------------------------");
			System.out.println("Digite uma Opcao:");
			escolha = sc.nextInt();
			
			switch(escolha) {
				case 1:
					loop = 1;//quebra do loop;
					Menu_Cadastro();
					break;
				case 2:
					loop = 1;//quebra do loop;
					Menu_Pesquisas();
					break;
				case 3:
					System.out.println("Sistema Finalizado !!");
					loop=1;
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
			System.out.println("(3)Listar Cursos;");
			System.out.println("(4)Listar Colegiados");
			System.out.println("(5)Listar Estudantes");
			System.out.println("(7)Listar Aulas");
			System.out.println("------------------------");
			System.out.println("(6)Voltar ao Menu Principal");
			System.out.println("(0)Encerrar Sistema");
			System.out.println("--------------------------");
			escolha = sc.nextInt();
			switch(escolha) {
			case 0:
				System.out.println("Sistema Finalizado !!!!!");
				loop = 1;
				break;
			case 1:
				loop = 1;
				professores.Listagem_Professores();
				break;
			case 2:	
				loop = 1;
				sc.nextLine();
				System.out.println("De qual curso gostaria de ver as disciplinas?");
				String nomeCurso = sc.nextLine();
				Lista_Disciplina(nomeCurso);
				break;
			case 3:
				Lista_Cursos();
				break;
			case 4:
				sc.nextLine();
				System.out.println("Favor, inserir nome do curso que deseja ver os estudantes:");
				nomeCurso = sc.nextLine();
				Lista_Colegiado(nomeCurso);
				break;
			case 5:
				sc.nextLine();
				System.out.println("Favor, inserir nome do curso que deseja ver os estudantes:");
				nomeCurso = sc.nextLine();

				Lista_Alunos_Curso(nomeCurso);
				break;
			case 6:
				Menu_Principal();
				break;
			case 7:
				Lista_Aula();
				break;
				/* TESTANDO */
			default:
				System.out.println("Entrada invalida!!!!");
			}
			/*jorge*/
			
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
					professores.Cadastro_Professor();
				break;
			case "b":
					Cadastro_Diciplina();
				loop = 1;
				break;
			case "c":
				Cadastro_Curso();
				break;
			case "e":
				Cadastro_Colegiado();
				break;
			case "f":
				Cadastrar_Estudantes();
				break;
			case "g":
				System.out.println("Cadastrando alunos...");
				Cadastra_Alunos_Curso();
				System.out.println("Alunos cadastrados");
				break;
			case "d":
				Cria_Aula();
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
	
		
	public static void Cadastro_Diciplina() {
		int loop = 0;
		int escolhaProf;
		int aux = 0;
		Professor professorD = null;
		do {
				System.out.println("\nPara Cadastro de diciplina e necessario ter professores cadastrados");
                System.out.println("\n(1)Cadastrar novo Professor; \n(2)Selecionar professor utilizando CPF");
                escolhaProf = sc.nextInt();
                switch(escolhaProf) {
                case 1:
                	professorD = Cadastro_Professor_Disciplina();
                	break;
                case 2:
                	if(professores.getLista_Professores().size() < 1) {
                    	System.out.println("!! NENHUMA PROFESSOR CADASTRADO!! ");
    	                System.out.println("\n(1)Cadastrar NOVO Professor\n(2)Voltar ao menu principal");
    	                int escolha = sc.nextInt();
    	                if(escolha == 2) {
    	                		loop = 1;
    	                		Menu_Principal();
    	               }else{
    	            	   Cadastro_Professor_Disciplina();
    	               }
                    	
                   }else{
	                	for(Professor profissional : professores.getLista_Professores()) {
	                		System.out.println("--------------------------");
	                        System.out.println("-- Professor --");
	                        System.out.println("Nome: " + profissional.getNome());
	                        System.out.println("CPF: " + profissional.getCpf());
	                	}
	                	
	                	System.out.println("Digite o CPF do professor escolhido: ");
	                	String escolha = sc.next();
	                	
	                	for(int i = 0; i < professores.getLista_Professores().size() ;i++) {
	                		
	                		  System.out.print(professores.getLista_Professores().get(i).getCpf() + "\n");
		            			
	                		  if(escolha.equals(professores.getLista_Professores().get(i).getCpf())) {
				                	professorD = professores.getLista_Professores().get(i);
		        	                System.out.printf("\n----Cadastro  de  Disciplina----\n");
		        	                System.out.println("Digite o nome da materia:");
		        	                String nomeDic = sc.next();
		        	                System.out.println("Digite a carga horaria da materia:");
		        	                int cargaHorariaDic = sc.nextInt();
		        	                Disciplina disciplina = new Disciplina(nomeDic,cargaHorariaDic,professorD);
		        	                disciplinas.add(disciplina);
		        	                
		        	        		System.out.println("\n--------------------------");
		        	        		System.out.println("\n!!! DISCIPLINA CADASTRADA COM SUCESSO !!!");
		        	        		aux=1;
		            			}
		            		}
		                	
		                	if(aux==0) {
		                		System.out.println("!!! PROFESSOR NAO ENCONTRADO !!!");
		                		System.out.println("Cadastrar professor(1)\nVoltar ao menu pricipal(2)");
		                		int esc = sc.nextInt();
		                		if(esc == 1) {
		                			    professorD = Cadastro_Professor_Disciplina();
		                			    System.out.printf("\n----Cadastro  de  Disciplina----\n");
			        	                System.out.println("Digite o nome da materia:");
			        	                String nomeDic = sc.next();
			        	                System.out.println("Digite a carga horaria da materia:");
			        	                int cargaHorariaDic = sc.nextInt();
			        	                Disciplina disciplina = new Disciplina(nomeDic,cargaHorariaDic,professorD);
			        	                disciplinas.add(disciplina);
			        	                
			        	        		System.out.println("\n--------------------------");
			        	        		System.out.println("\n!!! DISCIPLINA CADASTRADA COM SUCESSO !!!");
		                		}else {
		                			Menu_Principal();
		                		}
		                	}
	            		}
	                	break;
                	
                	
                default:
                	System.out.println("Opção invalida!!");
                }
        		
                System.out.println("\n(1)Cadastrar NOVA Disciplina\n(2)Voltar ao menu principal");
                int voltar = sc.nextInt();
                if(voltar == 2) {
                		loop = 1;
                		Menu_Principal();
                }
		}while(loop == 0);
	}
	
	

	public static void Lista_Disciplina(String nomeCurso) {
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
        	for(Curso curso : cursos) {
        		if(curso.getNomeCurso().equals(nomeCurso)) {
        			ArrayList<Disciplina> materias = curso.recuperarDisciplinas();
        			
        			Collections.sort(materias, new Comparator<Disciplina>() {
        				@Override
        				public int compare(Disciplina materia1, Disciplina materia2) {
        					return materia1.getNome().compareTo(materia2.getNome());
        				}
        			});
        			
        			System.out.println("Curso: " + nomeCurso);
        			System.out.println("Disciplinas: ");
        			System.out.println();
        			
        			for(Disciplina materia : materias) {
        				System.out.println("Nome: " + materia.getNome());
        				System.out.println("Carga horária: " + materia.getCargaHoraria());
        				System.out.println("Professor: " + materia.getProfessor().getNome() + ", com o título: " + materia.getProfessor().getTitulação ());
        				
        			}
        		}
        	}
        	
        	
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
        
        System.out.println("Digite registro:");
        String nRegistro = sc.next(); 
        
        System.out.println("Digite titulação");
        String titulação = sc.next(); 
        
        System.out.println("Digite horasSemanais");
        float horasSemanais = sc.nextFloat();
        
        System.out.println("Digite precoHora");
        double precoHora = sc.nextDouble();

        Professor professor = new Professor(nome, cpf,nRegistro,titulação,horasSemanais,precoHora, dtNascimento);
        professores.add_Professor(professor);

        return professor; 
	}

	public static void Cadastro_Curso() {
		boolean menu = true;
		
		System.out.println("------Cadastro de Curso------");
		sc.nextLine();
		System.out.println("Digite o nome do curso:");
		String nomeCurso = sc.nextLine();
		
		Curso curso = new Curso(nomeCurso);
		cursos.add(curso);
		
		System.out.println("Quais disciplinas gostaria de adicionar ao curso?");
		System.out.println("Segue as existentes: ");
		Lista_Disciplina(nomeCurso);
		
		do {
			System.out.println("Digite o nome da disciplina desejada:");
			String nomeDisciplina = sc.nextLine();
			
			Disciplina disciplina = encontraDisciplina(nomeDisciplina);
			
			
			curso.inserirDisciplina(disciplina);
			System.out.println("!! CURSO CADASTRADO COM SUCESSO !!");
			System.out.println("1 - Adicionar NOVO curso");
			System.out.println("2 - Voltar ao menu principal");
			int escolha = sc.nextInt();
			
			switch(escolha) {
			case 1:
				Cadastro_Curso();
				break;
			case 2:
				Menu_Principal();
				break;
			default: 
				System.out.println("Opção inválida. Retornando ao menu Principal");
				Menu_Principal();
				break;
			}
			
		} while (menu); 
	}
	
	public static void Lista_Cursos() {
		
		if(cursos.size() < 1) {
			System.out.println("NENHUM CURSO CADASTRADO!!!");
			System.out.println("1 - Cadastrar novo Curso");
			System.out.println("2 - Retornar ao menu de cadastro");
			
			int escolha = sc.nextInt();
			
			switch(escolha) {
			case 1:
				Cadastro_Curso();
				break;
			case 2:
				Menu_Cadastro();
				break;
			default: 
				System.out.println("Opção inválida, retornando ao menu de cadastro...");
				Menu_Cadastro();
				break;
			}
		}
		System.out.println("----Cursos Cadastrados----"); 
		for(Curso curso : cursos) {
			System.out.println("\nNome do Curso :" + curso.getNomeCurso());
			System.out.println("\n--------------------------"); 
		}
	}
	
	public static Disciplina encontraDisciplina(String nome) {
		Disciplina materia = null;
		int aux = 0;
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getNome().equals(nome)) {
				materia = disciplina;
				aux = 1;
			}
			
		}
		if(aux == 0){
			System.out.println("Disciplina nao cadastrada\nDeseja cadastrar uma disciplina ?(1)\n"
					+ "Voltar ao menu pricipal(2)");
			int esc = sc.nextInt();
			if(esc == 1) {
				Cadastro_Diciplina();
			}else {
				Menu_Principal();
			}
		}
		return materia;
	}
	
	public static Curso Encontra_Curso(String nome) {
		Curso curso = null;
		
		for(Curso curso_aux : cursos) {
			if(curso_aux.getNomeCurso().equals(nome)) {
				curso = curso_aux;
			}
		}
		return curso;
	}
	
	public static Professor Encontra_Professor(String CPF) {
		Professor professor = null;
		
		for(Professor professor_aux : professores.getLista_Professores()) {
			if (CPF.equals(professor_aux.getCpf())) {
    			professor = professor_aux;
    		}
		}
		
		return professor;
	}

	public static void Cadastro_Colegiado() {
		Professor professor;
		
		System.out.println("------Cadastro de Colegiado-------");
		System.out.println("\nPara Cadastro de colegiado e necessario ter cursos cadastrados");
        System.out.println("\n(1)Cadastrar novo curso; \n(2)Selecionar curso");
        int escolhaCur = sc.nextInt();
        switch(escolhaCur) {
        case 1:
        	Cadastro_Curso();
        	break;
        case 2:
        	if(cursos.size() < 1) {
        		System.out.println("Nenhum curso cadastrado !!!");
        		System.out.println("(1)Deseja cadastrar curso\n(2)Voltar ao menu principal");
        		int esc = sc.nextInt();
        		if(esc == 1) {
        			Cadastro_Curso();
        		}else {
        			Menu_Principal();
        		}
        	}else {
        		int contador = 1;
        		System.out.println("\n-------------Cursos cadastrados-------------"); 
        		for(int i = 0; i < cursos.size() ;i++) {
        			System.out.println("Curso: "+contador);
                    System.out.print("Nome:"+cursos.get(i).getNomeCurso() + "\n");
        			System.out.println("\n--------------------------"); 
        			contador++;
        		}
        		System.out.println("Nome do curso que esse colegiado pertence?");
        		String nomeCurso = sc.next();
        		
        		contador =1;
        		System.out.println("\n-------------Professores cadastrados-------------"); 
        		
            	for(int i = 0; i < professores.getLista_Professores().size() ;i++){
                    System.out.printf("\n %d. Professor\n",contador);
                    System.out.printf("Nome:");
                    System.out.print(professores.getLista_Professores().get(i).getNome() + "\n");
                    System.out.printf("CPF:");
                    System.out.print(professores.getLista_Professores().get(i).getCpf() + "\n");
                    contador++;
                } 
                System.out.println("Digite o CPF do professor escolhido: ");
                String CPF = sc.next();
                
        		Colegiado colegiado = new Colegiado(Encontra_Curso(nomeCurso));	
        		colegiados.add(colegiado);
                professor = Encontra_Professor(CPF);
                colegiado.inserirProfessor(professor);
                
        		System.out.println("\n--------------------------");
        		System.out.println("\n!!! COLEGIADO CADASTRADO COM SUCESSO !!!");
                System.out.println("\n(1)Cadastrar NOVO colegiado\n(2)Voltar ao menu principal");
                int voltar = sc.nextInt();
                if(voltar == 1) {     		
                		Cadastro_Colegiado();
                }else {
                	Menu_Principal();
                }
        	}
        	break;
        default:
        	System.out.println("Entrada invalida !!!!!!");
    }

}

	public static void Lista_Colegiado(String nomeCurso) {
		if(colegiados.size() < 1) {
			System.out.println("!! NENHUM COLEGIADO CADASTRADO !!");
		}else {
			
			Collections.sort(professores.getLista_Professores(), new Comparator<Professor>() {
				@Override
				public int compare(Professor professor1, Professor professor2) {
					return professor1.getNome().compareTo(professor2.getNome());
				}
			});
			
			for(Colegiado colegiado : colegiados) {
				if(colegiado.getCurso().getNomeCurso().equals(nomeCurso)) {
					System.out.println("Curso: " + colegiado.getCurso().getNomeCurso());
					System.out.println("Professores do curso:");
					System.out.println();
					
					for(Professor profissional : professores.getLista_Professores()) {
						System.out.println("Nome: " + profissional.getNome());
						System.out.println("Titulação:" + profissional.getTitulação());
						System.out.println("Horas semanais: " + profissional.getHorasSemanais());
						System.out.println();
						System.out.println("------------------------------");
						System.out.println();
					}
				}
			}
		}
	}

	public static void Cadastrar_Estudantes() {
		boolean menu = true;
		
		System.out.println("----Cadastro de Estudante----");
		
		sc.nextLine();
		
		do {
			System.out.println("Digite o Nome:");
	        String nome = sc.next();
	        
	        System.out.println("Digite o numero de cpf:");
	        String cpf = sc.next(); 
	        
	        System.out.println("Digite data de nascimento utilizando ' / ' Exemplo:18/08/1998:");
	        String dataString = sc.next(); 
	        String [] dataSeparada = dataString.split("/");
	        LocalDate  dtNascimento = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
	        System.out.println(dtNascimento);
	        
	        System.out.println("Digite o RA:");
	        String RA = sc.next(); 
	        
	        System.out.println("Qual o período?:");
	        int periodo = sc.nextInt(); 
	        sc.nextLine();
	        
	        System.out.println("Segue os cursos já existentes:");
	        Lista_Cursos();
	        
	        System.out.println("Digite o nome do curso no qual o(a) estudante fará:");
	        String nomeCurso = sc.nextLine();
	        
	        
	       Estudante aluno = new Estudante(nome, cpf, dtNascimento, RA, periodo, Encontra_Curso(nomeCurso));
	       
	       estudantes.add(aluno);
	       
	       System.out.println("1 - Adicionar novo Estudante");
			System.out.println("2 - Finalizar cadastro de Estudantes");
			int escolha = sc.nextInt();
			
			switch(escolha) {
			case 1:
				menu = true;
				break;
			case 2:
				menu = false;
				Menu_Cadastro();
				break;
			default: 
				System.out.println("Opção inválida. Retornando ao menu de cadastro");
				Menu_Cadastro();
				break;
			}

		} while (menu);
	}
	
	private static void Cadastra_Alunos_Curso() {
		AlunosCurso alunos_curso = null; 
		
		for(Curso curso : cursos) {
			alunos_curso = new AlunosCurso(curso);
			
			for(Estudante aluno : estudantes) {
				if(aluno.getCurso().equals(curso)) {
					alunos_curso.inserirEstudante(aluno);
				}
			}
		}
		
		alunosCurso.add(alunos_curso);
	}
	
	public static void Lista_Alunos_Curso(String nomeCurso) {
		Map<String, Estudante> estudantes_ordenados = new TreeMap<>();
		
		for(AlunosCurso alunos_curso : alunosCurso) {
			if(alunos_curso.getCurso().getNomeCurso().equals(nomeCurso)) {
				estudantes_ordenados.putAll(alunos_curso.recuperarListaAlunos());
			}
		}
		
		for(Estudante estudante : estudantes_ordenados.values()) {
			System.out.println("Nome: " + estudante.getNome());
			System.out.println("RA: " + estudante.getRA());
		}
	}
	
	public static void Cria_Aula() {
		boolean menu = true;
		
		System.out.println("------------Criação de Aula----------------");
		
		sc.nextLine();
		
		System.out.println("De qual curso será essa aula?");
		String nomeCurso = sc.nextLine();
		
		Curso curso = Encontra_Curso(nomeCurso);
		ArrayList<Disciplina> materias = curso.recuperarDisciplinas();
		
		System.out.println("Qual laboratório irá ocorrer a aula?");
		String lab = sc.nextLine();
		
		System.out.println("Digite data da aula utilizando ' / ' Exemplo:18/08/1998:");
        String dataString = sc.next(); 
        String [] dataSeparada = dataString.split("/");
        LocalDate  dtAula = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
        
        System.out.println("Disciplinas existentes:");
        Lista_Disciplina(nomeCurso);
        
        String nomeDisciplina = ""; 
        do {
        	sc.nextLine();
            System.out.println("De qual disciplina será essa aula?");
            nomeDisciplina = sc.nextLine();
            
            for(Disciplina disciplina : materias) {
            	if(disciplina.getNome().equals(nomeDisciplina)) {
            		menu = false;
            		break;
            	} else {
            		System.out.println("Disciplina não condizente com as cadastradas no curso. Favor, insira uma condizente.");
            		break;
            	}
            }
        } while(menu);
        
        Disciplina disciplina = encontraDisciplina(nomeDisciplina);
        
        Aula aula = new Aula(lab, dtAula, disciplina);
        
        menu = true;
        
        do {
        	boolean controle = true;
        	String newRA = "";
        	
        	System.out.println("Seguem os alunos cadastrados no curso");
        	Lista_Alunos_Curso(nomeCurso);
        	
        	do {
        		System.out.println("Insira o RA do aluno para colocá-lo na aula");
        		newRA = sc.nextLine();
        		
        		for(int i = 0; i < alunosCurso.size(); i++) {     			
        			if(alunosCurso.get(i).getCurso().equals(nomeCurso)) {
        				HashMap<String,Estudante> alunos_curso = alunosCurso.get(i).recuperarListaAlunos();
        				for(Estudante estudante : alunos_curso.values()) {
        					if(estudante.getRA().equals(newRA)) {
        						controle = false;
        						break;
        					}
        				}
        			}
        		}
        		System.out.println("Aluno não faz esse curso, favor insira outro");
        	} while(controle);
        	
        	aula.addAluno(Encontra_Estudante(newRA));
        	
        	System.out.println("1 - Adicionar novo aluno");
        	System.out.println("2 - Finalizar criação");
        	int escolha = sc.nextInt();
        	
        	switch(escolha) {
        	case 1:
        		sc.nextLine();
        		menu = true;
        		break;
        	case 2:
                aulas.add(aula);
        		Menu_Cadastro();
        		menu = false;
        		break;
        	}
        } while(menu);
	}
	
	private static Estudante Encontra_Estudante(String RA) {
		Estudante estudante = null;
		
		for(Estudante estudante_aux : estudantes) {
			if (RA.equals(estudante_aux.getRA())) {
    			estudante = estudante_aux;
    		}
		}
		return estudante;
	}
		
	private static void Lista_Aula() {
		for(Aula aula : aulas) {
			
			Map<String, Estudante> estudantes_ordenados = new TreeMap<>();
			estudantes_ordenados.putAll(aula.getListaDeAlunos());
			
			System.out.println("Data: " + aula.getDataHora() + ", no laboratório: " + aula.getLab());
			System.out.println("Disciplina: " + aula.getDisciplina().getNome() + ", regida por: " + aula.getDisciplina().getProfessor());
			System.out.println("Lista de alunos:");
			
			System.out.println("Aluno: " + aula.getAluno("11").getNome());
			
			 Iterator iterator = estudantes_ordenados.entrySet().iterator();  
		       
		     while (iterator.hasNext()) {  
		         Map.Entry entry = (Map.Entry) iterator.next();  
		         
		         System.out.println("RA:" + entry.getKey() + ", Nome: " + entry.getValue().toString());
		     }
		     System.out.println();
		}
	}

	/*Dados para teste*/
	
	public static void Cadastro_Automatico_Professor() {

        String nome = "flavio";
     
        String cpf = "546"; 
        
        String dataString = "18/08/1998"; 
        String [] dataSeparada = dataString.split("/");
        LocalDate  dtNascimento = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),Integer.parseInt(dataSeparada[0]));
        
        String nRegistro = "110"; 
        
        String titulação = "teste";
        
        float horasSemanais = 5;
        
        double precoHora = 5;

        contador++;
        Professor professor = new Professor(nome, cpf,nRegistro,titulação,horasSemanais,precoHora, dtNascimento);
        professores.add_Professor(professor);

        Cadastro_Automatico_Disciplina();
      
	}
	
	public static void Cadastro_Automatico_Disciplina() {
		Professor professorD = null;
		String escolha = "546";
	                	
		for(int i = 0; i < 1;i++) {
			if(escolha.equals(professores.getLista_Professores().get(i).getCpf())) {
				professorD = professores.getLista_Professores().get(i);
				String nomeDic ="matematica";
				int cargaHorariaDic = 3;
	        	Disciplina disciplina = new Disciplina(nomeDic,cargaHorariaDic,professorD);
	        	disciplinas.add(disciplina);	                
	       }
	
		}
		Menu_Principal();
	}
}