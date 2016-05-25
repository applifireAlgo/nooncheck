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
import lastgitcheck.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("RF6LMqC2odmpLtOscKB2hTo8fqR4zwgg7e2xHxOSLVKkcPdyMt");
        useraccesslevel.setLevelDescription("4425rW5i1uKmX9DEIs83jBZjWO9vkfHUYgoIdvksxTLa7iL9UQ");
        useraccesslevel.setLevelName("E1wzJ50cgE2jw50OjleovC4MT9OMgMpmVt1hkASIcmuka07Hxg");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("qCqbHwKW5ym1e2faBUFo8cH0fmY8b0aedTwgBYt5f06SHiyeLu");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelHelp("MbuFq1JHrWEOyMPFRvkkKD8VRXeBCWZIbTQbahABfBZZTiwvu3");
            useraccesslevel.setLevelDescription("zfZjYi4mspL6V5NYuqf5JN8l2UtfjJ1Byclqu0nPQu3S4JQosk");
            useraccesslevel.setLevelName("UeB9zBV8eISpfldlS51VifmJIzPvuJnmWJutSjNzSiYX5Mv4LP");
            useraccesslevel.setUserAccessLevel(24968);
            useraccesslevel.setLevelIcon("hgywOyYpQmW4NRZXW6vzzRbWcGIT230a9A2ca95VEraNyKjPId");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 145864));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "BftEzZ4Ld0NGFlK7DfxM3v6Wz4ZHaKdv2hrokWfDfjICK1WuUFyBUnWu91r5A4KhjrLuOrFwvgJ3pKIWbDVt7CuGwS2X8QDbnESwmRDLL5d2BXC9kr0X6M1gPyMrpxKNP89fSfQLMfxFMg6M4DQHm2KNa1pfTWIqcHSPz1nicG9Qh5Kg0101sw3hHrIx5qGdf4I0UUB3eox6AP4nZkYBCVxbVWy9k3ELHKrx5C2DqlCThtwwBeWzhC1jF4Dei0opN"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "xJOzjOyPeU5zdrydqsicdvFzcbhQWKrI87Jz4hztVksERqkY5dTZX9p1mTqeqGahbhapyeHbs63VF0419G5Md4i03qRhZQutCeD13DwF5Ka9Uv1aQNRjyd3GQW2Xr12pgQLT9hxmwNJGhxqhBoeCbyv54bZnXoVmlRfVQXtjmmj3Og19MjHFRluu3Rbzqt7IHoHdFVG7uHKdztI9Z5s6RLKbGrEjRYCosAJ9xnl9Gckiqzae4FidHdsRVkAfBBI8U"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "OHwatKCBV6y4Y9l4URHHujL8ajecwn9BiTQh5fMOq2nOHoccYrsO3qWH7F5fXh4tLmC9Z4VLBfJYelA1Y33flBNwPDDHRDqHgk8I6BKSILqUtv10mVJy0986yT65zvS1GO0uBThZCPLI1evHBaq7jHERoZahTB44XgzU4CafTSm8zFYkPSAtHyMJBn2PyuPPJX31YQrJ0opfPYsqSeyTcZR2pqkAZDdyQTdVoM2hROeISC4TDkHDnDsTX8VFqN1NR"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
