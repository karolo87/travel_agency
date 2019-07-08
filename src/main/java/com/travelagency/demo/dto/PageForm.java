package com.travelagency.demo.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PageForm {

    private Integer page;
    private Integer size;
    private Sort.Direction sortOrder;
    private String sortField;
}
