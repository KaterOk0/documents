package by.st.services;

import by.st.model.QueryType;

import java.util.List;

public interface QueryTypeService {

    List<QueryType> getAll();

    QueryType getQueryTypeInfo(int queryType);

    QueryType getQueryTypeAndParamsInfo(int queryType);

}
