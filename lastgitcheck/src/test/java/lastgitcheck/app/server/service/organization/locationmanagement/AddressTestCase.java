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
import lastgitcheck.app.server.repository.organization.locationmanagement.AddressRepository;
import lastgitcheck.app.shared.organization.locationmanagement.Address;
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
import lastgitcheck.app.shared.organization.locationmanagement.City;
import lastgitcheck.app.server.repository.organization.locationmanagement.CityRepository;
import lastgitcheck.app.shared.organization.locationmanagement.State;
import lastgitcheck.app.server.repository.organization.locationmanagement.StateRepository;
import lastgitcheck.app.shared.organization.locationmanagement.AddressType;
import lastgitcheck.app.server.repository.organization.locationmanagement.AddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCountryFlag("E3YdGbMCJ5KuWJb0Z5tJdtuiGR9QaxvbNJkvmaUj3O3VKcdjwQ");
        country.setCountryName("XvH3KLQG7bCLME51xPij3XIYjT1VCNgm7BlaQh1LUMKLlVkZj1");
        country.setCapital("PLRe7QVvIvdbz2uAFfkwotP8E6Gsy44S");
        country.setCurrencyName("eXlb6H1YA2LQN5wEKDeSo8VYAQyTRsM5MJeg1lwCGxNduufGo0");
        country.setCurrencySymbol("tWtBKFN8rcPZl1Ussjcj28PhlwSXBHeK");
        country.setCapitalLatitude(10);
        country.setCountryCode1("bmv");
        country.setIsoNumeric(702);
        country.setCurrencyCode("jEJ");
        country.setCapitalLongitude(11);
        country.setCountryCode2("9Sx");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("o8JeYpGJMjIp8v7IXB9oaxhV7FwYfxMDniZFunQBWwEqAUuXjB");
        State state = new State();
        state.setStateFlag("Xz5IWKNwtMALaTwXftQxBwAdkxDhvwb9HCRvQzq32luHt1MqlY");
        state.setStateCapitalLongitude(1);
        state.setStateCapitalLatitude(6);
        state.setStateCodeChar2("Y6w2dUf0k68RFe6u7SiG8EuHCKu8Y79d");
        state.setStateCapital("xArTPZItNSbOrnIUZvFFpdpHe2055Q0wDUgEL3bUKFCb7j5F3P");
        state.setStateName("m9A5iUoY4puflyiFbrQoXvFXgvWQLXTyTL7yPgo8QAGsGxZJsD");
        state.setStateFlag("xJpXgpD9i3TKP4i7ZiWsK0Sh4cJntxM9x8hrdVMZ4yu6nER6Ux");
        state.setStateCapitalLongitude(9);
        state.setStateCapitalLatitude(7);
        state.setStateCodeChar2("k6ZtnxBxJIABKBHnJsw8EwaUeI3UUZPb");
        state.setStateCapital("dbUtoh0dsX4hG0QDbimhzJdsJsljD8Wbpj5H1nOhWLKbCBNcMQ");
        state.setStateName("MLf9iSWYn9TaQ9l8jTdIOVcs3jiWvqY7eFBGwthLzNoyRJ0bnq");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(2);
        state.setStateCodeChar3("rpf2NW5cWaLNhFZ7e5lK2JJcZoETnURl");
        state.setStateDescription("rSeXnbnKuGCbjcTM6nPBv3VwrbSPDR8cneDkwj2idugdqmGRGo");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("ExT62iV77YRQPevrLZNya46keXlrQnNcFKTuBo80LtIsoaXoUE");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("HEoJK6MSSRoqs20qJ31lUbbn4sejPgu1Wi726h91zmgi7k580Z");
        city.setCityCodeChar2("xHyHBYeSg62wHT8q010mTXGG73xzAJY6");
        city.setCityLongitude(10);
        city.setCityDescription("f3KB89ywuyYDkkTmrbgw8DW3V1Ug6SciamFoEL7wYpXz1jKja2");
        city.setCityLatitude(2);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("XoIZJxtvMjeVyZZcpTchrTH0DHQH4tHCFtiIKY3l5JwT2HEThl");
        addresstype.setAddressType("amShEwsYW9wngY6159d7mD7KcppMBk7lTILFpKMc4psjsggxLz");
        addresstype.setAddressTypeIcon("n2y0MmLE0KenjaWulsIw714PbyJE1goB3HrEIR6iCyh814Cbvs");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setLongitude("QKIf2QvIAkwXEz3t3EGoq0YgPz6v1mDigIXU3S0bFQ3e2fzszG");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("egvVgJFVgpH4cg4U7PdQXmuQiEvINxgFYQW4NaSehAzzxeWSen");
        address.setAddress2("ByFl3Jfmq9ir5daZ3cfEpptNaVAw0nAmamAbwHJjKvSc9s2f2P");
        address.setAddress1("cyywmGBNkBmSzPvbBFZ0VZIhIKvd2XA6nFniRzOFOCEgr2kHDF");
        address.setLatitude("V6JdHE3Wa9EbCN9K1y4I8ViYoB5i2k4EAVlCjIl1QFVYNBidCM");
        address.setAddressLabel("TNm9cVg9vUG");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setZipcode("h8OFPt");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("XdBrHyJBjM6Z53fwM0G4doUDOhxMFBcAh8FG4Ux9Y7relJ65ZE");
            address.setAddress3("VFRtMjjCXDBkjCR7k066I06MtPYFIpkttbDXSqdNjNEqqZKJAu");
            address.setAddress2("JwxXH0cOVyKvlPy2DDq4GalMCjgYdeZ1lXJpuHyEqXEhYfWvXN");
            address.setAddress1("5ElBgpUMQsFIDokiEjQ7ix0dZMqLSr21JRWkkw8hq8uvXcZhZn");
            address.setLatitude("O31RHNyHHzLNA2VbAfrJNR5PA7WxhiQ3VEdryNvmd3TNWp0LTQ");
            address.setAddressLabel("LjWp45HsIfc");
            address.setVersionId(1);
            address.setZipcode("npSIKg");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "5NWTDbgOpGw6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "CwAsg7HhaB8Dq1ji16MfLC7sL7UGPxRlfPpeoocCDRYGyWJ9ho68Tnpc6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "W4kiXSeIPlnizBmHgIagv9YvLBcZorveLaP9jCCW8rz4ZtMznsrO0zWtG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "DSYh1rmxklLeiloRCG0Vrye9PR4i9kYG5Rfe26fXRyKSEEKhyEe440sZc"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "Gl1wuJJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "ka0JfvvAH1MdUS4JE1FHWFqb7rt2hOMs60FyD5zFwZJ97vD2uGsucalCpxd1AmqPr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "M8fbwszWbd8XvXPDNUfteDyW6BIRUemJfFQ5KD9V4NeeJWTzq50uDmrQypP9MsYYo"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
