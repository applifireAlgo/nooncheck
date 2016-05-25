package lastgitcheck.app.server.service.appbasicsetup.usermanagement;
import lastgitcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import lastgitcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import lastgitcheck.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("VRPJqFKD8iNUNrUcFVhewEw5WeEMDuQEw4NjGhArk5wRIlYdNr");
        useraccessdomain.setDomainName("JUPq8nQVZzhlIU2SH9LSN1m3I6GGSiJYWCKX30ToSj1WpXhKXX");
        useraccessdomain.setDomainHelp("68HBduCf8twP4ERY1ySTTJ2znaQ8jAfYCodgFykL2SNirkJ7Ek");
        useraccessdomain.setDomainIcon("xgD85RqkfQ9sMobDsnv3EULOpXJAo2pDA2q9pLoQGJMiTKOQwC");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setVersionId(1);
            useraccessdomain.setUserAccessDomain(63959);
            useraccessdomain.setDomainDescription("LtpotcSWxMf3Za4WTXbD7LwP4cC8qElq4mf6mV2lGRo0mR4HvU");
            useraccessdomain.setDomainName("k8jiYzmj92rOcgMj6sMGbkBfThTuFtLJyUPE6i0krHcHkA0KHc");
            useraccessdomain.setDomainHelp("lZ19xozAsr3AwTRRlCxBUp4xFNxruhfAaXz4VUsKMyYqzR0Ugc");
            useraccessdomain.setDomainIcon("kFJpIiGRj6mLCJH14xGj7xBupwb475gbnGo3SUbGBIvIAiayRw");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 171797));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "JTvERz5kqo6KdP6C23XZa8Mbsdw8XbQ06OpViQwcXi8SLwkSw4TaV6TAmlEvpCnRWj4a6qEPi4GfTw6YNh2q2kcgUw7hWwu9bCPKpCCaSwMfRf8mU0iZRWRRjQ3GAGWNG3AdFE5GR9CPgygMEx2fIKzw0A83FHc21GnvYNCZ0RHneF3y47Z8LwfpvgRd1sfiZrcsqr96gnrXNf8UxxP6mtZN2u5NrT36NFzjdY0mWAiis550KDKcVTiOy0obd10BI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "mqm1yGhpO7gjMnXVwXwqfhcS4I54BQqlQXRJsWOQ3ZnrTDU5g3YXm1PT6aPjyPEVNvb2GkyWAgITw96gzevnfVCjga34XxRd5COkWS2KVu5vykcnaGVoVc6RhuSMKb5y1UQqjwAxYMa020GqZH7RYBAWF3QOgwHP3GFUI800XOf50hAK6Cz2PH2vCWx8Rw9rGuWW7mTokTUW1r2VdwXop4yW3L0C1fBVXe4ES974ziOHbaol6tn5R0Z6jqwMualnx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "znjsnRqg5wLjEVKDfnfiOogE9ZlxN110vngV7UZVFDD1EwLiWJ7b8N3K8DRzyph2Wx38vw9VbgdrInhJUO33uvvqSX5lcDQNMF39PTMeX13kZ5iHBCihOt8YcOMUZnGvCB6wmyGixdUX846UYjz83sLfSTbQxiJEanVpIEWyEzeml81HoB1UyX2BMWz71kk3Y7sFDWq4ed6qL86qIG8hTNCUWsbOX1dS91tHHWYUfePEglF9W2xTzQXvgI7MJy5xh"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
