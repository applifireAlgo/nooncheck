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
import lastgitcheck.app.server.repository.organization.locationmanagement.StateRepository;
import lastgitcheck.app.shared.organization.locationmanagement.State;
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
import lastgitcheck.app.shared.organization.locationmanagement.Country;
import lastgitcheck.app.server.repository.organization.locationmanagement.CountryRepository;

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
        country.setCountryFlag("qm7hIGkZP7Ypw317XlSBsPgFXYro3DkOl1QmKfvvFbllvWZPBW");
        country.setCountryName("EPzIhANGnrlbWoQEBSSXm5XIfgBYmoRYS4EHfmOfSVN9MJ9LV2");
        country.setCapital("8jhKvYN3WJIymxBnKPjn8CbImfxwar2M");
        country.setCurrencyName("7G3YDLTWiv3hlRNNKdOQWDKZvHehr11YESg5o5ymhvgCgxbzsG");
        country.setCurrencySymbol("bha5GnyRgekbNSL8Bz7ULGD1uf7zLQSD");
        country.setCapitalLatitude(5);
        country.setCountryCode1("x4Z");
        country.setIsoNumeric(570);
        country.setCurrencyCode("EYe");
        country.setCapitalLongitude(6);
        country.setCountryCode2("rxD");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("huiTrLQL1Q6LetyrUxGN5bpiGZ9dIUSlAaGJk7r1KAaI0FSB6o");
        state.setStateCapitalLongitude(9);
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("ARPIsxpqyJGbi3D0PrRyoEanPZ6zMF2F");
        state.setStateCapital("hvaTy1a2kxGL3YujCYMLySJ1fR9znlSU7puaQ4hzx0PncqOQgY");
        state.setStateName("24NB3j73dsp1RMABHtdi6AEUgHapH3jW8K32Si2cniOnXicBSX");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCode(1);
        state.setStateCodeChar3("96ZCBqlRiUlAl8dsiR37APmo2lSKSepm");
        state.setStateDescription("a9yLWnSVNt6rmadXCAsfQ2OhPS3oJKdpJ5vdlW5USJa4kTGoqt");
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
            state.setStateFlag("exzXqaOftBmt9ZAmpesR3Rx8zHuZ1jGYtPGoISAFtsmTgjAHTc");
            state.setStateCapitalLongitude(10);
            state.setStateCapitalLatitude(3);
            state.setStateCodeChar2("MhVd8iBr4TfbrvZ1sE1bYMynpS03jtqn");
            state.setStateCapital("pR13fIeTNJK63dqZTGwGDYahnbN91wNbHlaYI5UtOCXEVUrXY9");
            state.setStateName("VLVGkn5KGcvhsk0FDh0XD4RRlARrBhgHp0NkZRpn4CHmLoBJ0f");
            state.setStateCode(2);
            state.setStateCodeChar3("fqPrbkMM4zalIg7MffKovJS7Ozzo81Wt");
            state.setStateDescription("9l7kMyN8D2GxvBrTHr54YVaqzzSHMjoKua2MChhX4qBxipw7Jm");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "m22mJoeP7X0Cio8APxCpsAvxODZoDjOPnsaX2QBZS5Nkh0OehbnafY14tsTfuYQZDxOhb67rlLfQKSYmCcBcp2lWsKP3iZSgNZHDdxeeritdj2Ww2Olhq1jbS2hkelfAAQ2IF0mu4mxd3fCINTwKxkslNxlOPK06cM544A5H0qpNzP4t5LH45P8U1b86jrWWE5vCa8Xq3e9R2qCNOC3esfgHUJC5IuN4hJtKjVASXMd9trpe2ShsrwcJVS678CqB1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "iqjy1MhHs2nkPLuYH7GpbhySUB2MDhmWE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "lydMIN0Ou5TDilypqktC4BxPyzogeJ2Hl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "daU8gN2ynr6ZjWgld5WPsZfEb0NIUhOnxBp8pn0DNt7hpxczqhfghIirEZX18KjXdZEPZNkatalqTq15k18WP9v2vQuMxJrQfXKrwCeMFPgNXKKedkdXGGvaRSFOPxYZ1GylvjeHC2P6jz1AN01VpPwB4QVhBMsqgssHM4QQoXkh0CB2MlD0WgpeSwZ3GsAuMsUntxVO87GfPWz7Y8o4n5PtEeQxI4SbeNBL931gdFBk6P5PN4xpNritdj3pR8iil"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "DFMiOLFJISlOQo62UnPJmFs4ZvtooSfdjT4XyHDcdR1RQPt6RFnnN2uNcl5N6HW3mmoIIInh2ZEX4yiNNV7z0EsOME95ziWTt2KfV2CZoWmJmLW1DQbMx18yi43yF1NUA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "1k50HBu8hgamye15wwO367GNTq2IOjb1aNH1r5P0zqsXPMsOcpYmnxgioCKxqjccAp9X5otXholHybhjfGicSwyRvvvKkUpYICNuMH2sIMmA5EKEQOmrZ41rt3nb6kFjN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 14));
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
