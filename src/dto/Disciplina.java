package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* @author José Augusto Klaumann
* @version 1.0
*/
@Entity
@Table(name = "tb_disciplina")
public class Disciplina implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long    codDisciplina;
	private String  nomeDisciplina;
	private String  nomeProfessor;
	private Integer qntdAvaliacoes;
	
	@ManyToMany(mappedBy = "disciplina")
	private List<Aluno> aluno = new ArrayList<>();
	
	@OneToMany(mappedBy = "disciplina")
	private List<Matricula> matricula = new ArrayList<>();	

	public Long getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(Long codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	
	public Integer getQntdAvaliacoes() {
		return qntdAvaliacoes;
	}

	public void setQntdAvaliacoes(Integer qntdAvaliacoes) {
		this.qntdAvaliacoes = qntdAvaliacoes;
	}
	
	public List<Aluno> getAluno() {
		return aluno;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codDisciplina == null) ? 0 : codDisciplina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (codDisciplina == null) {
			if (other.codDisciplina != null)
				return false;
		} else if (!codDisciplina.equals(other.codDisciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [codDisciplina=" + codDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", nomeProfessor="
				+ nomeProfessor + ", qntdAvaliacoes=" + qntdAvaliacoes + "]";
	}
}
