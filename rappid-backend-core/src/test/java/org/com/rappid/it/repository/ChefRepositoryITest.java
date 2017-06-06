package org.com.rappid.it.repository;

import org.com.rappid.entity.AbstractEntity;
import org.com.rappid.entity.AccountEntity;
import org.com.rappid.entity.ChefEntity;
import org.com.rappid.repository.AccountRepository;
import org.com.rappid.repository.ChefRepository;
import org.com.rappid.repository.impl.AccountRepositoryImpl;
import org.com.rappid.repository.impl.ChefRepositoryImpl;
import org.com.rappid.repository.jpa.GenericJPARepository;
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
public class ChefRepositoryITest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(AbstractEntity.class, ChefEntity.class, GenericJPARepository.class, ChefRepository.class, ChefRepositoryImpl.class)
                .addAsManifestResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    @Repository
    private ChefRepository chefRepository;

    @Test
    public void validateCDIInjection() {
        Assert.assertNotNull(this.chefRepository);
    }
}
