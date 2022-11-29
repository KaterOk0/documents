package by.st.services.impl;

import by.st.model.Query;
import by.st.model.QueryInputParam;
import by.st.model.QueryType;
import by.st.model.id.QueryInputParamId;
import by.st.repository.QueryInputParamsRepository;
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

    private final QueryRepository queryRepository;
    private final QueryInputParamsRepository paramsRepository;

    @Override
    public List<Query> getAll(Pageable pageable) {
        Page<Query> all = queryRepository.findAll(pageable);
        return all.toList();
    }

    @Override
    public Query getQueryRecord(long id) {
        return queryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Query> getByQueryTypeSortedByDate(int queryType, Pageable pageable) {
        QueryType queryType1 = new QueryType();
        queryType1.setQueryType(queryType);
        return queryRepository.findQueryByQueryType(queryType1, pageable);
    }

    @Override
    public List<Query> getZPProjectWithSpecialAgencyName(String agencyName, Pageable pageable) {
        return queryRepository.findZPProjectWithSpecialAgencyName(agencyName, pageable);
    }

    @Override
    public void deleteQuery(long queryId) {
        queryRepository.deleteById(queryId);
    }

    @Override
    public void updateQuery(Query query) {
        paramsRepository.saveAll(query.getInputParams());
        queryRepository.save(query);
    }

    @Override
    public long saveQuery(Query query) {
        Query savedQuery = queryRepository.save(query);
        int i = 1;
        for (QueryInputParam param : query.getInputParams()) {
            param.setInputParamId(new QueryInputParamId(savedQuery.getQueryId(), i++));
        }
        paramsRepository.saveAll(query.getInputParams());
        return savedQuery.getQueryId();
    }

}
