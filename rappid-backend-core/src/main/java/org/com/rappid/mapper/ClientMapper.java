package org.com.rappid.mapper;

import org.com.rappid.domain.Client;
import org.com.rappid.entity.ClientEntity;
import org.com.rappid.mapper.jpa.impl.GenericMapperImpl;
import org.com.rappid.stereotype.Mapper;

import javax.ejb.Singleton;

/**
 * Created by PINA on 28/05/2017.
 */
@Mapper
@Singleton
public class ClientMapper extends GenericMapperImpl<Client, ClientEntity> {
}
