package com.microlistics.wms.masterData.data.entities;

import io.onebyone.quarkus.microservices.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

@Entity
@Table(name = "sample_parent")
public class SampleParent extends BaseEntity {
    private static final Logger log = Logger.getLogger(SampleParent.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String description;

    public SampleParent() {}

    public SampleParent(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String getId() {
        return id + "";
    }

    @Override
    public void setId(String id) {

        // this is optional
        try {
            this.id = StringUtils.isNotBlank(id) ? Long.parseLong(id) : null;
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
    }
}
