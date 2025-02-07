package com.microlistics.wms.masterData.services;

import com.microlistics.wms.masterData.data.entities.Sample;
import com.microlistics.wms.masterData.data.entities.SampleParent;
import com.microlistics.wms.masterData.dto.SampleDto;
import com.microlistics.wms.masterData.dto.SampleParentDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MasterDataHelper {
    public Sample convertToEntity(SampleDto dto) {
        return convertToEntity(dto, null);
    }

    public Sample convertToEntity(SampleDto dto, Sample sample) {
        if (sample == null) {
            sample = new Sample();
            sample.setId(dto.getId());
        }
        sample.setSampleName(dto.getSampleName());
        sample.setSampleDescription(dto.getSampleDescription());
        sample.setSampleType(dto.getSampleType());
        sample.setSampleStatus(dto.getSampleStatus());
        sample.setParent(convertToEntity(dto.getParent()));
        return sample;
    }

    public SampleParent convertToEntity(SampleParentDto dto) {
        return new SampleParent(dto.getId(), dto.name, dto.description);
    }

    public SampleDto convertToDto(Sample entity) {
        return new SampleDto(entity);
    }
}
