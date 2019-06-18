package com.starwars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.api.model.Item;
import com.starwars.api.model.Rebelde;
import com.starwars.api.repository.IRebeldeRepository;

/**
 * @author Aryosvalldo Cleef
 *
 */

/*
 * Classe que implementa a interface com os erviços para a entidade rebelde
 */

@Service
public class RebeldeServiceImpl implements IRebeldeService {

	/*
	 * Injetando as dependências necessárias
	 */

	@Autowired
	private IRebeldeRepository rebRepository;

	@Override
	public void save(Rebelde rebelde) {
		List<Item> itens = rebelde.getInventario().getItens();

		// Multiplicando os pontos dos itens pela quantidade do mesmo
		for (int i = 0; i < itens.size(); i++) {
			/*
			 * Verificando pontuação por nome do item, caso o item não seja válido o mesmo
			 * será cadastrado como "Lixo"
			 */
			if (itens.get(i).getNome().equalsIgnoreCase("Arma")) {
				itens.get(i).setPontos(4 * itens.get(i).getQtd());
			} else if (itens.get(i).getNome().equalsIgnoreCase("Munição")) {
				itens.get(i).setPontos(3 * itens.get(i).getQtd());
			} else if (itens.get(i).getNome().equalsIgnoreCase("Água")) {
				itens.get(i).setPontos(2 * itens.get(i).getQtd());
			} else if (itens.get(i).getNome().equalsIgnoreCase("Comida")) {
				itens.get(i).setPontos(itens.get(i).getQtd());
			} else {
				itens.get(i).setNome("Lixo");
				itens.get(i).setPontos(0);
				itens.get(i).setQtd(0);
			}
		}

		// Nova lista de itens com pontuação atualizada
		rebelde.getInventario().setItens(itens);

		// Salvando Rebelde
		rebRepository.save(rebelde);
	}

	@Override
	public Rebelde findById(long id) {
		return rebRepository.findById(id);
	}
}