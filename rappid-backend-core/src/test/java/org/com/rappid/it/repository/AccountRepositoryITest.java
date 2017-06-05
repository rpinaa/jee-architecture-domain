package org.com.rappid.it.repository;

import org.com.rappid.entity.AbstractEntity;
import org.com.rappid.entity.AccountEntity;
import org.com.rappid.repository.AccountRepository;
import org.com.rappid.repository.impl.AccountRepositoryImpl;
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
 * Created by PINA on 04/06/2017.
 */
@RunWith(Arquillian.class)
public class AccountRepositoryITest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(AbstractEntity.class, AccountEntity.class, GenericJPARepository.class, AccountRepository.class, AccountRepositoryImpl.class)
                .addAsManifestResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    @Repository
    private AccountRepository accountRepository;

    @Test
    public void validateCDIInjection() {
        Assert.assertNotNull(this.accountRepository);
    }
}
