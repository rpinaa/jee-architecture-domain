package org.com.rappid.it.ejb;

import org.apache.openejb.junit.jee.EJBContainerRunner;
import org.com.rappid.api.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by PINA on 22/05/2017.
 */
@RunWith(EJBContainerRunner.class)
public class ClientServiceImplITest {

    @EJB
    private ClientService clientService;

    @Test
    public void validateJNDIInjection() {
        Assert.assertNotNull(this.clientService);
    }
}
