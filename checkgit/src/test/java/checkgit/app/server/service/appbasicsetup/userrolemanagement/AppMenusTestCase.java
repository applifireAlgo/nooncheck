package checkgit.app.server.service.appbasicsetup.userrolemanagement;
import checkgit.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkgit.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkgit.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import checkgit.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
        appmenus.setMenuHead(true);
        appmenus.setAutoSave(true);
        appmenus.setMenuLabel("4FCBBcvCT6aIzeS1nmvgME4jAcKxSq5aDojqLgIu7BItn9Ft0H");
        appmenus.setAppType(1);
        appmenus.setMenuAction("aHDHXk2XDDSnlvBDlkVZpLx4gauh8KO816KBMha2Xha4yGUMY4");
        appmenus.setMenuAccessRights(2);
        appmenus.setMenuCommands("Rl9KA7lrEbV98KwNTOVcMiCukgxC12ZTZR1UxgKt54ow5nYmQ8");
        appmenus.setMenuIcon("PWRxGS4ryeudopJ5DRRLNm8CDa42eEP6Ugbc4j2H3cuffFX7Ho");
        appmenus.setUiType("3NM");
        appmenus.setRefObjectId("Kia7GKr24o2Hq5lXj8vWRRADB0iWAkayV9gtmQ445TzRRJXjbq");
        appmenus.setAppId("J9O8M4G1WlShgpaXipLH8YT7WKIiF81awu9tgWQSUQu3kzkjYL");
        appmenus.setMenuTreeId("8sllNFYkkTLhhamobf4KxIoOz1M1dSm3hkbj8f42b1gqYgIF9i");
        appmenus.setMenuDisplay(true);
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
            appmenus.setMenuLabel("IxY2l6yinu9wxFRKuiekkNQirNuWn4hLg8RckYXtiCQW9bFD4y");
            appmenus.setAppType(2);
            appmenus.setMenuAction("707TiKi0c4POIN2AKzPQ5IPtsZTeZ1Gjp1wNHWfxozDfjzoJl7");
            appmenus.setMenuAccessRights(10);
            appmenus.setVersionId(1);
            appmenus.setMenuCommands("X7vOyyM10uwD79ScllWBfI156IWUT9BAL2FJIeWTWqJr31XxzO");
            appmenus.setMenuIcon("6nr9ehhQi3H0wWcd457oOD2zCvD993ErLiNmoHDXcjusiBtlll");
            appmenus.setUiType("ZRv");
            appmenus.setRefObjectId("4hXuWfDuegg4TURhW3twOo8eNupk70arogbm2EwNqCZAjgEBCa");
            appmenus.setAppId("BhfNSQmi9cBIfcMYDB1qJPTHDUdsXxDcSyGk9iaJDYETmLyOst");
            appmenus.setMenuTreeId("q629PlxojmdpN6qGsLJJ9rG1lX9EoXnbGrH3uQ9esPwpeHJYgG");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "wT1KJ1tvancBvaefi9V8aQKU4CiH08QJ5Cy0wHlJNPqHR2HGWpEINlYNwHHF44vk0ZQ2XCAFUyma1OCz0gGNgNygbPplXJTt24R8xoN86gKyj16OuWp1VilIrJidIqKJxxeFvEIWt1Okf5pba5ZIt5cNm6yMY2HybfPGlUTgRsSG2JmklQPF3NGNILZjdCHkD8zymNpc9aFgCoDN7DTmZN3Y4h44SODCAK6eBAwWeYr16cL0Segyoef6x6mtpKcb0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "a3AY94Sqc5yZU0JkInMZ0ElbsleAjPtFAqrgg2Rhqrb1TblrZKoMb6JUpoaHa3VQgVYBoUzH8GWCQKmrzRldSsRJDJAusBljUCaVjBlnRCXDZiGKPoIJmtLhXSgbC0u3SFyY7c10cGhR3ds4fEAnmKtGH3sp23KXHAMYJmvIujzwDCTnL8U7vWU0Zb2jphsc61b7A6eD5phrDiHVztJP5qP7iSZ5Q0RP9mawAXUoBWnv74NKWCvir0oyWZ4xlL3rG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "vuwi2hU42EAOFtPlF1rulQqmejHleoxTyuDpsFUMJo08UQSZge1WDtPGH6RFpKoqPOxSWWjGr54JGGlsdxA1KL54gQnNDFzmZniVVckkwJbrIaLHNh0UtFPK4NsuICI4WuKuWxbsobfu1tPj2c8NM93OL5s7AlAHXIDRdC15LZrqB9rWFdfUPhrRUmWWOmVf80IHsfanwepJ50HiQhiZfdPCJfX4Zznqi8aYquy9W5LLl9sTGZbQD31RcUFGQn3Qr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "d1cdjJd3b3HmNu7hQE1AdtiIAryOAqyP25EomkRwguXAs11D7YQB5dLF80pw28nqG"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "uPiAu87nJjiTA8aMX5jgK0c5cKFpLUeMeOrffK0wpOcgQOqoOBZoncg0ZwY123zjx4aDql2zXjY2N0raqqtp7fzb8REHzgLjMltm5B5w9Sd59B7x9imphsWZULzgmVM1d8RWqkcTqQJgRwuewQ4faFYXBsA2qcsKTcjUQ3TLOO02BXy7bBm56exKDfDe2wvnnDUYB7ggWXapacRJvXwntY5nT8xLa4x1ROLceOjVL6VNSR9dr1hrGT2oalEXWMMKk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "fVW5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "AiFvx6lnNQGnC7D0Tc68fHZjog3AxlmkzJvBuPpScDj7NJwFIRuSJdZD4Qnv5fHX5MqfSmH7SUygoxJ7r5pXmV2AQinnlsveLM4rucrVM6I5eI8D0BKfXoN9rBWaTeiKtVeHzYDpg98sKfw3rUEJKpr53xtIVeOUFoJtwn9DaYhCWLm9J0NJLBMSWpycHuB3UX2pxzRt9t8bpraAE6mjJjJ8XNSt1j3bSn8yM10vZ6uJym1lmc81QgiUWZOwtHHrE"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "eBxofumGtdeKzCKByuLgbFQnxj1BrVWk5WENBFjL9ujhElfCLbn5fEF9lCoJlt3QhQBrEGaELoThKoHKlpYajzXW7tIQ4zdA6wcYIDfnNM7ldFqE9JpkqB8cTLlChV7G7THXJR3OzXUu8mAmfousMwxs974Bj0Ifn1WRY8ykINAXegGAf1nEaMrgz0M0tYt84zAZyVMGpjUfwxDorRIb8NSm9pdi4nDnEucfoXoX6k6kuHn5ZtFuXVmJtaWPNTAj3"));
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
