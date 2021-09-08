package com.capgemini.market.persistence;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.repository.ClientRepository;
import com.capgemini.market.persistence.crud.ClienteCrudRepository;
import com.capgemini.market.persistence.entity.Cliente;
import com.capgemini.market.persistence.entity.Producto;
import com.capgemini.market.persistence.mapper.ClientMapper;
import com.capgemini.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public class ClienteRepository implements ClientRepository {
    @Autowired //los obque reciben esta notacion le cedemos el control a spring para que haga las instancias
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return clientMapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getClientById(String clientId) {
        return clienteCrudRepository.findById(clientId).map(cliente -> clientMapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = clientMapper.toCliente(client); //se invoca el mapeo inverso
        return clientMapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(String clientId) {
        clienteCrudRepository.deleteById(clientId);
    }
}
