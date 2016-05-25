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
import lastgitcheck.app.server.repository.appbasicsetup.userrolemanagement.RolesRepository;
import lastgitcheck.app.shared.appbasicsetup.userrolemanagement.Roles;
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
import lastgitcheck.app.shared.appbasicsetup.userrolemanagement.RoleMenuBridge;
import lastgitcheck.app.shared.appbasicsetup.userrolemanagement.AppMenus;
import lastgitcheck.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws Exception {
        Roles roles = new Roles();
        roles.setRoleIcon("25DJ3MIv2kzngvPjukYzkUUqk2LMHx95AaYvXibEM8NHrWPRlt");
        roles.setRoleDescription("PS4v3QTzI9NwQnIdEW6xhmaETqMV1PNGQFT2Rz6f74ex8a2hHY");
        roles.setRoleName("j2kbeoUnn2N5UzOCwTaVPmxGdghqwCh9fZiGgbM3FMhxgZWiOo");
        roles.setRoleHelp("6TaOxx4SORu3Dyqd07VXIlX9hxhaV62A0EAVFrUwcOmiNA5huC");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsWrite(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setUiType("5vz");
        appmenus.setMenuTreeId("NjelOulsoabWAD98B6TQvLMswlCOOkTD9mOtTPsBqTxSBeVTWI");
        appmenus.setMenuLabel("NlbMZ5yOVm0XfxzdIPwh2TzeztCdXI1Brnk9T5k7HoR8jgfAVJ");
        appmenus.setAutoSave(true);
        appmenus.setMenuIcon("dkxUQVJCiMUNeK9H6IBlHhLXixyTfacM7oREvH2NaaAHn7q1iX");
        appmenus.setMenuHead(true);
        appmenus.setMenuCommands("bV62wdh1sv88q4CRyVZd5zff0Sd9mpt8WslLPSEgMPWYBBMHKL");
        appmenus.setAppType(2);
        appmenus.setMenuAccessRights(10);
        appmenus.setMenuAction("yq74uXaLDv0EnMOr81YcFOphQHZEJLRVAwKm7uQx8u9OWD59Wi");
        appmenus.setMenuDisplay(true);
        appmenus.setAppId("uJc7XyxWbNTcRNtXoCIayKm7EiNdN1eR5xc0iYTaZQKSeYLecc");
        appmenus.setRefObjectId("XysZfEYlOlfFEx4vnXiTleBLuFsPmHVtafYUetCtoXxabuLRDy");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsRead(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsExecute(true);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleIcon("JDXG0YzrfAIuOi5BmwgzR4RWK7sLzNdGpFZcCvfIvaNXed2uy3");
            roles.setRoleDescription("TjyTBA2b33iPgJQNtVygWDJrpzlwO8EnVmwS3BNDmN33ooG7hy");
            roles.setRoleName("jmyeBXRftUlF4ZrMivC9dZ2Y0A15lHXkOJSQMevQHNB6y3mEpK");
            roles.setVersionId(1);
            roles.setRoleHelp("CYnAWiA8XkopwAkNm54ia4uLxPi9gl17dz9nuRURDRwKL84xIL");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "EcVmJIaWOR6pxWodoldqxH2GhohOPExrU88NoOw4D9xfzBl27lrSQO2Gi4CzMsgzjlXNUFNrz2roSpS4qrwIEhZX7HavayJRgIJplsv8Xqkv6o8NLumzgS0kXAn0csixFqZI9TfTmQNUmu8la2o3nBYriW2qbG3OaQv5lCKUIfVergYFzh54W0nQL7KEClV2l6yubZg1EkMiMJWxIxwDRh3EgIGZMRbp4ntzd6DyRYV40zPg7uKWnTiJXYVWbnzwj"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "M6EAMwyTMPY2fPKWV7hA4LNmuN1cmVjgaCyXFAMcSe5pTC5TuKYLmVWJXyFrJ2acKHtd1aIMJuDUP4OzgdiotshiusxLlXngeFRH01rfMQgqg7URgJUalUs9Fq9IqoT895DzWyaHfHYwSYCb6LlckYZubPUthNR5uEKTMRoG89xXDQpMjlpTCgnZzSZJGI9UE1MEGZNtK7D9JSOqhcbRk28JVZobh0r9awGGIyTp5WBTUHOoIiUUeSiCFUugK4HvK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "J9py8YIq8YhLbGSN1ut6OwXCDKRcwp4zbgqIHJrUL4klilfrHIDxQM26G8tRaZYt5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "ivlq9EtkeKMRALQmbqBA8JElrLZHEpWFF16aFKOWWY3ysmwYhmqJbxxJokWFHLUae7lBRlWNLmO9IWfk1CkMh6V2I3SG6Wl3X0eUUQqHIvup9R8RwvhKGWPDLTPDrYqqLQNbDB1jxnjcbbAajyJ2C3r7NCrpuf155RVuEQ2mL1kgGqH9AzYjauLYEhD4i9hZVWcgFvkXpCGttSD2RVpvZ2jVXW7k3spRUkHH027g0J3Bsd0X0MaeQLZQssBwJgF7z"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
