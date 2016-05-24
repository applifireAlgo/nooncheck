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
import checkgit.app.server.repository.organization.locationmanagement.StateRepository;
import checkgit.app.shared.organization.locationmanagement.State;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCountryFlag("J9Bj4xAQE9ARodPjCkChNyhiG6IuFXvId2PUIgwoYF34Rdr9P7");
        country.setCapitalLongitude(1);
        country.setCountryName("ieI0ALHnK2ad0SNIVeC8UEJQrOZOMTwegFFu2Oey6MXGgeZneJ");
        country.setIsoNumeric(957);
        country.setCurrencyCode("x8Z");
        country.setCurrencyName("uq9dPzzhy33wqzD7ksqACdhkWFrxowIRvNwey9SjXP0FcJALzm");
        country.setCapitalLatitude(5);
        country.setCurrencySymbol("co8APR9sUyVz1GAwNMslN68ZKnF97Qml");
        country.setCountryCode1("7nS");
        country.setCapital("5HJW891miMxsARDMVGip0VOj9dAqewca");
        country.setCountryCode2("pmJ");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateName("FFqwDLhFZpfD8UGERmY5r25C02XVrcU2lCxqBmHBspPVY8AHQa");
        state.setStateCapitalLongitude(1);
        state.setStateFlag("uH7PyP0gTaCmisxiKYf8IblXkcCY6vqikALQNj0J0G9hPrV8zi");
        state.setStateCodeChar2("8kED9XikDTQbL3TwYlagyGAlwP22H5MP");
        state.setStateCapitalLatitude(6);
        state.setStateCode(1);
        state.setStateCodeChar3("EQPqnwGbgb1MjHJ6cia2Bg2MlCmYStm3");
        state.setStateDescription("w1ztl12YOVNgY5Vi9Eof9aSH2kyP4slOre9ANTL3B7ZdqIDQEJ");
        state.setStateCapital("hDWTFA8AWu0ZZbzxZzDnEQfd8M7JHvTOQtveO6lfdgIQM4S5KZ");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateName("tSj9Cn26lRboUxrQfRFNA1mTAjmgwczfNG4IKxIVBRCvBBDith");
            state.setStateCapitalLongitude(4);
            state.setStateFlag("ISfvbVF70BpU3V1NDNkUrRgsMINk0zAO0E6nIVQuSvEZb4lNEc");
            state.setStateCodeChar2("NY2L6v2Eko0UEgR5tgmS9DiTeDRZVS4R");
            state.setStateCapitalLatitude(3);
            state.setStateCode(1);
            state.setStateCodeChar3("3qCU8nJQy5BiHitFUibu1B86dwIIbDLM");
            state.setStateDescription("eDGJEhawMxpAO88CwGQ95V0esOZe7f3RQFxiNMI680XWPKg3U8");
            state.setStateCapital("2kRKqNMvDVh7fcpBHtUEdYECNi8FxHU4Wy8RjaAPt1yrJmgUlb");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "awk7NjA7j09OKWSo3sTb4MbMOyi5tWYpZkvm7ddWfAFYYiReXduxqgU4zwrZMNcmlJMRuWiPpgRdCofYDqCwSVxZQUA9QNiW8xcs3qwA4Xx81cmLZHtyrf9wiq7wb4QdNf7T0gnU0CIGE8mAX7QqlGT2YN1wrhqkQZs3JA5I6Td53iIrC3tL43zjG4iD7xm6r9YbnlhXNLqrfMwx9ik9xYSl8uLvBw2h1cj7gvm33OeHBGaBDOXewI5Xe4XTFbRng"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "KH5sReQjtN4eVNubwMRdmTOxRVIcZ9zoV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "BU0LK7wXmWQFK7fUogDKlBFYESg0RINVX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "7et7306b5frXnsjPkgtFsPugDlBsAWibSmJa34RzFhhKTUHNN0aItb2WOuIva4FP7cCCRfWtDted0UZ2TsNIHwVYg7C1XwYJYKdEZZpJ4NUbE9zmnCGBRNsMXKD052TvMzWcTrl9gFtJ71NELihD3Yg8HMq3oz5OC2N1QUXKvMFhv4UIKqi4IiEgcVTvXmdcmXdgj2qQq0LfTudG1ntxKoUJVPGpbdcymeheLw5W81aHchRoH6KUBbf1TUlSOzwBz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "nhibpXLRc6O1M78dAOalv4myVqhd74QsEde7Ux45pb1jIzwWHMa2pYuSgNYRFFZnMTTVy6GOcyOPaNTiuAu8AJOSP0iaes2Y7SaFzf3lmUfKgeXl8Pxlo6kNj2KQHnBXX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "S8epE6L5HLZLpWFH93pSzTJ81KuAusB5mObReRwXgMeQLMUJf8gxTyKioALQUL5DWBlqH66yCl4a2VCipJ3JzWAi7x9EwwPufFK9knEPlJw9luhOmx2B6IEeS5YCFwt0j"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 20));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 12));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
