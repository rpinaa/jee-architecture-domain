package org.com.rappid.repository.impl;

import org.com.rappid.domain.Client;
import org.com.rappid.entity.ClientEntity;
import org.com.rappid.repository.ClientRepository;
import org.com.rappid.repository.jpa.impl.GenericJPARepositoryImpl;
import org.com.rappid.stereotype.Repository;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by PINA on 05/06/2017.
 */
@Repository
@ApplicationScoped
public class ClientRepositoryImpl extends GenericJPARepositoryImpl<Client, ClientEntity> implements ClientRepository {
}
