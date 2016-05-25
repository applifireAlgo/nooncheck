package lastgitcheck.app.server.service.appbasicsetup.userrolemanagement;
import lastgitcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import lastgitcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import lastgitcheck.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import lastgitcheck.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setUiType("0dE");
        appmenus.setMenuTreeId("Y1l50HJ2cqbUsoYCzScoKQPtBn9No2bAZl6SC5YYsZyv8SRkgP");
        appmenus.setMenuLabel("x8gPtBqWjKFmkdXVEFnwAt3DBuydhPlxOTfTvphACYs21PsrAG");
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("tUwR0YHAIJ3h23fpfi0Gk81lPkCM1qVdvvqCqBMdumIZsNcKwq");
        appmenus.setMenuHead(true);
        appmenus.setMenuCommands("fX2rEVwmixupFORIPWLSl4zqHNO4ttAfYYYiVekqGJG0oELHiZ");
        appmenus.setAppType(2);
        appmenus.setMenuAccessRights(10);
        appmenus.setMenuAction("gKEdNhV3LcuqNzYmPEqDVuHyAtzEEJWmCF9C4p0l3kIMoCnNXJ");
        appmenus.setMenuDisplay(true);
        appmenus.setAppId("P9hYgGPp4432mo4qzUC6xvXcLEjX1LVvnIn0kWkhVQ3EONMfu7");
        appmenus.setRefObjectId("Jg7fuai4LwlKmjqIBoFTDG8JwqP7tjIa4tTi0ZY6gccwO4KqdX");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setUiType("m1Q");
            appmenus.setMenuTreeId("YrATsAoMFVtUSWf0BYMS2WtgvjpKxy3eYsb3DEcPur6JAihZ2e");
            appmenus.setMenuLabel("LCgQ2jSdfi5Q83a9ko6GLthYqzFeYy0ZDufPmnE2mx7BynTpht");
            appmenus.setMenuIcon("hEsFpeY0oHIXfnKMMM6JAetxovR8Xc91cF3hdUcSV2tAkpYqNW");
            appmenus.setVersionId(1);
            appmenus.setMenuCommands("6yBuyws1CLN2NHv9rwFsKKuuqIjcVNc42YP1b74o4lV4FDQsdV");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(1);
            appmenus.setMenuAction("NUbl1NihO4vXFi1YQczF1B3jv6d9nw1W6Zp8rCQ5SEvmCVzhbZ");
            appmenus.setAppId("oibByZ8fz0EHkIAQFBoSh2M3DDPUbAsJ9WcuoAVN0qN4vGtFLn");
            appmenus.setRefObjectId("P8757DLyQeGpZWhHURjDrftR4ValO93xUpSLzIo5yUwGK8urR9");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "dUVcGNd9Z5DuoJ5JQfd3KsuIWRLZEbl1ZyXks2UFbJRJWxhF0j0DpqwnQRtfZ0U8cIHmBOSgegJC8euGxsPqh4tQF0mciR8UYYOPHDlsdiKwTathoHc7kEe6NgCZ0GryCfv3vkCUROPqVJ4jLODwMwhad4iItXo6DC1Y1W9i4d5gg7TaWUf0LuHTwrNVrSkirfa386FgJpdS86QlXSjD6CEVEOEJ9Yt287jWGl2QQ7y5W7y4aru2YYYn4chDpMyYr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "TyervklQGnQ3VXX17rOyd98WJNJvjhZ51GJ42ZxECD953UedysdxKxMyV30QvIJUYzRAax4Ysx5YZepkwbjS5qp5ZmqdIUzCvWiPl2Nm3oEWRlNNSZlNMwigG9FaUV6M5q5bvSHHPZHKzGEze5jXnxhaHtiRWY0TQkSZcRCoHg2XumdcgsMYjXXnFSR1GPQ8n7OHjjMT4g0DXdPRDyOOg4TRwANboIOdtmgW48vhF16DnRpa6izMa89nbvFVF5GEy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "M1gzEglkOOFOoghAkTgObCO5nn3DelwDoRjZniN4981gqsURy59ST2BuL1Q6ba8Tp9WhIVfAjnkRdY5CjGy23hetMSqs1fdW6tCmrRQS178a5JQk7uCo7g7tbCdUo9bTMftcfPdpYSenLFOp2DUVKqrA2fS6x1EJ99hGivC3hE2yODEmfFbBkTNjmThgMOV2gPfhvJKfr9MisRDSrG46UEpTnysVbbUx38L9eTYsVBFPMm1kRxS1KGJ2Qm5BDhU7p"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "c6HZccJGyWbIEGq04G6iG4f70yL2yI90mIEscODprL3MtaDE9zCklDpXixvzn8pzx"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "n10S7QrkIVJWAPhixpOGwYgYVBzXvmLKkMc7uXt7MpRBNHgNMbWT4tKDqK2fXwLNfZwWbH5OhYJdMChVxycrarYiwnpwX8OGLti9mkvxGaJwOsYyEy2f8UTRo6LCdXJUbw3hIs0hLnPoFrM8vwqkkPKPeRmcu770YYI0ioYcoRfoXfB179WhHrUuyowqL093rphSZi0CKQxcguSxijseAbuMQ1PeWyUCRXraDIRRSfZDFit7YH3e9eXrsyVaWRZx8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "UFzm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "YDQQ31tfLqhgqtQt4DoKzDsj7N5oiTbZe7XqcPLLtErdZv5t3M1UPGDLsi4ZMM1XorNRGSWFMLLSc5g5eJ6c6kFHCnGJHAiJICxDlmSt2p3014AvOONKZql47QYGWUd5WH80Qw6jZN7vaAByccuoajO7S4U2Uu9TChvHTq3lt4ipkzu1xBIgbt6mlhek1vLqWb0NsV43vCwMSP4y9aEPdZUDQa0KrLLdYhUAUni2nbtA7kpmAL6P4VJXSVC8WsWQg"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "JZkJzqelo5wlovPrXGaszO5eTojIG3nyEPutevm2NyQbJf1h7UfV3OqGYmxLh1poU8W88T9B2tOUPDwzcpzX2y4vxTEhrVjVL1kVMHLAY8PW6YmIvf2lK97Qj7oZk7lDsa3cZSnGj50L8zfQFdGKMdCUTwpteySQhv8BvoRaK4F3jCPQXDyruZgQWWtPyXH9VCdfKedLNvqSfqUFcLI2bE7sOrNaWT6lqDgc3sjiD7itCfkRxmG1fArCbin9Jtj2O"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
