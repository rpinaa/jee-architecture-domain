package org.com.rappid.it.ejb;

import org.com.rappid.api.ChefService;
import org.com.rappid.ejb.ChefServiceImpl;
import org.com.rappid.mapper.ChefMapper;
import org.com.rappid.mapper.ChefMapperImpl;
import org.com.rappid.mapper.jpa.GenericMapper;
import org.com.rappid.repository.ChefRepository;
import org.com.rappid.repository.impl.ChefRepositoryImpl;
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
 * Created by PINA on 06/06/2017.
 */
@RunWith(Arquillian.class)
public class ChefServiceImplITest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(ChefServiceImpl.class)
                .addClasses(GenericMapper.class, ChefMapper.class, ChefMapperImpl.class)
                .addClasses(ChefRepository.class, ChefRepositoryImpl.class)
                .addPackages(true, "org.com.rappid.repository.jpa", "org.com.rappid.entity")
                .addPackages(true, "org.com.rappid.domain", "org.com.rappid.catalog")
                .addPackages(true, "org.com.rappid.event", "org.com.rappid.api")
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private ChefService chefService;

    @Test
    public void validateJNDIInjection() {
        Assert.assertNotNull(this.chefService);
    }
}
