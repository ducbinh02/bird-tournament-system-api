package com.swp.doannc.dto;

import com.swp.doannc.model.SortBy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchUserRequest {
    private  String keyword;
    private int pageNum;

    private int pageSize;

    // name, email, etc
    private String order;

    // ascending, descending
    private SortBy sort;
}
