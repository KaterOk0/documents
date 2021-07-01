package by.st.services.impl;

import by.st.model.Query;
import by.st.model.QueryType;
import by.st.repository.QueryRepository;
import by.st.services.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {

    private final QueryRepository repository;

    @Override
    public List<Query> getAll(Pageable pageable) {
        Page<Query> all = repository.findAll(pageable);
        return all.toList();
    }

    @Override
    public List<Query> getByQueryTypeSortedByDate(int queryType, Pageable pageable) {
        QueryType queryType1 = new QueryType();
        queryType1.setQueryType(queryType);
        return repository.findQueryByQueryType(queryType1, pageable);
    }

    @Override
    public List<Query> getZPProjectWithSpecialAgencyName(String agencyName, Pageable pageable) {
        return repository.findZPProjectWithSpecialAgencyName(agencyName, pageable);
    }
}
