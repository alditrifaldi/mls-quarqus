package com.microlistics.wms.masterData.dto;

import com.microlistics.wms.base.BaseDto;
import com.microlistics.wms.masterData.data.entities.SampleParent;

public class SampleParentDto extends BaseDto<SampleParent, Long> {
    public Long id;
    public String name;
    public String description;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long aLong) {
        this.id = aLong;
    }
}
