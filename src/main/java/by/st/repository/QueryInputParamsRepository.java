package by.st.repository;

import by.st.model.QueryInputParam;
import by.st.model.id.QueryInputParamId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryInputParamsRepository extends JpaRepository<QueryInputParam, QueryInputParamId> {
}
