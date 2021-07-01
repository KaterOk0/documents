package by.st.model.builder;

import by.st.model.Query;
import by.st.model.QueryInputParam;
import by.st.model.id.QueryInputParamId;

public final class QueryInputParamBuilder {
    private Long queryId;
    private Long numParam;
    private String nameParam;
    private String valueParam;
    private int ncycle;
    private Query query;

    private QueryInputParamBuilder() {
    }

    public static QueryInputParamBuilder aQueryInputParam() {
        return new QueryInputParamBuilder();
    }


    public QueryInputParamBuilder withNumParam(Long numParam) {
        this.numParam = numParam;
        return this;
    }

    public QueryInputParamBuilder withQueryId(Long queryId) {
        this.queryId = queryId;
        return this;
    }

    public QueryInputParamBuilder withNameParam(String nameParam) {
        this.nameParam = nameParam;
        return this;
    }

    public QueryInputParamBuilder withValueParam(String valueParam) {
        this.valueParam = valueParam;
        return this;
    }

    public QueryInputParamBuilder withNcycle(int ncycle) {
        this.ncycle = ncycle;
        return this;
    }

    public QueryInputParamBuilder withQuery(Query query) {
        this.query = query;
        return this;
    }

    public QueryInputParam build() {
        QueryInputParam queryInputParam = new QueryInputParam();
        queryInputParam.setInputParamId(new QueryInputParamId(queryId, numParam));
        queryInputParam.setNameParam(nameParam);
        queryInputParam.setValueParam(valueParam);
        queryInputParam.setNcycle(ncycle);
        queryInputParam.setQuery(query);
        return queryInputParam;
    }
}
