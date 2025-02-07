package com.microlistics.wms.masterData.data.entities;

import io.onebyone.quarkus.microservices.common.v2.entity.BaseEntity;
import jakarta.persistence.*;
import org.jboss.logging.Logger;

@Entity
@Table(name = "tb_sample")
public class Sample extends BaseEntity<Long> {
    private static final Logger log = Logger.getLogger(Sample.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sample_name")
    private String sampleName;
    @Column(name = "sample_description")
    private String sampleDescription;
    @Column(name = "sample_type")
    @Enumerated(EnumType.STRING)
    private SampleType sampleType;
    @Column(name = "sample_status")
    private String sampleStatus;

    /**
     * how to define many to one relation
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private SampleParent parent;

    public Sample() {
    }

    public Sample(String sampleName, String sampleDescription, SampleType sampleType, String sampleStatus, SampleParent parent) {
        this.sampleName = sampleName;
        this.sampleDescription = sampleDescription;
        this.sampleType = sampleType;
        this.sampleStatus = sampleStatus;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    public SampleParent getParent() {
        return parent;
    }

    public void setParent(SampleParent parent) {
        this.parent = parent;
    }
}
