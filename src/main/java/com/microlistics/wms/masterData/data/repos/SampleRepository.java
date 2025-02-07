package com.microlistics.wms.masterData.data.repos;

import com.microlistics.wms.masterData.data.entities.Sample;
import io.onebyone.quarkus.microservices.common.repository.BaseRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SampleRepository extends BaseRepository<Sample, Long> {
}
