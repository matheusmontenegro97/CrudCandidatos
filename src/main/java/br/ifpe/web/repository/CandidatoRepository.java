package br.ifpe.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{

}
