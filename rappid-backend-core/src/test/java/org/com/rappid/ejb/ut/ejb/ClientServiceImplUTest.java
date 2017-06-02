package org.com.rappid.ejb.ut.ejb;

import org.com.rappid.api.ClientService;
import org.com.rappid.ejb.ClientServiceImpl;
import org.com.rappid.mapper.ClientMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by PINA on 19/05/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplUTest {

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService = new ClientServiceImpl();

    @Test
    public void createUserAdmin() {
        Assert.assertNotNull(this.clientService);
    }
}
