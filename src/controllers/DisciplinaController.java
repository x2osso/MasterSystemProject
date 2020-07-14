package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import models.Curso;
import models.Disciplina;
import models.Professor;

public class DisciplinaController {
	private Scanner sc = new Scanner(System.in);
	public  List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	private ProfessorController professores = new ProfessorController();
	private ArrayList<Curso> cursos = new CursoController().getListaCursos();
	
	public DisciplinaController() {}
	
	public void Cadastro_Diciplina() {
		boolean loop = true;
		
		do {
			System.out.println("\nPara Cadastro de diciplina e necessario ter professores cadastrados");
            System.out.println("\nSelecionar professor utilizando CPF");
        
        	if(professores.getLista_Professores().size() < 1) {
            	System.out.println("!! NENHUMA PROFESSOR CADASTRADO!!");
            	loop = false;
        	}else {
            	for(Professor professor : professores.getLista_Professores()) {
            		System.out.println("--------------------------");
                    System.out.println("-- Professor --");
                    System.out.println("Nome: " + professor.getNome());
                    System.out.println("CPF: " + professor.getCpf());
            	}
            	System.out.println("Digite o CPF do professor escolhido: ");
            	String CPF = sc.next();
            	
            	for(Professor professor : professores.getLista_Professores()) {
	        		if(CPF.equals(professor.getCpf())) {
	        			Professor professorDisciplina = professor.getProfessor();
	        			System.out.printf("\n----Cadastro  de  Disciplina----\n");
		                System.out.println("Digite o nome da disciplina:");
		                String nomeDisciplina = sc.next();
		                System.out.println("Digite a carga horaria da materia:");
		                int cargaHoraria = sc.nextInt();
		                Disciplina disciplina = new Disciplina(nomeDisciplina,cargaHoraria,professorDisciplina);
		                disciplinas.add(disciplina);
		                
		        		System.out.println("\n--------------------------");
		        		System.out.println("\n!!! DISCIPLINA CADASTRADA COM SUCESSO !!!");
	        		}
	        		System.out.println("CPF não bate com nenhum professor cadastrado...");
	        		return;
            	}
        	  System.out.println("\n1 -Cadastrar NOVA Disciplina");
              System.out.println("2 - Finalizar cadastro");
              int escolha = sc.nextInt();
              if(escolha == 2) {
              	loop = false;
              }
        	}
		}while(loop);
	}
	
	public Disciplina getDisciplina(String nome) {		
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getNome().equals(nome)) {
				return disciplina;
			}
		}
		return  null;
	}

	public List<Disciplina> getListaDisciplinas() {
		return this.disciplinas;
	}
	
	// RETIRAR DEPOIS
	public void Lista_Disciplina(String nomeCurso) {
        if(disciplinas.size() < 1) {
        	System.out.println("!! NENHUMA DICIPLINA CADASTRADA !! ");
        	return;
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

	public void addDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
}
