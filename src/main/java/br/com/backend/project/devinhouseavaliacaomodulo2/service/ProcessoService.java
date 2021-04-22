package br.com.backend.project.devinhouseavaliacaomodulo2.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.project.devinhouseavaliacaomodulo2.dto.ProcessoDTO;
import br.com.backend.project.devinhouseavaliacaomodulo2.repository.ProcessoRepository;

@Service
public class ProcessoService {
	
	@Autowired
	private ProcessoRepository repositoryDeProcessos;
	
	public List<ProcessoDTO> retornarTodosOsProcessos() {
		List <ProcessoDTO> todosOsProcessos = repositoryDeProcessos.criarRepository();
		return todosOsProcessos;
	}
	
	public ProcessoDTO retornarProcessoPorId(Integer id) {
		List<ProcessoDTO> todosOsProcessos = retornarTodosOsProcessos();
		ProcessoDTO processoPorId = null;
		for(ProcessoDTO processo : todosOsProcessos) {
			if(id.equals(processo.getId())) {
				processoPorId = processo;
			}
		}
		return processoPorId;
	}
	
	public ProcessoDTO retornarProcessoPorChaveDeProcesso(String chave) {
		List<ProcessoDTO> todosOsProcessos = repositoryDeProcessos.criarRepository();
		ProcessoDTO processoPorChaveDeProcesso = null;
		for(ProcessoDTO processo : todosOsProcessos) {
			if(chave.equals(processo.getChaveProcesso())) {
				processoPorChaveDeProcesso = processo;
			}
		}
		return processoPorChaveDeProcesso;
	}
	
	public List<ProcessoDTO> criarProcesso(ProcessoDTO novoProcesso) {
		List<ProcessoDTO> todosOsProcessos = retornarTodosOsProcessos();
		for(ProcessoDTO processo : todosOsProcessos) {
			if(novoProcesso.getId().equals(processo.getId())) {
				return todosOsProcessos;
			}
		}
		todosOsProcessos.add(novoProcesso);
		return todosOsProcessos;
	}
	
	public List<ProcessoDTO> deletarProcesso(Integer id) {
		List<ProcessoDTO> todosOsProcessos = retornarTodosOsProcessos();
		for(int i = 0; i<todosOsProcessos.size(); i++) {
			if(id.equals(todosOsProcessos.get(i).getId())) {
				todosOsProcessos.remove(i);
			}
		}
		return todosOsProcessos;
	}
	
	public List<ProcessoDTO> atualizarProcesso(Integer id, ProcessoDTO processoAtualizado) {
		List<ProcessoDTO> todosOsProcessos = retornarTodosOsProcessos();
		for(int i = 0; i<todosOsProcessos.size(); i++) {
			if(id.equals(todosOsProcessos.get(i).getId())) {
				todosOsProcessos.set(i, processoAtualizado);
			}
		}
		return todosOsProcessos;
	}
}
