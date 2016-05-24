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
import checkgit.app.server.repository.organization.locationmanagement.CityRepository;
import checkgit.app.shared.organization.locationmanagement.City;
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
import checkgit.app.shared.organization.locationmanagement.Country;
import checkgit.app.server.repository.organization.locationmanagement.CountryRepository;
import checkgit.app.shared.organization.locationmanagement.State;
import checkgit.app.server.repository.organization.locationmanagement.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase extends EntityTestCriteria {

    @Autowired
    private CityRepository<City> cityRepository;

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

    private City createCity(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCountryFlag("XlbfofEY0uCM44JGuuY4hrCoQCo4pySEckqYJTnl33g9zaneZW");
        country.setCapitalLongitude(2);
        country.setCountryName("y7NRMuBbDKmAMtseLB1c3qJgKzaa5JFYjmBwAB860MpZyzTszp");
        country.setIsoNumeric(814);
        country.setCurrencyCode("7jG");
        country.setCurrencyName("fQ4xRQtlTuVsUUwwoLPAkFtknlRXk5aUCc1QDruf8BLsRdkzjm");
        country.setCapitalLatitude(2);
        country.setCurrencySymbol("v7zNpBFMHy2GY0wDpGLMsr1QXdLq7F2K");
        country.setCountryCode1("w2o");
        country.setCapital("Ftithfxq5X6AyIacAKABJnGzGDcI7u0B");
        country.setCountryCode2("sUl");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("DPa43ibp28PnAptpxhi0noxtbU7UKLpqWWjw3roraVZ0oplqBm");
        state.setStateCapitalLongitude(6);
        state.setStateFlag("Q0HPeIl4sqI6CmpHEBG68b4wDqEn9sE17MSKYJjy5AFCMi89KU");
        state.setStateCodeChar2("CMBIvMBd0s0Y4tZRe6SfpnKINjHjA6Jz");
        state.setStateCapitalLatitude(3);
        state.setStateCode(1);
        state.setStateCodeChar3("yLDqGQnzsNZB5qTRX8LEkwAuke2K5nXq");
        state.setStateDescription("qFfCtGeY814dwvP6W4DJJlTJD0iUwdVOjfb9bjpHBmw1b8iDTJ");
        state.setStateCapital("tF5j2oTqnSSXjh5CWVOtkT7LYgunxap4DltcX0uBtSYOrrjQpB");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("eDzMBOAManRYOeHEoX842OG4pbX7kVKNAMnOnODW5pMfi8aRCG");
        city.setCityDescription("o5RUxfvjZxoSy2Z6wEGIdozccyRYu5VgCuoFys9J0nuGKuCzCX");
        city.setCityCode(3);
        city.setCityFlag("3tQc8oru7G0YMAj6toVMW363vunMOCwY38BrRo26j0cmKcvsjq");
        city.setStateId((java.lang.String) StateTest._getPrimarykey());
        city.setCityLongitude(5);
        city.setCityLatitude(3);
        city.setCityCodeChar2("NshL1LrUO5CL4KVsQwqAjp5eDCQZhkcK");
        city.setEntityValidator(entityValidator);
        return city;
    }

    @Test
    public void test1Save() {
        try {
            City city = createCity(true);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityName("K4nP9JmwJQ1XhQOMfOmRlBEPIEtSeHL8kooESwgL8jAgOuljJO");
            city.setCityDescription("0gikKXUUUjt2bQ7KBFQcEqFx20dZ9w1xcct1cCAQxLomvBE1CW");
            city.setCityCode(3);
            city.setVersionId(1);
            city.setCityFlag("AANRBUkkolQeqGYaMrdMZmazVGRrl85DhPPxgE2ebESwJvvGvy");
            city.setCityLongitude(5);
            city.setCityLatitude(11);
            city.setCityCodeChar2("JAlsiCIC8XvuRRTOC5hOysWudfgcJO6J");
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCity(EntityTestCriteria contraints, City city) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            city.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            city.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            city.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            cityRepository.save(city);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "gptvoBZl9udyTxFOc3BO1AVT1Z4eZB9VzMNf0EeYIAQ0fWERAphQNFyiMdNzrn4r13GKsRt6bQzzFZCeZQemOP7TrQOjFddm6LWizGh4XXTl0FJ2uIf0NUtxsalWIXUmLxWTv9xkx4Piw3pMQVbId9t38EdMPzvQL3UmSBRV9lUDDHA9ujIhQAHGwrm5KvILKk9FOmEI2Dl4AzNx1kIZaUIk8l8MnrdCYvJmFQWC9tmaOaZjmAKUwruij2afvQ6GS"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "oX5TEO20hAgrKyTNkaqQVCAVDWAgFdNlO"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 6));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "w8Jsi37ULyH0plxHsppImkGWaBmMISLY3z5FFXPGIMNgv3ZbToMunGwczAutA5Oadhh9llLShnTw2PTPxP2iB9Hx8MLAT4ztjoBGUcNk5tzh30RPdoOGSPllvHpBYt12e"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "aqlMYA4K27fkUCm4pXlegpRD7yd2ufg4x3IvV5yO2fcTgBHBEG9x3Ayuof0no198PAnZqWNorlCcFFoGgOANTfERgKX6ldfsFCIuNRa8r1HYreIvBep4GIajZ1yiSmQHx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 14));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                City city = createCity(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = city.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 2:
                        city.setCityName(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 4:
                        city.setCityCodeChar2(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 6:
                        city.setCityCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 7:
                        city.setCityDescription(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 8:
                        city.setCityFlag(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 9:
                        city.setCityLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 10:
                        city.setCityLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
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
