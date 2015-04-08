package br.edu.ifce.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import br.edu.ifce.util.entity.IGenericEntity;

/**
 * 
 * 
 * 
 * @author edivandoalves
 *
 */
@Entity
@Table(name = "empresa")
public class Empresa implements IGenericEntity<Empresa>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Integer idEmpresa;
	
	@Getter @Setter
	private Integer idUsuario;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String telefone;
	
	@OneToOne
	@Getter @Setter
	private Endereco endereco;
	
	@Getter @Setter
	private String supervisor;
	
	@Getter @Setter
	private String cargoSupervisor;
	
	@Getter @Setter
	private String telefoneSupervisor;
	
	@Getter @Setter
	private String cnpj;
	
	@Getter @Setter
	private String site;
	
	@Getter @Setter
	private String ramoAtividade;
	
	@OneToMany
	@Getter @Setter
	private List<VagaEstagio> vagaEstagios;
	
	public Empresa(){
		endereco = new Endereco();
	}
}
