package by.st.services;

import by.st.model.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryService {

    List<Query> getAll(Pageable pageable);

    Query getQueryRecord(long id, int withParams);

    List<Query> getByQueryTypeSortedByDate(int queryType, Pageable pageable);

    /**
     * Найти все 46ые документы с заданным параметром AgencyName
     * Наименование органа Фонда, согласовавшего справку
     *
     * @return список
     */
    List<Query> getZPProjectWithSpecialAgencyName(String agencyName, Pageable pageable);

    void deleteQuery(long queryId);

    void updateQuery(Query query);

    // TODO статистика по месяцам сколько за каждый месяц создано допустим 9ок

    long saveQuery(Query query);
}
