package org.com.rappid.it.service;

import org.com.rappid.api.ChefService;
import org.com.rappid.catalog.ChefStatusType;
import org.com.rappid.event.chef.*;
import org.com.rappid.it.service.stub.ChefServiceStub;
import org.com.rappid.mapper.ChefMapper;
import org.com.rappid.mapper.ChefMapperImpl;
import org.com.rappid.mapper.jpa.GenericMapper;
import org.com.rappid.repository.ChefRepository;
import org.com.rappid.repository.impl.ChefRepositoryImpl;
import org.com.rappid.service.ChefServiceImpl;
import org.com.rappid.stereotype.Repository;
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
                .addClasses(ChefServiceImpl.class, ChefServiceStub.class)
                .addClasses(GenericMapper.class, ChefMapper.class, ChefMapperImpl.class)
                .addClasses(ChefRepository.class, ChefRepositoryImpl.class, Repository.class)
                .addPackages(true, "org.com.rappid.repository.jpa", "org.com.rappid.entity")
                .addPackages(true, "org.com.rappid.group", "org.com.rappid.constraint")
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
    public void shouldCreateChef() {

        Assert.assertNotNull(this.responseChefEvent);
        Assert.assertNotNull(this.responseChefEvent.getChef());
        Assert.assertNotNull(this.responseChefEvent.getChef().getId());
        Assert.assertNotNull(this.responseChefEvent.getChef().getChangeDate());
        Assert.assertNotNull(this.responseChefEvent.getChef().getCreateDate());
        Assert.assertNotNull(this.responseChefEvent.getChef().getAccount());
        Assert.assertNotNull(this.responseChefEvent.getChef().getAccount().getId());
    }

    @Test
    public void shouldGetAllChefs() throws ExecutionException, InterruptedException {

        final RequestAllChefEvent requestAllChefEvent = RequestAllChefEvent.builder().limit(10).page(1).build();

        final CatalogChefEvent catalogChefEvent = this.chefService.getChefs(requestAllChefEvent).get();

        Assert.assertNotNull(catalogChefEvent);
        Assert.assertNotNull(catalogChefEvent.getChefs());
        Assert.assertEquals(catalogChefEvent.getChefs().size(), 4);
        Assert.assertEquals(catalogChefEvent.getTotal(), 4);
    }

    @Test
    public void shouldGetChef() throws ExecutionException, InterruptedException {

        final RequestChefEvent requestChefEvent = RequestChefEvent.builder()
                .id(this.responseChefEvent.getChef().getId())
                .build();

        final ResponseChefEvent responseChefEvent = this.chefService.getChef(requestChefEvent).get();

        Assert.assertNotNull(responseChefEvent);
        Assert.assertNotNull(responseChefEvent.getChef());
        Assert.assertEquals(responseChefEvent.getChef(), this.responseChefEvent.getChef());
    }

    @Test
    public void shouldUpdateChef() throws ExecutionException, InterruptedException {

        final UpdateChefEvent updateChefEvent = UpdateChefEvent.builder()
                .chef(this.responseChefEvent.getChef())
                .build();

        updateChefEvent.getChef().setCurp("RTYU810114MDFXRR11");
        updateChefEvent.getChef().setRfc("RTYU810114F34");
        updateChefEvent.getChef().setRating(1F);
        updateChefEvent.getChef().setStatus(ChefStatusType.REGISTERED);

        final ResponseChefEvent responseChefEvent = this.chefService.updateChef(updateChefEvent).get();

        Assert.assertNotNull(responseChefEvent);
        Assert.assertNotNull(responseChefEvent.getChef());
        Assert.assertEquals(responseChefEvent.getChef().getCurp(),"RTYU810114MDFXRR11");
        Assert.assertEquals(responseChefEvent.getChef().getRfc(),"RTYU810114F34");
        Assert.assertEquals(responseChefEvent.getChef().getRating(), new Float(1));
        Assert.assertEquals(responseChefEvent.getChef().getStatus(), ChefStatusType.REGISTERED);
    }

    @Test
    public void shouldDeleteChef() throws ExecutionException, InterruptedException {

        final DeleteChefEvent deleteChefEvent = DeleteChefEvent.builder()
                .id(this.responseChefEvent.getChef().getId())
                .build();

        this.chefService.deleteChef(deleteChefEvent);
    }
}
