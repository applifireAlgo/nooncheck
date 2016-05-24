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
import checkgit.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import checkgit.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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
        useraccesslevel.setLevelHelp("fIYIYxLmi8xHnnueVKIcJqGef6PVZ7xGs7iinvFDQVOKAOg1oo");
        useraccesslevel.setLevelIcon("HqcrI0NP73qCWp2ZnkYWUkkYZ3lAqzBkmAbhEL6QzF2aFcMctd");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("3BEUAjU6QshFaQ6fCxr1AfPH8v9qtmXvIPosj0nJh2dFZsn737");
        useraccesslevel.setLevelDescription("xzv2Sdn6yo0Itm1zkJ1DStQVa49wzWCOkIIhNklYzuVkQYc4Mr");
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
            useraccesslevel.setLevelHelp("VpLI0XFRJ9brzJDSIN9MMX0Qu4TmvrH3GkQIJKHk0PYK2fZWwy");
            useraccesslevel.setLevelIcon("rLMskN8AgNqQokM56joxaKyO2TgDqBFciK1E8HOuhqyAy8KDHC");
            useraccesslevel.setUserAccessLevel(11317);
            useraccesslevel.setLevelName("IiDGYTXFmlISSxUrVSssYi8FqoJkUz7fJgLynsy8cw7NQxkQQD");
            useraccesslevel.setLevelDescription("Figao4UkbaSmyyuL67auxY3PvWFzSkcbp1zX3TLhLH50pInoS2");
            useraccesslevel.setVersionId(1);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 155688));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "YZekajSBzLW1PBk30hRlOTqWyMtDG4kpaR28jX9jnoTroqbkEmUEFEEBKikFTPRFkYgcPn4MrFCQ9L7Gnz0Gj1Q6GMZX6ORFwt0gUuMyylzr3PPSsgtaeVVHjD89s4d7zm4rayGy0vEeOfn6z1GkSA8hUTXd7m7cQgVjl7mQgnkNn8he1gdIXVkzyl58ILebj9YWVvdgQmnP8MR96hKah1PDEBceegNJ4BoNsm2EbQRoZUVuBsGPEzbeZXvxdoKY2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "bAScHjvoypUPdzRndgU6qgoUt7laH5UCnfjZuoSKwkEu7qtBZaapn7Q9kYDIAn1xj9x5SqQsN4CRZg5UCgXNeef7uq1XCnAb1EMeioJZ2ZOiEUijQM0sEA7kwThfdbtpTpyY4CCqdTBnRdLZF7qCc9D1EgSCU8gCjB0pP4ZuWTFYVxarNuRR7McYcfEQnYur7DU9dDV4fcQFD6rCp9tMIoXGl4O2yQuosQa3cIJTGQhVGpbuLGZPUzHa3xWV8JhAU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "NDx66FwCsYO6pzLDOr5JMulw623ohMDJQToXfp3bsFzgAuWbHRmwHs4OXWxWUHuUHGL8lPFpKLqhdhxJPTjAyoqFVKEEp3IyVvsrrtQorM5cL422IPeD4JexojKa9qmr3XwRq3Rv7YTCMZS8EiVT2wPCQ7eX2rn4rvEb47wqZny9tb9zr8ytREApQ5AC7LR57qaA4KOE7pBkwoSdPDlHtj4gVL9TX6wy15EJjfJM3FZwzwgyis0OoBKjWhjas1dgqjmqumTPq8UKs1kduWHj6rsDWiVhOBYlb32WyKf0FIdTlOd837gEFl73KK9LidNoK94SKrS1Q9pXcgUPpwnqpDdvuXFfttLeLjIVtY1x9RqdAeiI5GMYvBtAtfZtzACgblxkwsJY5Cm0mGmvjI5lR0ZAfrDVrNN93J85V1ZiIjJdqHp8loxs0zG8K9jGeizvnGrjI4cug5fnwQGqiMt8dBq2fhDQM01dN6DvHEowa9L0XhwVtav2WCpRooik5kjbtrbYbmf1ZVS1MVFTUvOcD3kgvkwHawpTGqFv3bM2BlE4U58IDNyXpLL3Pd0JCRslNPkYOBbhqbi3DIl8nujur8u0L80BFGrs49iyiYVOpcjOD0366fk22DCkdziskLXAPKbdn3suSX7VlvAe4s1mcLmejYPlhFHOdIfpdxXFDNHpUlViEhnypWqsgCF1lLMHE04gipyz0stoS8qEDgKRmNNDhZFFzu7SsG2KwuqolurNcRBGdwqmSnrxglqpXoIWVSBcayIWcRh16nBQyM5G7KJjTIYCNsJLJqzoScfNl6tkwqs3xJD21t0r9HnBc3nkSCQD5XMvwDjbmZmX0LocIZ9IA7P7zHyDGHescdktL2Pqe4uSuNjr8HgByDaz8vJyjQjXHwOrUs5pO2v0p0mwRsk80pOXsAwOlyxFTJbp9ZfdZqX3FASsSwQpBPZ4HokPiCSY06oaRxJB8hISV5HC6x7fL3FPs2dGKRx4TTY40ghHicr7QUF6zKvgY0cpIhkcKGgrRkIUI193bf6UwtzXPqL8ChjXXXypMaABvNkGujLPTc5HHazA8e9vwv9aJjO9aphrqy103HtjXG1A8LU0a02DhrmKFclvLBGzCvNGFDWnbzgODwTuRLbC73Vwuj05qh3qr6tviMMii3zTsUGsMKcyK1xvmm8jrfyJj7PzOZUCDo4n6HK59v3Gx9KQQFeD8fJtfiaZaIm0y7dAezgv3bD0p93UvfX9B4OXdfJPDVrNoXVeMtIQTrUqYdWNze15d4ZRgx9ZTlVylTYooOU2lAY7oTxeMkXovJACLA6kK7Ga2N4g5Anjew2ep24CTbdgZqpTQIQiXi6MXmG2t0KAbfQpGKrKvQCDxjUVd2kB8vj0FTBAgTTZeodjOEQfocK3KK3lR3N9n7hLrOsCJUiRXJvMd8ds3QkydimPn5hQOH8kdg2wXDLxtcL4VG2bZ8oJex2QtjqidvY7Mah1CS1R9HRwpqX9Q97WPlxnAGfpu7toQKXv634IFAYUPI8vmYdvQhct09VWrWwgBxJqcYv2vFXBrPxFwdHuCprpmTlZbmsXMGVq8UGnK0rWvyjd1lM7G1blrA16Xy9cgJfjvS44ZLFkFpmErTF2cdyeP0sPe8gAYNm4EoVm2Aa2BWlEfgvgow6MdUWEZ20T6Rm7PSpZgLZUDxY4LCnp9aHVff08135iGz0qYy2ZSgNZdouZSLOzvL1zrcCZA9AEwUDh70S8evFNb6P51pE6ScWgemLr94n0QxWitzDOeo6IVF6ZMtk6Ht253JUAmcEz6RCHApZXrNnIZWcNvZK8DYX8XwG87BF4xaG7yS0o89u0ApfPf9DQKSJ2U5wSHGgshnoCrvYd5YgO087drwn22Z06UJVUYAznZzKUlSX3JGjc3oa3DBZK8dKcS50K72GOqYYwiAbU7quKYtaAc3b0dxPz710EQn9eotQFYVIqLHraeJ1kyEkBvvpZO7QW9IaljTpnylpjfjlLtqJCm70rO19mhtRXfe1qEIqJfvKL29nmpE55tvyZX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "MBIY3QLJmsrEbGxwWSAZKml0s0ShIN6qWwD0PXW3u5lwZTp2LZVKfRbLhm6ujenNPy64HnUrOBu8qewMhkj8J3dtZupXhaprzcbKtCzebGOKxByMZrUe8THgATcLT0iI6kNcbFFktdsP5X03cVaq1imW8DYqhbFmW2pXtE36uKIA7QDFghYk4vV8VF2RSeU7R4CALKn6r4x9T1tkNVQHwhyxutPDS88lo4Pj38DYvbfew2ktEdpkE7Fzjj54QV38u"));
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
