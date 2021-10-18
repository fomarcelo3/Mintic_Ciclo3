package com.costume.service;

import com.costume.model.Client;
import com.costume.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> unCliente = clientRepository.getClient(client.getIdClient());

            if (unCliente.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
}
