package application;

import java.sql.Date;
import java.util.List;

import dao.AlunoDao;
import dao.AvaliacaoDao;
import dao.DisciplinaDao;
import dao.MatriculaDao;
import dto.Aluno;
import dto.Avaliacao;
import dto.Disciplina;
import dto.Matricula;

public class Program {

	public static void main(String[] args) {

		insertMatricula();
		System.out.println("Salvo!");

	}

	static void insertAluno() {
		Aluno aluno = new Aluno();

		aluno.setNomeAluno("Joao");
		aluno.setNomeMae("Maria");
		aluno.setNomePai("Moreira");
		aluno.setDataNasc(Date.valueOf("1998-08-23"));
		aluno.setMedAluno(null);
		aluno.setSitAluno("Cursando");

		new AlunoDao().insert(aluno);
	}

	static void insertDisciplina() {

		Disciplina disciplina = new Disciplina();

		disciplina.setNomeDisciplina("Java Avancado");
		disciplina.setNomeProfessor("Nelio");
		disciplina.setQntdAvaliacoes(3);
		
		new DisciplinaDao().insert(disciplina);
	}
	
	static void insertMatricula() {
		Matricula matricula = new Matricula();

		matricula.setCodAluno(5);
		matricula.setCodDisciplina(3);
		matricula.setDtMatricula(Date.valueOf("2017-09-06"));
		matricula.setStatusMatricula("Doc. Completa");
				
		new MatriculaDao().insert(matricula);
	}
	
	static void insertAvaliacao() {
		Avaliacao avaliacao = new Avaliacao();

		avaliacao.setCodAluno(1);
		avaliacao.setCodDisciplina(4);
		avaliacao.setVlrNota(7.5);
		
		new AvaliacaoDao().insert(avaliacao);
	}

	static void updateAluno() {
		Aluno aluno = new Aluno();
		
		aluno.setCodAluno(2L);
		aluno.setNomeAluno("Joao");
		aluno.setNomeMae("Joana");
		aluno.setNomePai("Pedro");
		aluno.setDataNasc(Date.valueOf("1999-11-14"));
		aluno.setMedAluno(7.0);
		aluno.setSitAluno("Cursando");
		
		new AlunoDao().update(aluno);
	}

	static void updateMatricula() {
		Matricula matricula = new Matricula();

		matricula.setNrMatricula(4L);;
		matricula.setCodAluno(1);
		matricula.setCodDisciplina(4);
		matricula.setDtMatricula(Date.valueOf("2017-09-06"));
		matricula.setStatusMatricula("Doc. Completa");
		
		new MatriculaDao().update(matricula);
	}

	static void deleteMatricula() {
			
		new MatriculaDao().delete(4L); 
	}
	
	static void deleteAluno() {
		
		new AlunoDao().delete(2L);
	}
	
	static void findByIdDisciplina() {
		Disciplina disciplina = new DisciplinaDao().findById(4L);
		System.out.println(disciplina);
	}
	
	static void findByIdAvaliacao() {
		Avaliacao avaliacao = new AvaliacaoDao().findById(2L);
		System.out.println(avaliacao);
	}

	static void findAllDisciplina() {
		
		List<Disciplina> disciplina = new DisciplinaDao().findAll();
	
		for(Disciplina disc : disciplina) {
			System.out.println(disc.toString());
		}
	
	}


}