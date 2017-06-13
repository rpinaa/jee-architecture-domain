package org.com.rappid.service;

import org.com.rappid.api.ClientService;
import org.com.rappid.event.client.*;
import org.com.rappid.mapper.ClientMapper;
import org.com.rappid.repository.ClientRepository;
import org.com.rappid.stereotype.Repository;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by PINA on 29/05/2017.
 */

@Stateless
@Local(ClientService.class)
public class ClientServiceImpl implements ClientService {

    @Inject
    private ClientMapper clientMapper;

    @Inject
    @Repository
    private ClientRepository clientRepository;

    @Override
    public ResponseClientEvent createClient(final CreateClientEvent createClientEvent) {
        return null;
    }

    @Override
    public ResponseClientEvent getClientByIdClient(final RequestClientEvent requestClientEvent) {
        return null;
    }

    @Override
    public CatalogClientEvent getAllClients(final RequestAllClientEvent requestAllClientEvent) {
        return null;
    }

    @Override
    public ResponseClientEvent updateClient(final UpdateClientEvent updateClientEvent) {
        return null;
    }

    @Override
    public void deleteClientByIdClient(final DeleteClientEvent deleteClientEvent) {

    }
}
