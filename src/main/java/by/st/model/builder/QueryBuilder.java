package by.st.model.builder;

import by.st.model.Query;
import by.st.model.QueryInputParam;
import by.st.model.QueryType;

import java.util.Date;
import java.util.Set;

public final class QueryBuilder {
    Set<QueryInputParam> inputParams;
    private Long queryId;
    private int lastStatus;
    private QueryType queryType;
    private Date queryDate;

    private QueryBuilder() {
    }

    public static QueryBuilder aQuery() {
        return new QueryBuilder();
    }

    public QueryBuilder withQueryId(Long queryId) {
        this.queryId = queryId;
        return this;
    }

    public QueryBuilder withLastStatus(int lastStatus) {
        this.lastStatus = lastStatus;
        return this;
    }

    public QueryBuilder withQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

    public QueryBuilder withQueryDate(Date queryDate) {
        this.queryDate = queryDate;
        return this;
    }

    public QueryBuilder withInputParams(Set<QueryInputParam> inputParams) {
        this.inputParams = inputParams;
        return this;
    }

    public Query build() {
        Query query = new Query();
        query.setQueryId(queryId);
        query.setLastStatus(lastStatus);
        query.setQueryType(queryType);
        query.setQueryDate(queryDate);
        query.setInputParams(inputParams);
        return query;
    }
}
