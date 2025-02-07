package com.microlistics.wms.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.onebyone.quarkus.microservices.common.entity.BaseEntity;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseDto<Entity, Id> implements io.onebyone.quarkus.microservices.common.v2.dto.BaseDto<Entity, Id> {
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty("updated_at")
    private ZonedDateTime updatedAt;
    @JsonProperty("updated_by")
    private String updatedBy;
    @JsonProperty("deleted_at")
    private ZonedDateTime deletedAt;
    @JsonProperty("deleted_by")
    private String deletedBy;

    public BaseDto() {
    }

    public BaseDto(ZonedDateTime createdAt, String createdBy, ZonedDateTime updatedAt,
                   String updatedBy, ZonedDateTime deletedAt, String deletedBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.deletedAt = deletedAt;
        this.deletedBy = deletedBy;
    }

    public BaseDto(BaseEntity entity) {
        this(entity.getCreatedAt(), entity.getCreatedBy(),
            entity.getUpdatedAt(), entity.getUpdatedBy(),
            entity.getDeletedAt(), entity.getDeletedBy());
    }

    public abstract Id getId();

    public abstract void setId(Id id);

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public ZonedDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(ZonedDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }
}
