package com.j7ss.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.j7ss.entity.VagaEstagioAtividadeDiaria;
import com.j7ss.util.DAOException;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 
 * 
 * @author edivandoalves
 *
 */
@ManagedBean
@ViewScoped
public class VagaEstagioAtividadeDiariaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Setter
	private VagaEstagioAtividadeDiaria atividade;
	private List<VagaEstagioAtividadeDiaria> atividades;
	@Getter
	private boolean form = false;

	public void grid(){
		atividade  = null;
		atividades = null;
		form = false;
	}
	
	public void form(){
		form = true;
	}
	
	public List<VagaEstagioAtividadeDiaria> getAtividades() {
		return atividades == null ? atividades = VagaEstagioAtividadeDiaria.findAll() : atividades;
	}
	
	public void salvar(){
		try {
			atividade.save();
			FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Atividade Diária", "salva com sucesso!")));
		} catch (DAOException e) {
			FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro durante o processo de salvar os dados")));
		}
		grid();
	}
	
	public void excluir(){
		if(atividade != null){
			try {
				atividade.remove();
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Atividade", "Excluído com sucesso!")));
			} catch (DAOException e) {
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao excluir")));
			}
		}
		grid();
	}

	public VagaEstagioAtividadeDiaria getAtividade() {
		return atividade == null ? atividade = new VagaEstagioAtividadeDiaria() : atividade;
	}
}