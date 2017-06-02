package org.com.rappid.api;

import org.com.rappid.event.chef.*;

/**
 * Created by PINA on 31/05/2017.
 */
public interface ChefService {

    ResponseChefEvent createChef(final CreateChefEvent createChefEvent);

    ResponseChefEvent getChefByIdChef(final RequestChefEvent requestChefEvent);

    CatalogChefEvent getAllChefs(final RequestAllChefEvent requestAllChefEvent);

    ResponseChefEvent updateChef(final UpdateChefEvent updateChefEvent);

    void deleteChefByIdChef(final DeleteChefEvent deleteChefEvent);
}
