package lastgitcheck.app.server.service.organization.locationmanagement;
import lastgitcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import lastgitcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import lastgitcheck.app.server.repository.organization.locationmanagement.CityRepository;
import lastgitcheck.app.shared.organization.locationmanagement.City;
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
import lastgitcheck.app.shared.organization.locationmanagement.State;
import lastgitcheck.app.server.repository.organization.locationmanagement.StateRepository;
import lastgitcheck.app.shared.organization.locationmanagement.Country;
import lastgitcheck.app.server.repository.organization.locationmanagement.CountryRepository;

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
        State state = new State();
        state.setStateFlag("V9Bcczd3iOlq9UV2142AVd6t9G04ViUWOA4qI5RNGkh7ujdSCz");
        state.setStateCapitalLongitude(4);
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar2("G9PTdKcdU2tFM4G1YTMjnuDKudMAsPLN");
        state.setStateCapital("huTWYQC4zKrgEu7dqaKJ3HP4Ek04YfIXZej1oiP3zmtUn8lKN3");
        state.setStateName("LUclGS2IZCGMvT8EWXpuHZ5Y5mmfHkBErTzX6ia3kuzMWYISt4");
        Country country = new Country();
        country.setCountryFlag("dNw1YKXQiVdbQgaBIths5k2BGajygOOLs91xY80RSqn1vAutP9");
        country.setCountryName("uPwSmLfBzraVWtcGHaM8EVTfFzvTo4bGQrgUxcIlF6g3ptdQjo");
        country.setCapital("SNB5FKU1a3ZKjYz79PXI5ZfmTXBOmAP4");
        country.setCurrencyName("YfxnCHUKEpj4NEKyigpxVHWKsVYKgCv5lKWOM1xKDHbDoDZ4Ga");
        country.setCurrencySymbol("YhUfP17tHoagymXNMdOXk3kNFL2viCRX");
        country.setCapitalLatitude(7);
        country.setCountryCode1("MUE");
        country.setIsoNumeric(366);
        country.setCurrencyCode("mAU");
        country.setCapitalLongitude(4);
        country.setCountryCode2("LO2");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateFlag("gt4X6UMPB1KyRnXWomfESv0CwgmuNJAOrFhhhSIPHNucAhzQiA");
        state.setStateCapitalLongitude(5);
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("EePqu6nEz9BmCYXAcpQsisbSMQX21w5f");
        state.setStateCapital("nUjgAgZsDWh7BbfZSI82RNPjSZgRBSOIxfiUBCZ1I3GNhtF4C4");
        state.setStateName("kZxVoTpIDGEUm7dG8tkJC98vzEHPV7xnWlr8lzpzq4uH2by0y3");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(1);
        state.setStateCodeChar3("SMqvQhWi0g5W0pQnOhocMS9tiPTkaF4Z");
        state.setStateDescription("UlSSSSgqEF817HdIs596PiRDV5cy8furMnui7JpirFXwXzmibd");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("yq6IWQeH7LvlAYtuRFeTF6WfQ5Yvi45B670LNz0ayLcb5OOVwD");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        city.setCityName("Jtvtq6plvtJfk0QC44uFZlbUCWbIFbtzET7GNP3b5Bulgm6MO7");
        city.setCityCodeChar2("qMXHQetUOFXxEHhJ2AVG5kbJo7Twx2KQ");
        city.setCityLongitude(6);
        city.setCityDescription("g7aatLJsgC4ab1XEHnNqQD1aoEEwTcrNfAOzynZtEQBt5HmyWB");
        city.setCityLatitude(10);
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
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityFlag("bBSb2oSqlSZ6tnPDHWsjnEmzrlGKhqTSRHk4dC9PWV3xJqF54P");
            city.setCityCode(3);
            city.setVersionId(1);
            city.setCityName("6cCx5PHOhwax9IQta38dbnECNIoJrYVLeyBrqr6wTWrELeZVbU");
            city.setCityCodeChar2("eB7NzGk50pI9eYrLAnl59xgTcrvi2LaP");
            city.setCityLongitude(3);
            city.setCityDescription("3zRb4yMhhkwBQScG5w6iz3lCLuJ2BRFSZgSZHt6RS9OXgUfljM");
            city.setCityLatitude(5);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (java.lang.Exception e) {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "oVJ3G8Y8420XQcsiVXsKBVw77cGAkt7VttaH9pI1NeUAtdSOLBA6JnxJq0IMhv5qNRmhMkM1vBoh6u9BwnYP3N87qUpB8NJehVgyN6ssOXaO77S2kFU1GPAKyoVXXyeiT0dKccIUPS4faC4bowaE67t9hWoce8ZDkQOO39eXMMLsy0F8hejKv6tocgu28PzpadHqmOQhOxWncNXLdpXyjTpGAidrwvQRQ98CLHqjHWnbcuA72aVxkmO0qDdEiGQkM"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "K91SVHGa9c1p9go5TjiJHqePfewnF8yNZ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 5));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "AYVrT3qIjW3blmRFLVnFWTqCMjNoPWa2UwybpJajDkJncEJPIGCia2GN1BNGw7MxtM5ZKQnOVPNNwbZdypZzcfLrlgTatRUUw7RQgU4rTpEaLs69KLvvAxo6aqMTaRxNr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "cEg8bCd9vm9bkOkZfScE1nHF2kIqEGzOFFiR1QG2sjxzdO2T0h1GFmcULVT5SyEaC2nJNBye1R5SF81OmM9A8UNfRBJKQokDsihQYU9dY8VLZFBeJ1xK3XSBP8rqdJB8o"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 20));
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
