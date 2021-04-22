package br.com.backend.project.devinhouseavaliacaomodulo2.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.project.devinhouseavaliacaomodulo2.dto.ProcessoDTO;
import br.com.backend.project.devinhouseavaliacaomodulo2.service.ProcessoService;

@RestController
@RequestMapping(headers = "api-version=v1", path = "/v1" + "/processos")
public class ProcessosControll {
	
	@Autowired
	private ProcessoService service;
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> criarProcesso(@RequestBody ProcessoDTO novoProcesso) {
		return service.criarProcesso(novoProcesso);
	}
	
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> consultarTodosOsProcessos() {
		return service.retornarTodosOsProcessos();
	}

	@GetMapping(path = "/processo/{id}", produces = APPLICATION_JSON_VALUE) 
	public ProcessoDTO consultarProcessoPorId(@PathVariable Integer id) { 
		return service.retornarProcessoPorId(id); 
	}
	 
	
	@GetMapping(path = "/processo", produces = APPLICATION_JSON_VALUE)
	public ProcessoDTO consultarProcessoPorChaveDeProcesso(@RequestParam String chave) {
		return service.retornarProcessoPorChaveDeProcesso(chave);
	}

	@PutMapping(path = "/processo/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
	public List<ProcessoDTO> atualizarProcesso(@PathVariable Integer id, @RequestBody ProcessoDTO processoAtualizado) {
		return service.atualizarProcesso(id, processoAtualizado);
	}
	
	@DeleteMapping(path = "/processo/{id}", produces = APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> deletarProcesso(@PathVariable Integer id) {
		return service.deletarProcesso(id);
	}
}
