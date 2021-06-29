package by.st.repository;

import by.st.config.TestDataBaseConfig;
import by.st.model.QueryType;
import by.st.services.QueryTypeService;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
public class QueryTypeServiceTest {

    @Autowired
    private QueryTypeService service;

    @Test
    public void getAllTest() {
        List<QueryType> all = service.getAll();
        assertNotNull(all);
        assertEquals(94, all.size());
    }

    @Test
    public void getQueryTypeInfoTest() {
        QueryType queryTypeInfo = service.getQueryTypeInfo(46);
        assertNotNull(queryTypeInfo);
        assertEquals("Список на зачисление", queryTypeInfo.getNameQuery());
    }

    @Test(expected = LazyInitializationException.class)
    public void getQueryTypeWithParamsTest_fail() {
        QueryType typeInfo = service.getQueryTypeInfo(46);
        // not transactional
        typeInfo.getQueryTypesParams().forEach(System.out::println);
    }

    @Test
    public void getQueryTypeWithParamsTest() {
        QueryType typeInfo = service.getQueryTypeAndParamsInfo(46);
        typeInfo.getQueryTypesParams().forEach(System.out::println);
    }
}
