package lastgitcheck.app.server.service.organization.locationmanagement;
import lastgitcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import lastgitcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import lastgitcheck.app.server.repository.organization.locationmanagement.NewEntityRepository;
import lastgitcheck.app.shared.organization.locationmanagement.NewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import lastgitcheck.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class NewEntityTestCase extends EntityTestCriteria {

    @Autowired
    private NewEntityRepository<NewEntity> newentityRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private NewEntity createNewEntity(Boolean isSave) throws Exception {
        NewEntity newentity = new NewEntity();
        newentity.setEntityname("PoiIImJe7F4zRUfsEkhfnGZxWtuCyCmsBkl8otxGXRec5ZscQm");
        newentity.setEntityValidator(entityValidator);
        return newentity;
    }

    @Test
    public void test1Save() {
        try {
            NewEntity newentity = createNewEntity(true);
            newentity.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            newentity.isValid();
            newentityRepository.save(newentity);
            map.put("NewEntityPrimaryKey", newentity._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("NewEntityPrimaryKey"));
            NewEntity newentity = newentityRepository.findById((java.lang.String) map.get("NewEntityPrimaryKey"));
            newentity.setEntityname("cdQVhcqivtjQjvFQFJm1V3EEG0h8Rg2zUAs1RVovqNwMHc7IGo");
            newentity.setVersionId(1);
            newentity.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            newentityRepository.update(newentity);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("NewEntityPrimaryKey"));
            newentityRepository.findById((java.lang.String) map.get("NewEntityPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("NewEntityPrimaryKey"));
            newentityRepository.delete((java.lang.String) map.get("NewEntityPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateNewEntity(EntityTestCriteria contraints, NewEntity newentity) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            newentity.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            newentity.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            newentity.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            newentityRepository.save(newentity);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "entityname", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "entityname", "eyKRcZ264qzmLWQlIUhxMxV6ZIvDdWNRBQskks0JPkxOdyiMlFDq7PaU7Pw4Mc5YzjiRDJc4myzuYUyEOlmreETpT5xO7Wujx6TqSsIwgZ6lK2G7EzYV1u8CHYj0enQw7SYJs0wWvUwBaGMy3NWmskaMh13kFutPMWYswE2GjYkFJccq9c4q0wofox4rhfxFRceZaRx9OXcuV7SV25N5K3WJXkJQ8qOdGRpsa3wmgIHTc6GAxwDFY5P20lXBwpcnE"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                NewEntity newentity = createNewEntity(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = newentity.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(newentity, null);
                        validateNewEntity(contraints, newentity);
                        failureCount++;
                        break;
                    case 2:
                        newentity.setEntityname(contraints.getNegativeValue().toString());
                        validateNewEntity(contraints, newentity);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
