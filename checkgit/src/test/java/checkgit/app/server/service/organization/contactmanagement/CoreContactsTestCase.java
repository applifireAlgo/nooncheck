package checkgit.app.server.service.organization.contactmanagement;
import checkgit.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import checkgit.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import checkgit.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import checkgit.app.shared.organization.contactmanagement.CoreContacts;
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
import checkgit.app.shared.organization.locationmanagement.Language;
import checkgit.app.server.repository.organization.locationmanagement.LanguageRepository;
import checkgit.app.shared.organization.contactmanagement.Title;
import checkgit.app.server.repository.organization.contactmanagement.TitleRepository;
import checkgit.app.shared.organization.locationmanagement.Timezone;
import checkgit.app.server.repository.organization.locationmanagement.TimezoneRepository;
import checkgit.app.shared.organization.contactmanagement.Gender;
import checkgit.app.server.repository.organization.contactmanagement.GenderRepository;
import checkgit.app.shared.organization.locationmanagement.Address;
import checkgit.app.server.repository.organization.locationmanagement.AddressRepository;
import checkgit.app.shared.organization.locationmanagement.City;
import checkgit.app.server.repository.organization.locationmanagement.CityRepository;
import checkgit.app.shared.organization.locationmanagement.Country;
import checkgit.app.server.repository.organization.locationmanagement.CountryRepository;
import checkgit.app.shared.organization.locationmanagement.State;
import checkgit.app.server.repository.organization.locationmanagement.StateRepository;
import checkgit.app.shared.organization.locationmanagement.AddressType;
import checkgit.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import checkgit.app.shared.organization.contactmanagement.CommunicationData;
import checkgit.app.shared.organization.contactmanagement.CommunicationType;
import checkgit.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import checkgit.app.shared.organization.contactmanagement.CommunicationGroup;
import checkgit.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Language language = new Language();
        language.setLanguageType("kHPCHdr8SFPIiZQRwciJx4hjAM9sQz5s");
        language.setAlpha4("Xdt5");
        language.setAlpha4parentid(4);
        language.setLanguageDescription("SdF1H3FBHrz7ywcQXj7PTUFp74VNy1SZ7FCDuMAyWdjjcQUmB4");
        language.setAlpha3("8jG");
        language.setLanguage("t2Ft7TJwcnN1jmWIYkS3w0VCIaUoJVVKLQMdr53LEV40JWQHTX");
        language.setLanguageIcon("GipWgP6IUQ56Htnt7YE8L1PrDCPw3si95Jb6PMHMNKTjV20kds");
        language.setAlpha2("gE");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("P6iGE64d0VlN4CggHnGHGg8TaacAD6BUgNVITopyjrYGDCS9NS");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("RrwH74xFBv1SB6IOrOjZJgX10X3P3yCOY12pQeV1R9lAGox450");
        timezone.setTimeZoneLabel("xnFiwBY8qbLmVek74tzFFR02z5stofOcbb8VvJYberGnlWVZfW");
        timezone.setUtcdifference(6);
        timezone.setCities("04hi6ekUDWztadnd6rlNAFVCJiWtxMzBZIJ5SKilhZNe7BuPVj");
        timezone.setCountry("xjpiDrtomjnupgMzgLO6dxd7TwqgOtwVlFgi2fOuSJBQq2HQri");
        Gender gender = new Gender();
        gender.setGender("TnLU0V99JAoW5xZbJUjK6yMFbjTl4tvUYRdoRq0SNJvBBULbNK");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("p2QLhsB9VJNcr3uxBXcZ");
        corecontacts.setNativeMiddleName("uFRdevz9qdluneBr3zUAE7rn0w189k0oeXROYDYf9CQ95Hhi3N");
        corecontacts.setNativeLastName("12pApn5ZSHAsKWCxmwrfeWZJ5ym3vPDzY3gxH2RdqKxf6sqsKB");
        corecontacts.setFirstName("CbHuCRc1N5SBe1nRSieC4XgIsmpxKyP4XFftZvdDSV0M09nCH5");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(59);
        corecontacts.setMiddleName("Wnht3ANQN0mkWlwsq1K6UaralO4q1oIFNjgaxyjtkPj4sqeamz");
        corecontacts.setNativeFirstName("1jcNj3jcjIzqDQqFYjkrL1Yam5t2BLTMyo5c8lfjkXzwUx2Q4q");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464074773483l));
        corecontacts.setLastName("bKZWb3gHOrcpIInoVEErAWX5Lee8wDrzJ3ogG6XN5KCo8D2KSe");
        corecontacts.setEmailId("Zr99SCK0DTz56muZDbtCDDPDYyunJFPYh0VaBP9rpoadt596Mv");
        corecontacts.setNativeTitle("64HZHveOsyhVJSMmaHPyEnUaS8E5aDMdUJYfb249PJn2t8TzNn");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464074773528l));
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        City city = new City();
        Country country = new Country();
        country.setCountryFlag("K0aog2du7sGsGxSYOVuoC1UNTepnMepUxyPl1lI9q9t0gxf8hy");
        country.setCapitalLongitude(9);
        country.setCountryName("EhTbS23KhxGMXk6Sj2rRbwGeGYz7sDp0xC51mgEz4C56srrV76");
        country.setIsoNumeric(901);
        country.setCurrencyCode("FtH");
        country.setCurrencyName("NDLRvLqADh1cLN4dgwtEPk5AgTlL6Jh4dtyp1CEKuulsZOJymP");
        country.setCapitalLatitude(2);
        country.setCurrencySymbol("7g6QdWJyUtNKvVyysLehHl8tQ3eQQiyW");
        country.setCountryCode1("Rih");
        country.setCapital("Gra7pWCDTCjwyMVN8ozsfu0gMIv8hA00");
        country.setCountryCode2("air");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("RaytLI4C5wrBoSFR9dLIZ7xD0eHeRqgUwOWptS0cm8pOm9bXMr");
        state.setStateCapitalLongitude(8);
        state.setStateFlag("hh0DE4AamH5xiJiabaeFtw704Cw1lJMczcvwUwiK2WfmCtHF2z");
        state.setStateCodeChar2("e2SokfQOH6WG4tsUelrFZSINkJpoFa1C");
        state.setStateCapitalLatitude(5);
        state.setStateCode(1);
        state.setStateCodeChar3("vLbxre96ulMsaSIMPSuALHseq0AiOnCQ");
        state.setStateDescription("XNORaECwsdEjXrlQT0NCc0zQHvaMY2LvVQnAiEhhioH8WtzGg9");
        state.setStateCapital("1LrMKvJ4JHJKETjkTQTs0VdxqQ70S5S1rKggOWgnGnFnVPA866");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("J6VulKA3N3OZmys6Cfwhc3u1Y9eSKmCo1zISs2VJjjKHgowRUG");
        city.setCityDescription("vCIdkN2nN43d4iVHOpjnP7t20j8wJni609lWCRlObw0Jrsq7Zl");
        city.setCityCode(2);
        city.setCityFlag("tcNmXs8xA1Zv0UlmBdHLBL8Otf51ujluA7iEvV5dZE9lvSoV35");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(6);
        city.setCityLatitude(6);
        city.setCityCodeChar2("11rrPFkCPJZVcYs3DT8PjtxPoj16YExW");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("1ZYQNX8gLWefJqe0fYaF4t0em5mZPHfQOfRzTxquHdClJ7liEh");
        addresstype.setAddressTypeIcon("vafXOrXkK3u7rEUKBh6celr2oP1uZb9KTqPROKXkHpTjVCnN0V");
        addresstype.setAddressType("V7qXO9qo4EvFga9UfWOqC18EddLk5QP49JGNgwWqPOmE77oeUQ");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("vJA2ny");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("SerqWwqtdnFEOEX68fNoWqp7HqFtw8gnnGc4NrMQcpz6tMpFdF");
        address.setLongitude("EM6NnvFipnpnqyXZapmvdyaPJS1XDjop7mPcauDrv8fNLDNyTS");
        address.setLatitude("9QjlM1WMsWVcCthql5R4sk0vixfJqodOKsYDvk2BEVn9pPNIhm");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("m2wF5Gne71DMWVYTIsbAwDhPYvvHrq1glVJJ7y9mYVZNwMmjt0");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("x1PUHoaqxwq");
        address.setAddress3("3XoMUkOsD94U8KnuhifJtZ23ahaK03fUwyDDzleYvavLrcPTnQ");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("Eeu4PFBNfg");
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("ImofgWttPoRAOWeZAWUAOH49qhJu4DOc78NXIU6G4Hn4hDJi7V");
        communicationtype.setCommTypeName("upjngruy3TSDdrfyPX6bAj57d6U9jMRFHdPFW2wLVQd4VJvpoR");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("bGKdiN4bWXIBbq8YadELu2DYI7cSEJqaIiGj9RyQgoQQk5aZWh");
        communicationgroup.setCommGroupDescription("NVF1PWaT8Ch3VIbC0OrQQ0bSpG9qn5q97vDr5fwB7i1apOIeU1");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("TkugEJKOJh0KEIjjg6VdmvvguPjlJ61smZS79X9jvRh6fVJT5i");
        communicationtype.setCommTypeName("UkG40jP65rIFX5AdZDEAIg7fpqpT8yvP93UCvFY1lzkKEqj6bU");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("et6kJIGx2G");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setPhoneNumber("xSxqmuT8bl3805hVj2ll");
            corecontacts.setNativeMiddleName("UNpumIGyNBLH8lfPobO8PSlo3uiSDcojg7TZvLIwZb4GtDKaag");
            corecontacts.setNativeLastName("tDmhsEYh0Vi53PkestmfaZBbVVbimzpwPIBhEmFu1bNfbjyuEe");
            corecontacts.setFirstName("09w67BPt9HAonq4LF4Z4ZMGCLJ7CBUzcTBBBi8tJWIXI6of5Z6");
            corecontacts.setAge(23);
            corecontacts.setMiddleName("KR1TEJxDIkBF0VM9DcAT1ChQH1GrlBcj1NjsUpe7uF5vMyObip");
            corecontacts.setNativeFirstName("bwHqgGmeous12pVq898m2zuqpZXb08HcgiOZiFFNMssYo3x1iC");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1464074773967l));
            corecontacts.setLastName("MplTGTV8qSX4uf7unkh2a2FQa3oHKCFghZF4e0unLWkrCNNJMi");
            corecontacts.setEmailId("zz9wBKR4IFp5FdwQYWzOkDMiyDmNSACKtJ19PdNmvz7N8d3vDJ");
            corecontacts.setNativeTitle("xhQpBapqMJutLXzQ1XbGo2BdpIILindL7zB04rcHGbr1bn3czY");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1464074774004l));
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "nc3lsZMw5sgWve8Eb09Yz1E7HwI5gC5QrSJbDMzQZ2uLL9axEG8uZi32GuE2j6EId4VSzywSOReFmorokvrrkxGSWDXg3Qmh3DlyDRsGGD11EYnBh74QRnfP0rbFduslxlP0wCicPjWO8Q7TlPkiwA6Ycz0QYIROT2i4ZoJS30VKe3rUGjTTwlpz1rgzROpURmNgL1eHXs0730TVkrsiXq7Eh4kmyEsPLsVZCkKAP9w8g9rUH8ge4srxypklYpmc9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "WQ8txm3YMMwKXNz0nthcaz9THdkP5QJpQweYaTCuJE4A4LygUrkw7oe4h2HUIKObNUKScapMoVepIsh5W7gpbkQs5JssiES8eqg5lPCCWBzEO8FUMM7OlJIYWuVDoCv85PRcShumL1YkUf8DR6Cezu88hSkUgYN2mIihkUSmyEjoVSn3aKqgRtfyMAdpp29PLxzNAouejmljm1suwBuRT1Zg88gaMnchFdEkd0ISvW5YP6T5zNqEJiYOrhOac5DNH"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "EYDBoaG7EwacNF0IWJM4KKueile6EGM99N1pDeg7AA2o2WXdhCxiKh4LDj5YU0KXMD9Z41wunyet12eGJleVdmWWfzerIbrpkOGv7xKCqq3ZH1rBUxZfhw6EYUYtPmBcKoNvE6stVPK0ugmA3tEGgzlzqgguD1shwvVnx1hPPYGAspdfPtO5ZQWYlerLvO44z3ts1EKexXnxxWo7S2PMQWRHzBgqV2hJ9EEEPRnn7C6YAIHJMn5t9WjlqU7mhPGbe"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "qaRN7t4MH1vKTMfC41ErsIFNuauA1KkB3ERrAo8oevGJX4ddwsVjQthcH8u3m7dZJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "G4x6CK1v3rEthaHSfozks2sRfUsLQH121zoKilVuKkH5O2Fa7evLoDm5ghVVaqteNGXck44JVamXniLVDpq0Jr22yrJpz5dNd5eCb94EtrgONJN0gHv0zNDlNWEbeWeEZWDh3dCFLpA0GTL1fUCZYRiHEC8U1PXd7zndUzLwxu6nXZJdBqB4wUdMPz2hCCLKm9F4yoy5oq8J7JZx8O4enGg71znCLv4sxUtX9NRbkTnvuTPUrm6Fj9MmvgN9CtMcH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "plGJc6go0XksSrVAUmL8FgyuHm85OExH5JhlM9qwvMzBfToAGC8iWWIPUf5wx1JMv46ncHSLkRq90sVLe6EWvUC7hGtrLbDP6ppohxp1zhYQGI5Q7OoksH2Jj9OavYK0QkL02soE04y2Eyns5nUzMcqRQZNfIhIryvzNpnLRQaWexT4eEYRLWc06BNuCwdmlwpdyZIs8HTcJw19rM99znpY2ORZl6SFN4gxlBVBXLwIz4UGmrYuLirkMZj3dtpk47"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "2ddGC91kyUHZdJUK8T69Do2i2iyVtrEXZ93hIW1OnLs0zb6PyMd76EN0OWtdeCkzRYjXMtGuJSOwg9VlSn49OI1ncly5CIvcAl8OdibKHpiqNQqXk8DJNqhEEOqQWCcvaovfJMs0YuofpNAiAYmSzgjv8zD8zztt6p6d4KqssVMPaWCDbhZaIo6IbKwXMUbgFqHMpW1OlQKhWG7W6Ru2EZJuGogHhfozK5ZEnRKv5CWGCcNMvN90qcrZJ9LXsBvcC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 248));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "Vde1qm9ZXQ7Hilr8tOu9dVNe9JtUlnfgYRyr23e8yi9j39ZmXDpZz8eCdI6nfWKcGl1BbCI4rs41Sq9Czb9e8JcPbE1600qegzQIuzH1ywlChO0IqvxotfzbTcrozkNzAImh2Qh0LACol6AoJFvxZlZnKjSFIe2Oe4nmX4otUYXt31gK5WmPtnNEcdvy8YQPV4m3GQlE2a2k5SqjC49Rhy7Ihu9yir2w1WRJUBAUyytYqCz4q0IScWzJlCrH0VVm6"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "x6RvS1MmFvB9CRxHG0UZS"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
