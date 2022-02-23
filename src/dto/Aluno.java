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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author José Augusto Klaumann
 * @version 1.0
 */
@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long    codAluno;
	private String  nomeAluno;
	private String  nomeMae;
	private String  nomePai;
	private Date    dataNasc;
	private Double  medAluno;
	private String  sitAluno;
	
	@OneToMany(mappedBy = "aluno")
	private List<Matricula> matricula = new ArrayList<>();	
	
	@ManyToMany
	@JoinTable(name = "matricula",
			joinColumns = @JoinColumn(name = "aluno_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "disciplina_id", nullable = false))
	private List<Disciplina> disciplina = new ArrayList<>();
	
	public Long getCodAluno() {
		return codAluno;
	}
	
	public void setCodAluno(Long codAluno) {
		this.codAluno = codAluno;
	}
	
	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}


	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Double getMedAluno() {
		return medAluno;
	}

	public void setMedAluno(Double medAluno) {
		this.medAluno = medAluno;
	}

	public String getSitAluno() {
		return sitAluno;
	}

	public void setSitAluno(String sitAluno) {
		this.sitAluno = sitAluno;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAluno == null) ? 0 : codAluno.hashCode());
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
		Aluno other = (Aluno) obj;
		if (codAluno == null) {
			if (other.codAluno != null)
				return false;
		} else if (!codAluno.equals(other.codAluno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [codAluno=" + codAluno + ", nomeAluno=" + nomeAluno + ", nomeMae=" + nomeMae + ", nomePai="
				+ nomePai + ", dataNasc=" + dataNasc + ", medAluno=" + medAluno + ", sitAluno=" + sitAluno + "]";
	}
}
