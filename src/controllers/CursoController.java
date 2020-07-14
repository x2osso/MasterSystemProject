package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.Curso;
import models.Disciplina;

public class CursoController {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
		
	public CursoController() {}
	
	public void Cadastro_Curso() {
		DisciplinaController disciplinas = new DisciplinaController();
		boolean menu = true;
		
		System.out.println("------Cadastro de Curso------");
		System.out.println("Digite o nome do curso:");
		String nomeCurso = sc.nextLine();
		
		Curso curso = new Curso(nomeCurso);
		cursos.add(curso);
		
		System.out.println("Quais disciplinas gostaria de adicionar ao curso?");
		System.out.println("Segue as existentes: ");
		disciplinas.Lista_Disciplina(nomeCurso);
		
		do {
			System.out.println("Digite o nome da disciplina desejada:");
			String nomeDisciplina = sc.nextLine();
			
			Disciplina disciplina = disciplinas.getDisciplina(nomeDisciplina);
			
			curso.inserirDisciplina(disciplina);
			System.out.println("!! CURSO CADASTRADO COM SUCESSO !!");
			System.out.println("1 - Adicionar NOVO curso");
			System.out.println("2 - Voltar ao menu principal");
			int escolha = sc.nextInt();
			
			if(escolha == 2) {
				menu = false;
			}
		} while (menu); 
	}
	
	public Curso getCurso(String nome) {
		for(Curso curso_aux : cursos) {
			if(curso_aux.getNomeCurso().equals(nome)) {
				return curso_aux;
			}
		}
		return null;
	}
	
	public ArrayList<Curso> getListaCursos() {
		return this.cursos;
	}
	
	
	// REMOVER DEPOIS
	public void Lista_Cursos() {
		if(cursos.size() < 1) {
			System.out.println("NENHUM CURSO CADASTRADO!!!");
		}

		System.out.println("----Cursos Cadastrados----"); 
		for(Curso curso : cursos) {
			System.out.println("\nNome do Curso :" + curso.getNomeCurso());
			System.out.println("\n--------------------------"); 
		}
	}
}
