package com.starwars.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starwars.api.model.Localizacao;

/**
 * @author Aryaovalldo Cleef
 *
 */

public interface ILocalizacaoRepository extends JpaRepository<Localizacao, Long>{

}
