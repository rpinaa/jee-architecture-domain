package org.com.rappid.mapper;

import org.com.rappid.domain.Client;
import org.com.rappid.entity.ClientEntity;
import org.com.rappid.mapper.jpa.GenericMapper;
import org.mapstruct.Mapper;

/**
 * Created by PINA on 28/05/2017.
 */
@Mapper(componentModel = "cdi")
public interface ClientMapper extends GenericMapper<Client, ClientEntity> {

    Client map(final ClientEntity clientEntity);

    ClientEntity map(final Client client);
}
