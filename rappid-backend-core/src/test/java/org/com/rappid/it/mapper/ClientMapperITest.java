package org.com.rappid.it.mapper;

import org.com.rappid.catalog.TelephoneType;
import org.com.rappid.domain.Client;
import org.com.rappid.domain.Telephone;
import org.com.rappid.entity.ClientEntity;
import org.com.rappid.mapper.ClientMapper;
import org.com.rappid.mapper.ClientMapperImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by PINA on 02/06/2017.
 */
@RunWith(Arquillian.class)
public class ClientMapperITest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(ClientMapper.class, ClientMapperImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

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
