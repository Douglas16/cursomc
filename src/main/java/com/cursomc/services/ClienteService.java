package com.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Cliente;
import com.cursomc.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	//OPERACAO BUSCAR Cliente POR CODIGO
	@Autowired //automaticamente instanciada pelo spring pelo Injeção de Depenencia
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException   {
		
		Optional<Cliente> obj = repo.findById(id);
		//return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
								"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
				
	}

}
