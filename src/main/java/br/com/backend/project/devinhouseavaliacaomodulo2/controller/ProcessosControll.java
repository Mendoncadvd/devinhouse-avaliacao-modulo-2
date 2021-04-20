package br.com.backend.project.devinhouseavaliacaomodulo2.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.project.devinhouseavaliacaomodulo2.dto.ProcessoDTO;
import br.com.backend.project.devinhouseavaliacaomodulo2.service.ProcessoService;

@RestController
//TODO: Descobrir se devo fazer o versionamento do controller tb.
@RequestMapping("/processos")
public class ProcessosControll {
	@Autowired
	private ProcessoService service;
	//TODO: Fazer o versionamento de tudo.
	
	@RequestMapping(headers = "api-version=v1", value = "/v1" + "/criar-processo", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> criarProcesso(@RequestBody ProcessoDTO novoProcesso) {
		return service.criarProcesso(novoProcesso);
	}
	
	@RequestMapping(headers = "api-version=v1", value = "/v1" + "/consultar-todos-processos", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE )
	public List<ProcessoDTO> consultarTodosOsProcessos() {
		return service.retornarTodosOsProcessos();
	}
	
	@RequestMapping(headers = "api-version=v1", value = "/v1" + "/consultar-processo-porid", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	//quando pega o parametro da url, retorna um String sempre?
	public ProcessoDTO consultarProcessoPorId(@RequestParam Integer id) {
		return service.retornarProcessoPorId(id);
	}
	
	@RequestMapping(headers = "api-version=v1", value = "/v1" +"/consultar-processo-porchave", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ProcessoDTO consultarProcessoPorChaveDeProcesso(@RequestParam String chave) {
		return service.retornarProcessoPorChaveDeProcesso(chave);
	}

	@RequestMapping(headers = "api-version=v1", value = "/v1" + "/atualizar-processo", method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
	public List<ProcessoDTO> atualizarProcesso(@RequestParam Integer id, @RequestBody ProcessoDTO processoAtualizado) {
		return service.atualizarProcesso(id, processoAtualizado);
	}
	
	@RequestMapping(headers = "api-version=v1", value = "/v1" +"/deletar-processo", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
	public List<ProcessoDTO> deletarProcesso(@RequestParam Integer id) {
		return service.deletarProcesso(id);
	}
}
