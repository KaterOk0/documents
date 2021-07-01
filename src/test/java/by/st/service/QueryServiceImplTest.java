package by.st.service;

import by.st.config.TestDataBaseConfig;
import by.st.model.Query;
import by.st.model.QueryInputParam;
import by.st.model.builder.QueryBuilder;
import by.st.model.builder.QueryInputParamBuilder;
import by.st.services.QueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
public class QueryServiceImplTest {
    @Autowired
    private QueryService service;

    // TODO а как динамически проверять параметры сортировки?
    final Pageable firstPageWithTwoElements = PageRequest.of(0, 10,
            Sort.by("queryDate").descending().and(Sort.by("queryId")));

    @Test
    public void getAllTest() {
        long startTime = System.nanoTime();
        List<Query> all = service.getAll(firstPageWithTwoElements);
        assertEquals(10, all.size());
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);
    }

    @Test
    public void getByQueryTypeSortedByDateTest() {
        long startTime = System.nanoTime();
        List<Query> all = service.getByQueryTypeSortedByDate(158, firstPageWithTwoElements);
        assertEquals(10, all.size());
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);
    }

    @Test
    public void getByAgencyNameTest() {
        long startTime = System.nanoTime();
        List<Query> all = service.getZPProjectWithSpecialAgencyName("МОСКОВСКИЙ РАЙОННЫЙ ОТДЕЛ ФСЗН Г.МИНСКА", firstPageWithTwoElements);
        assertEquals(5, all.size());
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);
    }

    @Test
    @Rollback // reduntant, it's by default
    @Transactional
    public void deleteQueryTest() {
        service.deleteQuery(234208);
        assertNull(service.getQueryRecord(234208));
    }

    @Test
    @Rollback
    @Transactional
    public void updateQueryTest() {
        QueryInputParam param1 = QueryInputParamBuilder.aQueryInputParam()
                .withQueryId(276565L)
                .withNumParam(1L)
                .withNameParam("Num")
                .withValueParam("71") // не меняли
                .withNcycle(0)
                .build();

        QueryInputParam param2 = QueryInputParamBuilder.aQueryInputParam()
                .withQueryId(276565L)
                .withNumParam(2L)
                .withNameParam("Message")
                .withValueParam("Сообщение и его текст, текстовка сообщения")
                .withNcycle(0)
                .build();

        QueryInputParam param3 = QueryInputParamBuilder.aQueryInputParam()
                .withQueryId(276565L)
                .withNumParam(3L)
                .withNameParam("_IDReg")
                .withValueParam("268498") // не меняли
                .withNcycle(0)
                .build();

        QueryInputParam param4 = QueryInputParamBuilder.aQueryInputParam()
                .withQueryId(276565L)
                .withNumParam(4L)
                .withNameParam("IsABSQuery")
                .withValueParam("1") // поменяли, что документ из сторонней системы
                .withNcycle(0)
                .build();

        Query queryForUpdate = QueryBuilder.aQuery()
                .withQueryId(276565L)
                .withLastStatus(17)
                .withQueryDate(new Date())
                .withInputParams(Set.of(param1, param2, param3, param4))
                .build();

        service.updateQuery(queryForUpdate);
    }
}
