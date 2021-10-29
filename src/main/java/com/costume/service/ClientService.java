package com.costume.service;

import com.costume.model.Admin;
import com.costume.model.Client;
import com.costume.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Clase servicio entidad Client
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
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

    public  Client updateClient(Client client){
        if (client.getIdClient() != null){
            Optional<Client> client_bd = clientRepository.getClient(client.getIdClient());
            if (!client_bd.isEmpty()){
                if (client.getName() != null){
                    client_bd.get().setName(client.getName());
                }

                if (client.getAge() != null){
                    client_bd.get().setAge(client.getAge());
                }

                if (client.getPassword() != null){
                    client_bd.get().setPassword(client.getPassword());
                }

                clientRepository.save(client_bd.get());
                return client_bd.get();
            }
        }
        return  client;
    }

    public boolean deleteClient(int id){
        Optional<Client> client  = clientRepository.getClient(id);
        if (client.isEmpty()){
            return  false;
        }else {
            clientRepository.delete(client.get());
            return  true;
        }
    }
}
