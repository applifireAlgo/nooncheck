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
import checkgit.app.server.repository.organization.locationmanagement.AddressRepository;
import checkgit.app.shared.organization.locationmanagement.Address;
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
import checkgit.app.shared.organization.locationmanagement.City;
import checkgit.app.server.repository.organization.locationmanagement.CityRepository;
import checkgit.app.shared.organization.locationmanagement.Country;
import checkgit.app.server.repository.organization.locationmanagement.CountryRepository;
import checkgit.app.shared.organization.locationmanagement.State;
import checkgit.app.server.repository.organization.locationmanagement.StateRepository;
import checkgit.app.shared.organization.locationmanagement.AddressType;
import checkgit.app.server.repository.organization.locationmanagement.AddressTypeRepository;

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
        City city = new City();
        Country country = new Country();
        country.setCountryFlag("t5TnCa5Pbtv7aesbzpjeDI4IysU2nM32u2bIYxXQe14UkJ2ILQ");
        country.setCapitalLongitude(11);
        country.setCountryName("Oce9PHEPo13ultMS2GH67QFT7xtvJK0oIZ1C4wTSvnyQNgXQ5d");
        country.setIsoNumeric(859);
        country.setCurrencyCode("gNz");
        country.setCurrencyName("wDcsUpS6fqbspItwMZUN2aOad081x0XJm6AvNq1WOT4pbF27jX");
        country.setCapitalLatitude(1);
        country.setCurrencySymbol("LnhpvNbo7hZbsqKPgrU837Ca79DUGNqU");
        country.setCountryCode1("Ppe");
        country.setCapital("F1yA4bMRbiVRamJKvlhVmLiFRPVIHAiF");
        country.setCountryCode2("OnK");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("1UKGF5hTEoIlLI5wkNh0kgMt0XRBjDyXPtucQbh2EfjtD5We08");
        state.setStateCapitalLongitude(1);
        state.setStateFlag("CWRQD8xOZzf1qlAijRgFV7thJ4ktei39sFsRs1rTDD4eZQ9qyF");
        state.setStateCodeChar2("o3os8rGPECtTireob1HXiFT6jkBdlVOP");
        state.setStateCapitalLatitude(10);
        state.setStateCode(1);
        state.setStateCodeChar3("bPaJvfXV7EHZcAUOc3kVs89iEJMaALo3");
        state.setStateDescription("tcVSPdYukqXp09x2vxJtjhzf82Mw5jSoyhec5Q2w5UVzrHl6IE");
        state.setStateCapital("7FoezuYyoX5GNAgIRKU3yCMk5xZ0rcRMkDtKN57D1FnOeyn1wD");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("O2z9Fqdr4M8tG5a5b6jgy2cE57UYaEdSwXHO0UWImls9lea0JV");
        city.setCityDescription("WCwtyual0FQFlo90xtkDkaigLeTY0v1bXxZmil8qRQ5kA6IoY2");
        city.setCityCode(3);
        city.setCityFlag("9hAmQzzagao01OmBwFVovgtgvfc1j1mVulzNEGM5ICK5njYKrS");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(3);
        city.setCityLatitude(5);
        city.setCityCodeChar2("tYaB82O7rsQ5C5q1xgOmKZ3OoGrR2lJk");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("6voTaB6aHQXrwa3aYzI6JDMSylQVJkwKvclj4OtiAMU97BT346");
        addresstype.setAddressTypeIcon("TcPFkUPI6TuhBvxzXIcacud7q5gWMMdIwY6P5ZM4q8mnBYbEYC");
        addresstype.setAddressType("ZSU381bvp6yvB3NBQTVdX1GGMwy5eo2z42V6h9WSbJBgd2qrEW");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("ZbNiOu");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("WtGq8hwOIZHuBu1ZMtsT26RSb3GxSPOGVzzFnPdo0xoS2eXI6H");
        address.setLongitude("KTAiSueIzbYtJTjlDv3PVH8tDf676c1OlYziDso9vadOLLtptz");
        address.setLatitude("82TFnZDuDcWDAmYVRfTXw53yyhLi5DjoKeXfLCuN8rGp2025OR");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("URCuLk1GH1MGBAiESuUFHUsvz3nmOUqf1jkHSoIyGgewihaxmC");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setAddressLabel("dHkID35Ugjf");
        address.setAddress3("OjgL83IC4slT74ELJI9l73GEwZKXqcnhrCqnfj0j53tLtumBct");
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
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setZipcode("hcGcQL");
            address.setAddress2("vEztu3HZPHZ67OElF667bD7YMQsg30Y7LHmKjMPzYVHqmQ0OZ4");
            address.setLongitude("v5LrV2FQqtVI7YaMd9WrNNKnCbM3iH1ZtenVmol4iwiwDdepiO");
            address.setLatitude("4IYGNOEw0phc5uDTMggC0EW6PbIjaijSdFdGXtrLdTnzb7D7xm");
            address.setVersionId(1);
            address.setAddress1("PUDN1OEIq73bsYc0qtSJ7kM9nHTSXZXzvAG46cIZwTgFwXednK");
            address.setAddressLabel("G3O36lMmL3g");
            address.setAddress3("blEIHsW9gLmW6WUveCGtDN9kcbGgkpSb1DNTxBm6q6aa5hhGxw");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "U6eiYYD9ZbXR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "cbCLotaRgMFRPAOZZ4QZL4vP9yADQRSZ3GDgjllPtM7PzSvYLBm372ZXE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "l6MIBHq2a5Ds40lG8gXM8GFSJ2jZz50kceVtnEW4F5JVRJMaNPcWLVDip"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "jkgH6XrBx2iL6UOCpkCUHTSf7nXpvKciqByuAm9QwIPZB6v2J5yCGQj2P"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "TXQRJZI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "RdmxpbLmVUrRmj746f1f820k25xxB80u5eEsVQgWUJLRb3FvGJVlqoPVExxRldMRt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "5qyfniuX7fgK7UzRzZfm22jMthgTw5vHy1Ro0itkHXQNCfOfTCks0JMe4zAX0WmQ0"));
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
