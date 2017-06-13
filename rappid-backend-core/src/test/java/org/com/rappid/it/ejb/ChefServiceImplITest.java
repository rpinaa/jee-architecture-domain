package org.com.rappid.it.ejb;

import org.com.rappid.api.ChefService;
import org.com.rappid.ejb.ChefServiceImpl;
import org.com.rappid.event.chef.CatalogChefEvent;
import org.com.rappid.event.chef.CreateChefEvent;
import org.com.rappid.event.chef.RequestAllChefEvent;
import org.com.rappid.event.chef.ResponseChefEvent;
import org.com.rappid.it.ejb.stub.ChefServiceStub;
import org.com.rappid.mapper.ChefMapper;
import org.com.rappid.mapper.ChefMapperImpl;
import org.com.rappid.mapper.jpa.GenericMapper;
import org.com.rappid.repository.ChefRepository;
import org.com.rappid.repository.impl.ChefRepositoryImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
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
                .addAsResource(new ClassLoaderAsset("META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsResource(new ClassLoaderAsset("META-INF/resources.xml"), "META-INF/resources.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private ChefService chefService;

    @Test
    public void validateJNDIInjection() {
        Assert.assertNotNull(this.chefService);
    }

    @Test
    public void createChef() {

        final CreateChefEvent createChefEvent = ChefServiceStub.createChefEvent();

        final ResponseChefEvent responseChefEvent = this.chefService.createChef(createChefEvent);

        Assert.assertNotNull(responseChefEvent);
        Assert.assertNotNull(responseChefEvent.getChef());
        Assert.assertNotNull(responseChefEvent.getChef().getId());
        Assert.assertNotNull(responseChefEvent.getChef().getChangeDate());
        Assert.assertNotNull(responseChefEvent.getChef().getCreateDate());
        Assert.assertNotNull(responseChefEvent.getChef().getAccount());
        Assert.assertNotNull(responseChefEvent.getChef().getAccount().getId());
    }

    @Test
    public void getAllChefs() {

        final RequestAllChefEvent requestAllChefEvent = RequestAllChefEvent.builder().limit(10).page(1).build();

        final CatalogChefEvent catalogChefEvent = this.chefService.getAllChefs(requestAllChefEvent);

        Assert.assertNotNull(catalogChefEvent);
    }
}
