package org.com.rappid.it.repository;

import org.com.rappid.repository.ClientRepository;
import org.com.rappid.repository.impl.ClientRepositoryImpl;
import org.com.rappid.stereotype.Repository;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by PINA on 05/06/2017.
 */
@RunWith(Arquillian.class)
public class ClientRepositoryITest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(ClientRepository.class, ClientRepositoryImpl.class)
                .addPackages(true, "org.com.rappid.repository.jpa", "org.com.rappid.entity")
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    @Repository
    private ClientRepository clientRepository;

    @Test
    public void validateCDIInjection() {
        Assert.assertNotNull(this.clientRepository);
    }
}
