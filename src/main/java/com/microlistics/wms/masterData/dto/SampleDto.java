package com.microlistics.wms.masterData.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microlistics.wms.base.BaseDto;
import com.microlistics.wms.masterData.data.entities.Sample;
import com.microlistics.wms.masterData.data.entities.SampleType;

import java.time.ZonedDateTime;


public class SampleDto extends BaseDto<Sample, Long> {
    private Long id;
    @JsonProperty("sample_name")
    private String sampleName;
    @JsonProperty("sample_description")
    private String sampleDescription;
    @JsonProperty("sample_type")
    private SampleType sampleType;
    @JsonProperty("sample_status")
    private String sampleStatus;
    @JsonProperty("parent")
    private SampleParentDto parent;

    public SampleDto() {
    }

    public SampleDto(Sample sample) {
        this.id = sample.getId();
        this.sampleName = sample.getSampleName();
        this.sampleDescription = sample.getSampleDescription();
        this.sampleType = sample.getSampleType();
        this.sampleStatus = sample.getSampleStatus();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getSampleDescription() {
        return sampleDescription;
    }

    public void setSampleDescription(String sampleDescription) {
        this.sampleDescription = sampleDescription;
    }

    public SampleType getSampleType() {
        return sampleType;
    }

    public void setSampleType(SampleType sampleType) {
        this.sampleType = sampleType;
    }

    public String getSampleStatus() {
        return sampleStatus;
    }

    public void setSampleStatus(String sampleStatus) {
        this.sampleStatus = sampleStatus;
    }

    public SampleParentDto getParent() {
        return parent;
    }

    public void setParent(SampleParentDto parent) {
        this.parent = parent;
    }
}
