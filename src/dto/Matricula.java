package dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* @author José Augusto Klaumann
* @version 1.0
*/
@Entity
@Table(name = "tb_matricula")
public class Matricula implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long    nrMatricula;
    private Integer codAluno;
    private Integer codDisciplina;
    private Date    dtMatricula;
    private String  statusMatricula;
        
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToMany
    @JoinTable(name = "matricula", 
    joinColumns = @JoinColumn(name = "matricula_id"), 
    inverseJoinColumns = @JoinColumn(name = "disciplina_id", nullable = false))
    private List <Disciplina> disciplina = new ArrayList<>();
    
	public Long getNrMatricula() {
		return nrMatricula;
	}

	public void setNrMatricula(Long nrMatricula) {
		this.nrMatricula = nrMatricula;
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

	public Date getDtMatricula() {
		return dtMatricula;
	}

	public void setDtMatricula(Date dtMatricula) {
		this.dtMatricula = dtMatricula;
	}
	
	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAluno == null) ? 0 : codAluno.hashCode());
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
		Matricula other = (Matricula) obj;
		if (codAluno == null) {
			if (other.codAluno != null)
				return false;
		} else if (!codAluno.equals(other.codAluno))
			return false;
		if (codDisciplina == null) {
			if (other.codDisciplina != null)
				return false;
		} else if (!codDisciplina.equals(other.codDisciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [codAluno=" + codAluno + ", codDisciplina=" + codDisciplina + ", dtMatricula=" + dtMatricula
				+ ", statusMatricula=" + statusMatricula + "]";
	}
}
