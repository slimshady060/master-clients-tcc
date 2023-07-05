package com.tcc.master.service;

import com.tcc.master.model.Client;
import com.tcc.master.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id" + id));
    }

    public Client CreateClient(Client client) {
        String email = client.getEmail();
        Client existEmail = clientRepository.findByEmail(email);
        if(existEmail != null) {
            throw  new RuntimeException("Client with email " + email + " already exist");
        }
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id " + id));
        existingClient.setEmail(client.getEmail());
        existingClient.setName(client.getName());
        return clientRepository.save(existingClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


}
