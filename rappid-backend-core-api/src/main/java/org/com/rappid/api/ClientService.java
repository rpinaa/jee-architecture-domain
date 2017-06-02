package org.com.rappid.api;

import org.com.rappid.event.client.*;

/**
 * Created by PINA on 29/05/2017.
 */
public interface ClientService {

    ResponseClientEvent createClient(final CreateClientEvent createClientEvent);

    ResponseClientEvent getClientByIdClient(final RequestClientEvent requestClientEvent);

    CatalogClientEvent getAllClients(final RequestAllClientEvent requestAllClientEvent);

    ResponseClientEvent updateClient(final UpdateClientEvent updateClientEvent);

    void deleteClientByIdClient(final DeleteClientEvent deleteClientEvent);
}
