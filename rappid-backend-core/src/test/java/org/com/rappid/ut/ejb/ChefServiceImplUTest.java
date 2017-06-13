package org.com.rappid.ut.ejb;

import org.com.rappid.api.ChefService;
import org.com.rappid.service.ChefServiceImpl;
import org.com.rappid.mapper.ChefMapper;
import org.com.rappid.repository.ChefRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by PINA on 06/06/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ChefServiceImplUTest {

    @Mock
    private ChefMapper chefMapper;

    @Mock
    private ChefRepository chefRepository;

    @InjectMocks
    private ChefService chefService = new ChefServiceImpl();

    @Test
    public void createUserAdmin() {
        Assert.assertNotNull(this.chefService);
    }
}
