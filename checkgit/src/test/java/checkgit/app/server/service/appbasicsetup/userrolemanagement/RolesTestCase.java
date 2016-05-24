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
import checkgit.app.server.repository.appbasicsetup.userrolemanagement.RolesRepository;
import checkgit.app.shared.appbasicsetup.userrolemanagement.Roles;
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
import checkgit.app.shared.appbasicsetup.userrolemanagement.RoleMenuBridge;
import checkgit.app.shared.appbasicsetup.userrolemanagement.AppMenus;
import checkgit.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;

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
        roles.setRoleHelp("i5va3nqcqYMv2g0hogHrEl8ft5Ghci6WeRikO2YimTccBixeZQ");
        roles.setRoleIcon("gS1qYNo6aQstCWVeD5ApDkaotaohxKyldVV86BXkQCgTBQI5k7");
        roles.setRoleName("rMi77m3H5v74rs04yjpqRVU5occ5gxjZf6YbyMTybhswDhg1q1");
        roles.setRoleDescription("XEZErDcrNf7lVGMDCxMtgZWpzm7jaMNzvidNZUiWLeQ0wEKigt");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuHead(true);
        appmenus.setAutoSave(true);
        appmenus.setMenuLabel("7BkMMo2RhzgPe0qdZsSBEmFEevzp0PN9YZ8UW60GAUNsnQPJEm");
        appmenus.setAppType(1);
        appmenus.setMenuAction("Maf9kFJg2wsWfxQlz7iqSxJRpTo6zTTHRd5sDrsU9QK7G3XgtB");
        appmenus.setMenuAccessRights(8);
        appmenus.setMenuCommands("0wjhGDYxk1E1zFgJybsVg7IT7EEjscFFnfaOKdsM5ztLli1PbB");
        appmenus.setMenuIcon("sS3O859weCuusYLW5c6uicp9fpdI0noTO3yF1uTpujimSIKRvH");
        appmenus.setUiType("6XW");
        appmenus.setRefObjectId("emf3zysXzWLgAkJalNefSIP5DvUiyJNye9HixdE2jLvfjRbTXX");
        appmenus.setAppId("Ol3LflEsp2Y0JOmp2U88gZ4Pjj7ASQCRBKYofoY76T08FSCkuU");
        appmenus.setMenuTreeId("nv9a9qDRc8S4kx15HLELhQLxDjYxUrEvQ3aSGe7fBivbCuKmOq");
        appmenus.setMenuDisplay(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsWrite(true);
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
            roles.setRoleHelp("vmBWwXrD8tKTc87mKjRKJFl8499nyqsqHFhGHRZva6dpSAqun5");
            roles.setRoleIcon("PYQEA06Mj0PFIxTwXJiKDlEoxEalVRi7L9rcXsPQKbHSMB4a9r");
            roles.setRoleName("gx4l9TGZuiEP8nhbqi6XHVmqoesATxqvS2Bz1T29Am6Iggf8S2");
            roles.setVersionId(1);
            roles.setRoleDescription("yzdFKJGzacB21QMWQ7ELqsPoBommLD7lpUk91ffKUPwYA6t9Of");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "LZ1ApXKx6JoiqafBZll6fa4idMbFl8rfHtvhHUyHdFNVzRotsd4L3ypIyfszwPT3ZjR5BqRCaDiYnTbPoR5SrpvP8VyaK2cbWNpZtzwgUbpYEfOkXZk7Owv29xCVesgBDevOcIc8A4D904POGuvh4nmnudkrmhf9bckIyU7Qw6qbVbszzIhjqV4nNlCCPNqtYBKjkLl4snIxB8qI7tvWQ54pGfFfFhytY723Vutj78YniaOiZTPdMsMzmws3E4Wnm"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "s9YNyeuyF1Wc7XckWlxgBReuqXbg0SgjslTgEGtswZ2d9Vr550XcwKBvRahGNE2AaCoeRjXDXG5hwqXDqIcayalCp9zmToRTuW9Biu1O2L3aSX97Vu5QeaxMYhpt3RUdWYDTIus9F3G02HAee7o6jKdofdsngAkVeOOkj11YQOrdcjstrL9IMGHM1LyeaCxUQmK4c4YI204OLlQDLGcU8ckUMtPul4wsxM8vYwn3lqInmtT1m8oIbDljlmKiyP6Nz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "6W4izftfy9TsSt7S8KucHPIT5RkpoMC8qA6bENZoIth2GzsBs146bbGSc0TKA3ciT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "RPhbqIu5HDMk0yvs3tyePpBPAsP3ruDPbkp4x3Et5AldwwUISHzwU4zUPNDYmhYCKzgVUT0u7zENcGvkgXBbQuCiNAAQTxbpfvHkaSaeXYDfJTyuM692qOA0z5xLG2Y8K43NKuOlBbn1XM5pwacmvMVchi1hfftXVDEVSiX7kuOS1YYjy8BVHRxq7rHLOtuExQrHLWJjBvjxYKRE11FALDli3YD2KtuvYX5dEmJ1uSuMQFNX3P8MIpb9M9AlWpvE8"));
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
