package br.ifpe.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web.model.Candidato;
import br.ifpe.web.repository.CandidatoRepository;

@Controller
public class CandidatoController {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/cadCandidato")
	public String exibirFormCadastro(Candidato candidato) {
		return "cadastrar-candidato";
	}
	
	@PostMapping("/salvarCandidato")
	public String salvarCandidato(Candidato candidato, Model model) {
		
		this.candidatoRepository.save(candidato);
		
		return "redirect:/findCandidato";
	}
	
	@GetMapping("/findCandidato")
	public String exibirPesquisar(Model model) {
		model.addAttribute("colecao", this.candidatoRepository.findAll());
		return "pesquisar-candidatos";
	}
	
	@PostMapping("/pesquisarCandidato")
	public String pesquisarCandidatos(String nome, Model model) {
		
		List<Candidato> resultado = new ArrayList<>();
		for(Candidato c : this.candidatoRepository.findAll()) {
			if(c.getNome().toLowerCase().contains(nome.toLowerCase())) {
				resultado.add(c);
			}
		}
		model.addAttribute("colecao", resultado);
		
		return "pesquisar-candidatos";
	}
	
	@GetMapping("/editarCandidato")
	public String editarCliente(Integer codigo, Model model) {
		//Traz informações do cliente pelo seu id específico.
		Candidato candidato = this.candidatoRepository.getById(codigo);
		model.addAttribute("candidato", candidato);
		return "cadastrar-candidato";
	}
	
	@GetMapping("/removerCandidato")
	public String removerCliente(Integer codigo) {
		//Deleta as informações do cliente pelo seu id específico.
		this.candidatoRepository.deleteById(codigo);
		return "redirect:/findCandidato";

	}
}
