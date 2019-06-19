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

		// Nova lista de itens com pontuação atualizada
		for (int i = 0; i < itens.size(); i++) {
			itens.get(i).adicionarPontos();
		}
		rebelde.getInventario().setItens(itens);

		// Salvando Rebelde
		rebRepository.save(rebelde);
	}

	/*
	 * Método para buscar um rebelde através do seu id, onde o mesmo poderá ver
	 * todas as suas informações incluindo inventário e itens
	 */
	@Override
	public Rebelde findById(long id) {
		Rebelde rebelde = rebRepository.findById(id);
		/*
		 * Se o rebelde for um traidor ele não poderá realizar nenhuma ação
		 */
		if (rebelde.isTraidor()) {
			return null;
		} else {
			return rebelde;
		}
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

		List<Item> itensTradeOfertante = validarItens(rOfertante.getInventario().getItens(), ofertante.getItens());
		List<Item> itensTradeReceptor = validarItens(rReceptor.getInventario().getItens(), receptor.getItens());

		/*
		 * Se a lista de itens for inválida cancela o trade
		 */
		if (itensTradeOfertante.isEmpty() || itensTradeReceptor.isEmpty()) {
			return;
		} else {
			/*
			 * Se a pontuação dos itens for inválida cancela o trade
			 */
			if (!validarPontos(itensTradeOfertante, itensTradeReceptor)) {
				return;
			} else {
				/*
				 * Atualizando itens do inventário do ofertante e removendo do inventário do
				 * receptor
				 */

				rOfertante.getInventario()
						.setItens(adicionarItens(rOfertante.getInventario().getItens(), itensTradeReceptor));

				rOfertante.getInventario()
						.setItens(removerItens(rOfertante.getInventario().getItens(), itensTradeOfertante));

				/*
				 * Atualizando itens do inventário do receptor e removendo do inventário do
				 * ofertante
				 */
				rReceptor.getInventario()
						.setItens(adicionarItens(rReceptor.getInventario().getItens(), itensTradeOfertante));

				rReceptor.getInventario()
						.setItens(removerItens(rReceptor.getInventario().getItens(), itensTradeReceptor));

				/*
				 * Salvando modificações
				 */
				rebRepository.save(rOfertante);
				rebRepository.save(rReceptor);
			}
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
						Item item = oferta.get(j);
						item.setId(ofertante.get(i).getId());
						item.adicionarPontos();
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

	/*
	 * Método que verifica se a soma total do pontos é equivalente
	 */
	@Override
	public boolean validarPontos(List<Item> ofertante, List<Item> receptor) {

		// Recebe a pontuação para verificação
		int pontosOfertante = 0, pontosReceptor = 0;

		/*
		 * Somando pontuação
		 */
		for (Item it : ofertante) {
			pontosOfertante += (it.getPontos() * it.getQtd());
		}
		for (Item it : receptor) {
			pontosReceptor += (it.getPontos() * it.getQtd());
		}

		// Validando pontuação
		if (pontosOfertante != pontosReceptor)
			return false;

		return true;
	}

	/*
	 * Retorna uma lista contendo os novos itens a serem adicionados ao rebelde
	 */
	@Override
	public List<Item> adicionarItens(List<Item> ofertante, List<Item> oferta) {
		for (int i = 0; i < ofertante.size(); i++) {
			for (int j = 0; j < oferta.size(); j++) {
				if (ofertante.get(i).getNome().equals(oferta.get(j).getNome())) {
					// Adicionando itens ao ofertante
					ofertante.get(i).setQtd(ofertante.get(i).getQtd() + oferta.get(j).getQtd());
				}
			}
		}
		return ofertante;
	}

	/*
	 * Retorna uma lista contendo os itens a serem removidos do rebelde
	 */
	@Override
	public List<Item> removerItens(List<Item> ofertante, List<Item> oferta) {
		for (int i = 0; i < ofertante.size(); i++) {
			for (int j = 0; j < oferta.size(); j++) {
				if (ofertante.get(i).getId() == oferta.get(j).getId()) {
					// Adicionando itens ao ofertante
					ofertante.get(i).setQtd(ofertante.get(i).getQtd() - oferta.get(j).getQtd());
				}
			}
		}
		return ofertante;
	}

	/*
	 * Retorna uma lista com todos os rebeldes cadastrados
	 */
	@Override
	public List<Rebelde> findAll() {
		return rebRepository.findAll();
	}
}