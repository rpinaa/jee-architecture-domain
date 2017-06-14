package org.com.rappid.api;

import org.com.rappid.event.chef.*;

import java.util.concurrent.Future;

/**
 * Created by PINA on 31/05/2017.
 */
public interface ChefService {

    Future<ResponseChefEvent> createChef(final CreateChefEvent createChefEvent);

    Future<ResponseChefEvent> getChefByIdChef(final RequestChefEvent requestChefEvent);

    Future<CatalogChefEvent> getAllChefs(final RequestAllChefEvent requestAllChefEvent);

    Future<ResponseChefEvent> updateChef(final UpdateChefEvent updateChefEvent);

    void deleteChefByIdChef(final DeleteChefEvent deleteChefEvent);
}
