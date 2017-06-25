package org.com.rappid.api;

import org.com.rappid.event.chef.*;

import java.util.concurrent.Future;

/**
 * Created by PINA on 31/05/2017.
 */
public interface ChefService {

    Future<ResponseChefEvent> createChef(final CreateChefEvent event);

    Future<ResponseChefEvent> getChef(final RequestChefEvent event);

    Future<CatalogChefEvent> getChefs(final RequestAllChefEvent event);

    Future<ResponseChefEvent> updateChef(final UpdateChefEvent event);

    void deleteChef(final DeleteChefEvent event);

    void deleteChefs();
}
