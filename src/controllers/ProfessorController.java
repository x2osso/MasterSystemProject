package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Professor;

public class ProfessorController {
	private Scanner sc = new Scanner(System.in);
	private List<Professor> professores = new ArrayList<Professor>();

	public ProfessorController() {}

	public void Cadastro_Professor() {
        int loop = 0;

        do {
            System.out.printf("\n\n----Cadastro Professor----\n");
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

            Professor professor = new Professor(nome, cpf,nRegistro,titulação,horasSemanais,precoHora, dtNascimento);
            professores.add(professor);
            System.out.println("Professor cadastrado com sucesso!");
    		System.out.println("\n--------------------------");
    		
    		System.out.println("1 - Cadastrar novo professor");
    		System.out.println("2 - Finalizar cadastro de professores");
    		int escolha = sc.nextInt();
    		
    		if(escolha == 2) {
    			loop = 1;
    		}
        }while(loop == 0);
	}

	
	public List<Professor> getLista_Professores() {
		return this.professores;
	}
	
	public Professor getProfessor(String CPF) {
		for(Professor professor_aux : professores) {
			if (CPF.equals(professor_aux.getCpf())) {
    			return professor_aux;
    		}
		}
		return null;
	}
	
	// TIRAR DEPOIS 
	
	public void Listagem_Professores() {
        System.out.println("----Professores Cadastrados----"); 
        if(professores.size() < 1) {
        	System.out.println("Nenhum professor cadastrado!");  	
        }else{      	
        	for(Professor professor : professores) {
        		System.out.println("--------------------------");
                System.out.println("Nome: " + professor.getNome());
                System.out.println("CPF: " + professor.getCpf());
                System.out.println("Data: " + professor.getDtNascimento());
        		System.out.println("\n--------------------------");
        	}
        }
	}
	
	public void add_Professor(Professor professor) {
		professores.add(professor);
	}
	
}
