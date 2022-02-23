package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
* @author José Augusto Klaumann
* @version 1.0
*/
@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long    nrAvaliacao;
	private Integer codAluno;
	private Integer codDisciplina;
	private Double  vlrNota;
	
	@ManyToMany
    @JoinTable(name = "avaliacao", 
    joinColumns = @JoinColumn(name = "avaliacao_id"), 
    inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private List<Aluno> aluno = new ArrayList<>();
	
	@ManyToMany
	 @JoinTable(name = "avaliacao", 
	    joinColumns = @JoinColumn(name = "avaliacao_id"), 
	    inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	public Long getNrAvaliacao() {
		return nrAvaliacao;
	}
	
	public void setNrAvaliacao(Long nrAvaliacao) {
		this.nrAvaliacao = nrAvaliacao;
	}
	
	public Integer getCodAluno() {
		return codAluno;
	}
	
	public void setCodAluno(Integer codAluno) {
		this.codAluno = codAluno;
	}

	public Integer getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(Integer codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	
	public Double getVlrNota() {
		return vlrNota;
	}

	public void setVlrNota(Double vlrNota) {
		this.vlrNota = vlrNota;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@Override
	public String toString() {
		return "Avaliacao [codAluno=" + codAluno + ", codDisciplina=" + codDisciplina + ", nrAvaliacao=" + nrAvaliacao
				+ ", vlrNota=" + vlrNota + "]";
	}
}
