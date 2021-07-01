package by.st.services.impl;

import by.st.model.QueryType;
import by.st.repository.QueryTypeRepository;
import by.st.services.QueryTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryTypeServiceImpl implements QueryTypeService {

    @Autowired
    private final QueryTypeRepository typeRepository;

    @Override
    public List<QueryType> getAll() {
        return typeRepository.findAll();
    }

    @Override
    public QueryType getQueryTypeInfo(int queryType) {
        return typeRepository.findById(queryType).orElse(null);
    }

    @Override
    @Transactional
    // TODO разобраться с EntityGraph
    // TODO hint
    public QueryType getQueryTypeAndParamsInfo(int queryType) {
        QueryType queryTypeInfo = typeRepository.findById(queryType).orElse(null);
        if (queryTypeInfo != null) {
            queryTypeInfo.getQueryTypesParams().iterator();
        }
        return queryTypeInfo;
    }
}
