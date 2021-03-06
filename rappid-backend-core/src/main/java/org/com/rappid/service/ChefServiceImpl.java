package org.com.rappid.service;

import org.com.rappid.api.ChefService;
import org.com.rappid.entity.ChefEntity;
import org.com.rappid.event.chef.*;
import org.com.rappid.group.chef.CreateChefGroup;
import org.com.rappid.group.chef.UpdateChefGroup;
import org.com.rappid.mapper.ChefMapper;
import org.com.rappid.repository.ChefRepository;
import org.com.rappid.stereotype.Repository;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.Future;

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
    @Asynchronous
    @Transactional
    public Future<ResponseChefEvent> createChef(final CreateChefEvent event) {

        final ChefEntity chefEntity = this.chefMapper.map(event.getChef(), CreateChefGroup.class);

        this.chefRepository.insert(chefEntity);

        return new AsyncResult<>(ResponseChefEvent.builder().chef(this.chefMapper.map(chefEntity)).build());
    }

    @Override
    @Asynchronous
    @Transactional
    public Future<ResponseChefEvent> getChef(final RequestChefEvent event) {

        final ChefEntity chefEntity = this.chefRepository.findOne(event.getId());

        return new AsyncResult<>(ResponseChefEvent.builder().chef(this.chefMapper.map(chefEntity)).build());
    }

    @Override
    @Asynchronous
    @Transactional
    public Future<CatalogChefEvent> getChefs(final RequestAllChefEvent event) {

        final List<ChefEntity> chefEntities = this.chefRepository.findAll(event.getPage() - 1, event.getLimit());
        final long total = this.chefRepository.count();

        return new AsyncResult<>(CatalogChefEvent.builder()
                .chefs(this.chefMapper.mapListReverse(chefEntities)).total(total).build());
    }

    @Override
    @Asynchronous
    @Transactional
    public Future<ResponseChefEvent> updateChef(final UpdateChefEvent event) {

        final ChefEntity chefEntity = this.chefMapper.map(event.getChef(), UpdateChefGroup.class);

        this.chefRepository.update(chefEntity);

        return new AsyncResult<>(ResponseChefEvent.builder().chef(this.chefMapper.map(chefEntity)).build());
    }

    @Override
    @Asynchronous
    @Transactional
    public void deleteChef(final DeleteChefEvent event) {

        this.chefRepository.delete(event.getId());
    }

    @Override
    @Asynchronous
    @Transactional
    public void deleteChefs() {

        this.chefRepository.deleteAll();
    }
}
