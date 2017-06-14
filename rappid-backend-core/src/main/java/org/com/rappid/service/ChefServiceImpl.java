package org.com.rappid.service;

import org.com.rappid.api.ChefService;
import org.com.rappid.entity.ChefEntity;
import org.com.rappid.event.chef.*;
import org.com.rappid.group.chef.CreateChefGroup;
import org.com.rappid.group.chef.UpdateChefGroup;
import org.com.rappid.mapper.ChefMapper;
import org.com.rappid.repository.ChefRepository;
import org.com.rappid.stereotype.Repository;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Override
    @Transactional
    public ResponseChefEvent createChef(final CreateChefEvent createChefEvent) {

        final ChefEntity chefEntity = this.chefMapper.map(createChefEvent.getChef(), CreateChefGroup.class);

        this.chefRepository.insert(chefEntity);

        return ResponseChefEvent.builder().chef(this.chefMapper.map(chefEntity)).build();
    }

    @Override
    @Transactional
    public ResponseChefEvent getChefByIdChef(final RequestChefEvent requestChefEvent) {

        final ChefEntity chefEntity = this.chefRepository.findById(requestChefEvent.getId());

        return ResponseChefEvent.builder().chef(this.chefMapper.map(chefEntity)).build();
    }

    @Override
    @Transactional
    public CatalogChefEvent getAllChefs(final RequestAllChefEvent requestAllChefEvent) {

        List<ChefEntity> chefEntities = null;
        long total = 0;

        try {
            chefEntities = this.executorService.submit(() -> this.chefRepository
                    .findAll(requestAllChefEvent.getPage(), requestAllChefEvent.getLimit())).get();

            total = this.executorService.submit(() -> this.chefRepository.count()).get();
        } catch (final Exception ignored) {}

        return CatalogChefEvent.builder().chefs(this.chefMapper.mapListReverse(chefEntities)).total(total).build();
    }

    @Override
    @Transactional
    public ResponseChefEvent updateChef(final UpdateChefEvent updateChefEvent) {

        final ChefEntity chefEntity = this.chefMapper.map(updateChefEvent.getChef(), CreateChefGroup.class, UpdateChefGroup.class);

        this.chefRepository.update(chefEntity);

        return ResponseChefEvent.builder().chef(this.chefMapper.map(chefEntity)).build();
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void deleteChefByIdChef(final DeleteChefEvent deleteChefEvent) {
        this.chefRepository.delete(deleteChefEvent.getId());
    }
}
