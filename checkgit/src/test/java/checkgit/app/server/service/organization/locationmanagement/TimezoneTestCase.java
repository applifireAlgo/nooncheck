package checkgit.app.server.service.organization.locationmanagement;
import checkgit.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkgit.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkgit.app.server.repository.organization.locationmanagement.TimezoneRepository;
import checkgit.app.shared.organization.locationmanagement.Timezone;
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
public class TimezoneTestCase extends EntityTestCriteria {

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

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

    private Timezone createTimezone(Boolean isSave) throws Exception {
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("j6FqsUnL9BKHgtC4fZXWve4OVc4hjFaqd4f4ZNPAhAsXNJnTfe");
        timezone.setTimeZoneLabel("TQtSRiomS5BzTet8YGvPFbLCtOtaCtQ7TLAHZttOBmZzy7OSkJ");
        timezone.setUtcdifference(6);
        timezone.setCities("JYZ6WVhFauo5kAHvDxjxbGzJKrZkr5lICrQVvz9gXfU5eYP1nJ");
        timezone.setCountry("EWiUOQYoXR8hxTuBwSduzuFGVvc5vK4FFV6bLp6WiWjeGpp8mH");
        timezone.setEntityValidator(entityValidator);
        return timezone;
    }

    @Test
    public void test1Save() {
        try {
            Timezone timezone = createTimezone(true);
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            timezone.isValid();
            timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            Timezone timezone = timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
            timezone.setGmtLabel("4v6O392KwfJ5ZLbOUaE5pnQYjQIusFe1Am4jhKaN7xz4i6NmKG");
            timezone.setTimeZoneLabel("C0JimJENH6UDugIOj8rvsgMfdc9HMoZBrzfIm4h42Vzk9eIP4Q");
            timezone.setVersionId(1);
            timezone.setUtcdifference(1);
            timezone.setCities("oQQoJnBvU1GdQQcKlsYiGouuN1yWQdjk119NWsZNxHgkRwlyny");
            timezone.setCountry("zCnhtXTtc5FNVisMBycWSKYZ8PSxpIshE1l1OwW4wPYz1xPbl3");
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            timezoneRepository.update(timezone);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTimezone(EntityTestCriteria contraints, Timezone timezone) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            timezone.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            timezoneRepository.save(timezone);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "utcdifference", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 18));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "rHIjuaZ9TsRiDs2l30TYKNFTLHLWxyblS9YMsnz2pIFtPf4pbAbSQXKhW33g59yDRoTWbsf0dGh2ylMJtkum9rN1li14DkcJyVdpTHMQTybiOFHn4itIlL8oJYxumUHjeTJNadDBvSrcJutbUGic2qCgrb3BjveGq8OdwAUF6xZBhCzlGR1rVX1i3y9oqbgkIsQ1CyHpU3Zm8oEMaR2ShcKVTfXANTkAgR1IDTdllcP3Hqw2yzXhG2VQ0sD8JQF2B"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "3JKCXBrMQXfgRGDHZwa1c3mp5CiBgEOT7wsXqj4Uj2B66o3iZD4nS0RqBrTFqW2QWwl6sNuNLdbSZmrJ04ha3VmJdY0crX5HjJzhD4VVmAa6IJ9ysrssORZOkCSLyjuXOUHQfD9LtMmFTcYQTgEoVHYomHGYE9TKj8MX6hIDXxXZaCjtPOnJlXfGLTahzv4SET5JiMsKjL1Yhqnz2dGz3170LxJvDCJ4UM5qnVV1oYKaKjTttwmCTFE8hba5fGYrO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "93Vn6mNOL5VRGP0BnSlkrnH64iDkiisrNp56wFrfEenuCyoxbfhPIVttU00XwLuT24OtJsO9GuRbEYFBsUtoBlWsxlq9hBYenfr4s0OWf2aozbG562bWHcJ3B4cM00uIklPl6dHmZBCfcHlf5T1kl0NgU3pt2qYaHXKHeS5pKk9lZZ2ukOYHe8w1WfLVWccc6ZcXN8JuvTZa3JMLSi5CyMeNb5nyt00Yrs2ySJutATGKsJ0fpfHJGoynof5s6qUjW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "rjo2jlIu3qiVpgI9qYIFvEHLIBEGqKtRRlqyR1un6mf0tAq6pCQ2XpXxbWwcULeQR0nxntYNZtQwsNFA6EE3haBoFl8nXv6HIvp9RiDcazV85rCUiFbfWbTsLcA4tCQIMptkhxDhQ4iReR3Bo9ysMae0wMevUBkFK08NDpxKHaPWGQwFIqd7zpeoHiMl4JOdlFH8LjiIptrMHzen9lSNQJVzcgayngdumJmjtBocUNMyoxJ50Nandi6MYNmrhkJJ6"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Timezone timezone = createTimezone(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = timezone.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(timezone, null);
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 2:
                        timezone.setUtcdifference(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 3:
                        timezone.setGmtLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 4:
                        timezone.setTimeZoneLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 5:
                        timezone.setCountry(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 6:
                        timezone.setCities(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
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
