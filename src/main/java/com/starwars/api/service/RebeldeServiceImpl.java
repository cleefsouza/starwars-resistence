package com.starwars.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.api.model.Item;
import com.starwars.api.model.Rebelde;
import com.starwars.api.model.Trade;
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

	/*
	 * Métodos para cadastrar um rebelde no banco de dados
	 */
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

	/*
	 * Método para buscar um rebelde através do seu id
	 */
	@Override
	public Rebelde findById(long id) {
		return rebRepository.findById(id);
	}

	/*
	 * Método que realiza trade entre os rebeldes
	 */
	@Override
	public void realizarTrade(Trade ofertante, Trade receptor) {

		// Buscando informações dos rebeldes no banco de dados
		Rebelde rOfertante = findById(ofertante.getIdRebelde());
		Rebelde rReceptor = findById(receptor.getIdRebelde());

		// Validando itens para o trade

		rOfertante.getInventario().setItens(validarItens(rOfertante.getInventario().getItens(), ofertante.getItens()));
		rReceptor.getInventario().setItens(validarItens(rReceptor.getInventario().getItens(), receptor.getItens()));

		if (rOfertante.getInventario().getItens().isEmpty() || rReceptor.getInventario().getItens().isEmpty()) {
			System.err.println("TRADE CANCELADO");
			return;
		} else {
			System.out.println("TRADE EM ANDAMENTO");

		}
	}

	/*
	 * Método que verificando se o rebelde realmente tem os itens passados no JSON O
	 * trade só será possivel se todas as ofertas forem válidas
	 */
	@Override
	public List<Item> validarItens(List<Item> ofertante, List<Item> oferta) {
		List<Item> itensProntos = new ArrayList<>();

		// Percorre o inventario do rebelde
		for (int i = 0; i < ofertante.size(); i++) {

			// Percorre os itens ofertados
			for (int j = 0; j < oferta.size(); j++) {

				// Valores a checar
				String nome = ofertante.get(i).getNome();
				int qtd = ofertante.get(i).getQtd();

				// Verifica se o é valido
				if (oferta.get(j).getNome().equals(nome)) {
					// Verificar se a quantidade é válida
					if (oferta.get(j).getQtd() > qtd) {
						/*
						 * O trade só será possivel se todas as ofertas forem válidas
						 */
						return itensProntos = new ArrayList<>();
					} else {
						/*
						 * Adicionando itens atualizados
						 */
						Item item = ofertante.get(i);
						itensProntos.add(item);
					}
				} else {
					// Transforma os itens com nomes invalidos em null
					itensProntos.add(null);
				}
			}
		}

		// Removento itens inválidos
		itensProntos.removeIf(n -> (n == null));

		/*
		 * Verificando se número total de itens continua o mesmo, caso contrario o trade
		 * se tornará inválido
		 */

		if (itensProntos.size() < oferta.size()) {
			return itensProntos = new ArrayList<>();
		}

		// Retornará true se for válido
		return itensProntos;
	}
}