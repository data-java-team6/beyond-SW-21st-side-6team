package com.team6.dva.repository;

import com.team6.dva.common.SearchCriteria;
import com.team6.dva.model.Concert;

import java.util.List;

public interface ConcertMapper {

    List<Concert> showSummaryInfo();

    List<Concert> showInfo(SearchCriteria searchCriteria);
}
