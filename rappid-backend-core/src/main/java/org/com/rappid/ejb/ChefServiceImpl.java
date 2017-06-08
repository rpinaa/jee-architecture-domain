package org.com.rappid.ejb;

import org.com.rappid.api.ChefService;
import org.com.rappid.entity.ChefEntity;
import org.com.rappid.event.chef.*;
import org.com.rappid.group.chef.CreateChefGroup;
import org.com.rappid.mapper.ChefMapper;
import org.com.rappid.repository.ChefRepository;
import org.com.rappid.stereotype.Repository;

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
    private ChefMapper chefMapper;

    @Inject
    @Repository
    private ChefRepository chefRepository;

    @Override
    public ResponseChefEvent createChef(final CreateChefEvent createChefEvent) {

        final ChefEntity chefEntity = this.chefMapper.map(createChefEvent.getChef(), CreateChefGroup.class);

        this.chefRepository.insert(chefEntity);

        return ResponseChefEvent.builder().chef(this.chefMapper.map(chefEntity)).build();
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
