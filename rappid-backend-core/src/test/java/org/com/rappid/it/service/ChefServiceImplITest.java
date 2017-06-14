package org.com.rappid.it.service;

import org.com.rappid.api.ChefService;
import org.com.rappid.event.chef.*;
import org.com.rappid.service.ChefServiceImpl;
import org.com.rappid.it.service.stub.ChefServiceStub;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.concurrent.ExecutionException;

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

    private ResponseChefEvent responseChefEvent;

    @Before
    public void beforeEach() throws ExecutionException, InterruptedException {
        final CreateChefEvent createChefEvent = ChefServiceStub.createChefEvent();

        this.responseChefEvent = this.chefService.createChef(createChefEvent).get();
    }

    @Test
    public void createChef() {

        Assert.assertNotNull(this.responseChefEvent);
        Assert.assertNotNull(this.responseChefEvent.getChef());
        Assert.assertNotNull(this.responseChefEvent.getChef().getId());
        Assert.assertNotNull(this.responseChefEvent.getChef().getChangeDate());
        Assert.assertNotNull(this.responseChefEvent.getChef().getCreateDate());
        Assert.assertNotNull(this.responseChefEvent.getChef().getAccount());
        Assert.assertNotNull(this.responseChefEvent.getChef().getAccount().getId());
    }

    @Test
    public void getAllChefs() throws ExecutionException, InterruptedException {

        final RequestAllChefEvent requestAllChefEvent = RequestAllChefEvent.builder().limit(10).page(1).build();

        final CatalogChefEvent catalogChefEvent = this.chefService.getAllChefs(requestAllChefEvent).get();

        Assert.assertNotNull(catalogChefEvent);
        Assert.assertNotNull(catalogChefEvent.getChefs());
        Assert.assertEquals(catalogChefEvent.getChefs().size(), 1);
        Assert.assertEquals(catalogChefEvent.getTotal(), 1);
    }

    @Test
    public void getChef() throws ExecutionException, InterruptedException {

        final RequestChefEvent requestChefEvent = RequestChefEvent.builder()
                .id(this.responseChefEvent.getChef().getId())
                .build();

        final ResponseChefEvent responseChefEvent = this.chefService.getChefByIdChef(requestChefEvent).get();

        Assert.assertNotNull(responseChefEvent);
        Assert.assertNotNull(responseChefEvent.getChef());
        Assert.assertEquals(responseChefEvent.getChef(), this.responseChefEvent.getChef());
    }
}
