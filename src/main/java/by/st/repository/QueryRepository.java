package by.st.repository;

import by.st.model.Query;
import by.st.model.QueryType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {

    List<Query> findQueryByQueryType(QueryType queryType, Pageable pageable);

    @org.springframework.data.jpa.repository.Query("Select q from Query q join q.inputParams inp " +
            "where q.queryType.queryType = 46 and inp.nameParam = 'AgencyName' and inp.valueParam = :agencyName")
    List<Query> findZPProjectWithSpecialAgencyName(String agencyName, Pageable pageable);

    @EntityGraph(value = "query-params-entity-graph")
    Optional<Query> findQueryWithParamsByQueryId(Long queryId);
}
