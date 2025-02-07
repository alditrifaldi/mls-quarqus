package com.microlistics.wms.masterData.resources;

import com.microlistics.wms.masterData.MasterDataConstant;
import com.microlistics.wms.masterData.data.entities.Sample;
import com.microlistics.wms.masterData.data.repos.SampleRepository;
import com.microlistics.wms.masterData.dto.SampleDto;
import com.microlistics.wms.masterData.services.MasterDataHelper;
import io.onebyone.quarkus.microservices.common.repository.BaseRepository;
import io.onebyone.quarkus.microservices.common.v2.crud.CrudableEndpointResource;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Path;
import org.apache.commons.lang3.StringUtils;

@Path(MasterDataConstant.PATH_API_SAMPLE)
public class SampleResources extends CrudableEndpointResource<Sample, SampleDto, Long> {

    @Inject
    SampleRepository repository;
    @Inject
    MasterDataHelper helper;

    @Override
    protected Sample toEntity(SampleDto dao) {
        return helper.convertToEntity(dao);
    }

    @Override
    protected Sample update(Sample entity, SampleDto dao) {
        return helper.convertToEntity(dao, entity);
    }

    @Override
    protected BaseRepository<Sample, Long> getRepository() {
        return repository;
    }

    @Override
    protected SampleDto fromEntity(Sample entity) {
        return helper.convertToDto(entity);
    }

    @Override
    protected Long toId(String id) {
        if (StringUtils.isNotBlank(id)) {
            return Long.parseLong(id);
        }
        throw new BadRequestException("Invalid id");
    }
}
