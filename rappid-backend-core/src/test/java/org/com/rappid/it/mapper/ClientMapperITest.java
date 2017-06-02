package org.com.rappid.it.mapper;

import org.apache.openejb.junit.jee.EJBContainerRunner;
import org.com.rappid.catalog.TelephoneType;
import org.com.rappid.domain.Client;
import org.com.rappid.domain.Telephone;
import org.com.rappid.entity.ClientEntity;
import org.com.rappid.mapper.ClientMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by PINA on 02/06/2017.
 */
@RunWith(EJBContainerRunner.class)
public class ClientMapperITest {

    @Inject
    private ClientMapper clientMapper;

    private Client client;

    @Before
    public void before() {
        client = Client.builder()
                .firstName("Ricardo Pina")
                .lastName("Arellano")
                .email("pinaarellano0@gmail.com")
                .telephone(Telephone.builder()
                        .name("Home")
                        .lada("52")
                        .number("5523360745")
                        .telephoneType(TelephoneType.HOME)
                        .build())
                .build();
    }

    @Test
    public void mappingFromFtoT() {

        final ClientEntity clientEntity = this.clientMapper.map(this.client);

        Assert.assertNotNull(clientEntity);
        Assert.assertEquals(clientEntity.getEmail(), this.client.getEmail());
        Assert.assertEquals(clientEntity.getFirstName(), this.client.getFirstName());
        Assert.assertEquals(clientEntity.getLastName(), this.client.getLastName());
        Assert.assertEquals(clientEntity.getTelephone().getName(), this.client.getTelephone().getName());
        Assert.assertEquals(clientEntity.getTelephone().getLada(), this.client.getTelephone().getLada());
        Assert.assertEquals(clientEntity.getTelephone().getNumber(), this.client.getTelephone().getNumber());
    }

    @Test
    public void mappingFromTtoF() {

        final ClientEntity clientEntity = this.clientMapper.map(this.client);
        final Client client = this.clientMapper.map(clientEntity);

        Assert.assertNotNull(client);
        Assert.assertEquals(clientEntity.getEmail(), client.getEmail());
        Assert.assertEquals(clientEntity.getFirstName(), client.getFirstName());
        Assert.assertEquals(clientEntity.getLastName(), client.getLastName());
        Assert.assertEquals(clientEntity.getTelephone().getName(), client.getTelephone().getName());
        Assert.assertEquals(clientEntity.getTelephone().getLada(), client.getTelephone().getLada());
        Assert.assertEquals(clientEntity.getTelephone().getNumber(), client.getTelephone().getNumber());
    }

}
