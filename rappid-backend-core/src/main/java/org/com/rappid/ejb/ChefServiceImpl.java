package org.com.rappid.ejb;

import org.com.rappid.api.ChefService;
import org.com.rappid.event.chef.*;
import org.com.rappid.mapper.ChefMapper;
import org.com.rappid.stereotype.Mapper;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by PINA on 31/05/2017.
 */
@Stateless
@Local(ChefService.class)
public class ChefServiceImpl implements ChefService {

    @Inject
    @Mapper
    private ChefMapper chefMapper;

    @Override
    public ResponseChefEvent createChef(final CreateChefEvent createChefEvent) {
        return null;
    }

    @Override
    public ResponseChefEvent getChefByIdChef(final RequestChefEvent requestChefEvent) {
        return null;
    }

    @Override
    public CatalogChefEvent getAllChefs(final RequestAllChefEvent requestAllChefEvent) {
        return null;
    }

    @Override
    public ResponseChefEvent updateChef(final UpdateChefEvent updateChefEvent) {
        return null;
    }

    @Override
    public void deleteChefByIdChef(final DeleteChefEvent deleteChefEvent) {

    }
}
