package org.com.rappid.it.ejb;

import org.com.rappid.api.ClientService;
import org.com.rappid.ejb.ClientServiceImpl;
import org.com.rappid.mapper.ClientMapper;
import org.com.rappid.mapper.ClientMapperImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by PINA on 22/05/2017.
 */
@RunWith(Arquillian.class)
public class ClientServiceImplITest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(ClientMapper.class, ClientMapperImpl.class, ClientServiceImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private ClientService clientService;

    @Test
    public void validateJNDIInjection() {
        Assert.assertNotNull(this.clientService);
    }
}
