package br.com.backend.project.devinhouseavaliacaomodulo2.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.backend.project.devinhouseavaliacaomodulo2.dto.ProcessoDTO;
import br.com.backend.project.devinhouseavaliacaomodulo2.mock.ProcessoMock;

@Repository
public class ProcessoRepository {
	@Autowired
	private ProcessoMock processosMockados;
	
	public List<ProcessoDTO> criarRepository() {
		return processosMockados.getAllProcessos();
	}
}
