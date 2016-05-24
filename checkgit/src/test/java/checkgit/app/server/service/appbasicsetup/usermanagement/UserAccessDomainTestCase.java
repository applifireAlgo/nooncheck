package checkgit.app.server.service.appbasicsetup.usermanagement;
import checkgit.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkgit.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkgit.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import checkgit.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import checkgit.app.server.service.RandomValueGenerator;
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
        useraccessdomain.setDomainDescription("aGxqaIj01cfuQXooExzoBiVNPArdgzcU6giVOsvvV0yH5uz57a");
        useraccessdomain.setDomainHelp("OpgpNCJTMjLlNyZNt2ARZhl5bjymjY1Ozqphl0mXQBMDZ5blhm");
        useraccessdomain.setDomainIcon("0AMbxG8QUyQYSd5EFT2fpRZdxkE9viABHDCCmem0aXdUgofKS8");
        useraccessdomain.setDomainName("qw3J8X7lyfnhJiZ2vB8l59aDdp631izZWQqzLd512wWYg55bm8");
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
            useraccessdomain.setUserAccessDomain(32271);
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainDescription("ivD5WxGT5id5kBJadXTwDzKkV9biKLUFO6DNiuAu81cUJjj2IQ");
            useraccessdomain.setDomainHelp("kEn9bi7un5YJxxUSmzqc6hSyIw4re1cKSB7eWRrJ9QIlwgboms");
            useraccessdomain.setDomainIcon("MjnrM2CTXoN8equ0fZtoq7JYJdgUeMhKAYqVSVYZcnb9LpNNKd");
            useraccessdomain.setDomainName("obNYdkRI7PO8MDxR1OvFosrSK97c58ln2QbGykCer9uc3sU7ue");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 180790));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "jKndqHXpdi4S8n6BdD0A63dcqHcnpVmai4Av9h53Ob5RW0obcPzgloc4e5qAHecZhl334W8WjmSJw9NE7XOcgVErJxG5PAcvQzAfVomlYDqB614gaJsZ0fhVAMuYps05bhKiWDOAPm95bRLSDw3BfcE6SlUIqgtabfBRPe1OJ59tz8ejhDhDeb0chBYIyueIbdN8DLfw7XNTCgYkYdbNohQ3kUF6XoLo0E33slNwGcnUnaYQBBCrPOWYzzwypPrfV"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "Iaid9JxXLMeoFSPbHVSazkkvuFiNdntNu0lAOqKi5tfE56DwIjFTSSX2hEIzozTN4B3AUDRTVaGvsz1V8jBy1uUvWoFmRF07o28NAePRsXTXfoVeSlrVeWVxiWtw9KQaMXPBKljrMYYeKIFAAxaInhvz3GEO8Baa9QAcKRS0uQEuevHgDJRaFfZQJQdWkdR4L0fzV5Fy8mtWud8PkVJTMhKtSKMXZ4gQHWt58Ps6SCdS5h1op3fd9yIr8ZutWk1pu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "2KDcgKIA4784lHos3s2TBw8dtJxWTBpmqXJglByqI7F9EcCdIh5OutA4prOG0Ban3tzqsPeJWSPSX43JY6UjEQsjsmKLkoRsQrCVYzVYK0nSndl2m1h9wMWF03YANHGDHgkdlacvVQzd6f6ht8KrJ2s6sOSFxkCisscy4pceWkkvn1IDIEbV0DWS9O7Itcoow4Y7cd1aGxElXXHyfPIRlFYs96yaca4zrGLRYjKWTgnmMWZKc4KgBb3bqglcjilBn"));
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
