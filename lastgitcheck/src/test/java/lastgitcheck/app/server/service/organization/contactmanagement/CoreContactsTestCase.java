package lastgitcheck.app.server.service.organization.contactmanagement;
import lastgitcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import lastgitcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import lastgitcheck.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import lastgitcheck.app.shared.organization.contactmanagement.CoreContacts;
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
import lastgitcheck.app.shared.organization.locationmanagement.Timezone;
import lastgitcheck.app.server.repository.organization.locationmanagement.TimezoneRepository;
import lastgitcheck.app.shared.organization.locationmanagement.Language;
import lastgitcheck.app.server.repository.organization.locationmanagement.LanguageRepository;
import lastgitcheck.app.shared.organization.contactmanagement.Title;
import lastgitcheck.app.server.repository.organization.contactmanagement.TitleRepository;
import lastgitcheck.app.shared.organization.contactmanagement.Gender;
import lastgitcheck.app.server.repository.organization.contactmanagement.GenderRepository;
import lastgitcheck.app.shared.organization.locationmanagement.Address;
import lastgitcheck.app.server.repository.organization.locationmanagement.AddressRepository;
import lastgitcheck.app.shared.organization.locationmanagement.Country;
import lastgitcheck.app.server.repository.organization.locationmanagement.CountryRepository;
import lastgitcheck.app.shared.organization.locationmanagement.City;
import lastgitcheck.app.server.repository.organization.locationmanagement.CityRepository;
import lastgitcheck.app.shared.organization.locationmanagement.State;
import lastgitcheck.app.server.repository.organization.locationmanagement.StateRepository;
import lastgitcheck.app.shared.organization.locationmanagement.AddressType;
import lastgitcheck.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import lastgitcheck.app.shared.organization.contactmanagement.CommunicationData;
import lastgitcheck.app.shared.organization.contactmanagement.CommunicationGroup;
import lastgitcheck.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import lastgitcheck.app.shared.organization.contactmanagement.CommunicationType;
import lastgitcheck.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;

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
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(2);
        timezone.setCities("tweJQR5NwHruxP9qLgamiX4vM7TtYXNr4qhrxG5SIPeHIqACkZ");
        timezone.setGmtLabel("eGlBoBUczskt3HhpBvxVRPaI7rfblHHJN6UHIKnZw7ncdmo1ka");
        timezone.setCountry("3XwtwpKs4pdRSODtxeuqxUsKEizvVjcqRaXDxEFM4opTtDxXE2");
        timezone.setTimeZoneLabel("XsloxSgPrLXXGQwV2yp5Vsa1K3vEANH6IYNqiZUf73ZDhOL5kT");
        Language language = new Language();
        language.setAlpha4parentid(7);
        language.setLanguageType("iYOWzuokW1BpdDpBbEtFmc1G5Y2n5SiV");
        language.setLanguageDescription("O8qzs1o5UjctuhvHLWvEnNobw6nNgKs6B2GhGxIhDPuQV3nDpt");
        language.setAlpha4("6US7");
        language.setLanguageIcon("yoMWsJFEb2xsYEeNPuXR0IZSeCpMqhNNtcu3lscTICSfEm86mK");
        language.setAlpha3("6D4");
        language.setAlpha2("m4");
        language.setLanguage("ImN0rM75rUhYiZ6pHCw3vDdZGvUDmeSFv5HGoGiQH8GpEdV9cj");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("XwyDSxMTjIjl88UDW5jswX9OMJYtGbGZr9wBkVqVgn5866QpVx");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("HcA22qMIpByVBSoROI9tjNwHjvAEop4PlsIY7lr8n15CQiGOKH");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeTitle("PvCyrm9K8Y4tAmqw0DyRA4UAXzWW0gsZFIiDKzjV8Ts0Bc09DY");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464157720389l));
        corecontacts.setLastName("Rn1HnEmgBxdUEPz3Yo1OXakimiGWNt3tpPiXPKeWWcW8dln2km");
        corecontacts.setNativeLastName("3XLYt4YGAHROBnT6hz4Scy2yXkifhvvtfjt4GRrhJTZScpJjwn");
        corecontacts.setPhoneNumber("wfTQnZVjlJh8LwebsUn4");
        corecontacts.setAge(8);
        corecontacts.setFirstName("oSV659R3WaDrsa6DvKtoETqBNjyEcXFX5dh2PN5zf5TMuzACV7");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464157720437l));
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("WMO14wL7HoeaCmi5phjuuXd7jK2apH3QtPtoxNaTguYWQdxROE");
        corecontacts.setNativeFirstName("HaJwkmTz2igFNizrMPzxueaMhzetJlFUJLM0tWCc6jIaSVfeSK");
        corecontacts.setNativeMiddleName("eZQU3BUH8V1zJHDdpW9ihkYxL3T6GfU5WqaEJzwtAlXISahuzw");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("ofW17BgngKbErKR4S2CrhIValWyyftEfhfMQjfk3iqW76WZVte");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("MeLAhgIqwi1ZalMh5fKkjMqezpeG9GeJoSGfRGimUR90qZvAsc");
        Country country = new Country();
        country.setCountryFlag("etu2ke4HMb7UeXGK5erfXJj5Z8RBTKgzTd0a88qOVO0OTAQjNF");
        country.setCountryName("PSByaWvjM8nYPMF9wwyXlYrV1ZSEEC0hDcFFJfaBmqkJ1IVThz");
        country.setCapital("6qGGEgcvZmg5FcT669IS1COH8a4vcPwZ");
        country.setCurrencyName("mLTJXQMGuxKz2EehrVKbJCVy3jErfdL6mrQ3WtT6FlKBAZ4wcH");
        country.setCurrencySymbol("IQnjnVfu8SHdTpdhCbKRpcyro1ZoD4Oi");
        country.setCapitalLatitude(1);
        country.setCountryCode1("4uf");
        country.setIsoNumeric(674);
        country.setCurrencyCode("Zfg");
        country.setCapitalLongitude(8);
        country.setCountryCode2("03H");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("OHuPkUjPHNvoEezd1wN0fuMK3hzXz4R474O7NAh0Wha0tZv8LJ");
        State state = new State();
        state.setStateFlag("AM0JyiSp17QqQaMz8r87Fk30bfhLhBMqekvjxkMUibGEe75QHF");
        state.setStateCapitalLongitude(9);
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar2("rp6Etv088Xg44Ing8lJMH2knnPIMMnXg");
        state.setStateCapital("Znu6EfCHNvAoX29xohKK21Mk0djhjDyv8RJeAhgKDLUU0WQs8r");
        state.setStateName("HrjS5UALNgT9YuJRojNgvTAfUhttca79eHOy3OZm0aocu4En8H");
        state.setStateFlag("5ITBriTvhdhLzpDcqfbV5yHlsHhG6EF4tYFnXwLWisiQMcXfpk");
        state.setStateCapitalLongitude(3);
        state.setStateCapitalLatitude(10);
        state.setStateCodeChar2("nbtUPZ1NxKmcJvcPS8FgA88SVGHK5YYd");
        state.setStateCapital("dRTK6HGO01JMGI64kddREy453pRbzDHrbkxekdVfQ0D8lH8CyI");
        state.setStateName("Hkt7qYvMfJRN6e9XwbgHdfNnCWF1FBADUXGeN51kn2WDPEzu85");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(2);
        state.setStateCodeChar3("4mXwRr68eSbO83zp0HiX3dC8sc3cW5Ab");
        state.setStateDescription("Jg1MHrTB0Uv0AsaSESTr8S90g7EKNPgqZ5VUxlgu8gBCO6791v");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("f83ewkuJB1ozyFCCRITiAMCwdWT4H5Ml2065NRV0WJpRsRZQxd");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("yWXOtycTBUWCmbc8hIWM2VnyhzafPxLthxLzC0q3d1vglTb59P");
        city.setCityCodeChar2("dbwivIq7BY9WQii2AevYLK20wf9SecXG");
        city.setCityLongitude(11);
        city.setCityDescription("e5xxkB4hm8uDj2NssAqw4oS9JSKnsF7z6gg6cvc49IOnIaA6ah");
        city.setCityLatitude(11);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("gtNvFeyUngO1d9AGn0kGaJWEUyVGVvDwMlSxcwM4fpxmdBcEnD");
        addresstype.setAddressType("h0gtPnSaWykUbuDcwQktOudIGE8s8iy11oGucoVispazCcwGZH");
        addresstype.setAddressTypeIcon("ix6xux8kXJh40GMQ0t3trL0zyFIjxBtPLiEg0N90MvKIkXbGAd");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("9mDKIQzF4nVOIn4Cpopfw4kysu5fsdDIcySCPCtDqhd0Zv9Ppn");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("YFoWabLoCA78HtJtoYv1jYfLJo2DIvmDNsYcqpQqofBZbm1lXG");
        address.setAddress2("IKLIlQpmltLbSvXI90vjY2WVndeXbZE238T1tHvGgaNAdxYIjy");
        address.setAddress1("TA1RBi1aScVC438lVFZSWBVZwNYWuUQHWWYQBrNvJ3iCAm1Gw9");
        address.setLatitude("O09YWg3rifdpBVAd6g5dNa49oI6iHU0lYglDjN2Spmq1k4KYXX");
        address.setAddressLabel("imDz8MUx72s");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("V5Ndey");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("wpdlj4DLZDyl0GLMY7HikSyX5r65yTLJpglIefSze8gTKGQvCp");
        communicationgroup.setCommGroupName("EUykfRPADNF5v67VrzhuMZEOKBZPWXcwyaD2bKpFRo9uilEIvX");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("bXRZ4UJderLQjBMIc53RBiWBZy7KR0sDz6Q8ObFSUL1fvJUYug");
        communicationtype.setCommTypeDescription("ny9M9ECwjaw9fU1yVNDL7FrznO8h9Q2HRdMmXWR3yD4LUEcOmf");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("R9Q1SdTjajcg5zWTAN845v0tdK43p4peTHcGYVBjdWhYsWLAqm");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        communicationdata.setCommData("8TVYGjFWmA");
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
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeTitle("BvOgfdaEgnga9Z2ElMieDtsvcnY9404OVWzxlDJxv6OM65s23x");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1464157721049l));
            corecontacts.setLastName("ZLl99s2wMVSAkesVuXjHnUE25YqNmxo6VOcLXQ0Un2l9NbQf1Z");
            corecontacts.setNativeLastName("ju4n9iNOTfwvzPygQcOQ0D8OPCWtxBqcJcJoAB08bKfeKnMyJJ");
            corecontacts.setPhoneNumber("BCnXTjpDPN9TlK3aIKj0");
            corecontacts.setAge(37);
            corecontacts.setFirstName("gait2tAFCmppB4v2IAnZG8G16nFHg4GkiDm95jHep3yAYZzF45");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1464157721159l));
            corecontacts.setMiddleName("oUoI9zYfzyuP8JSz2n4kkf5uCpzOPdjUUqsW1xdsR0mCuWECcv");
            corecontacts.setNativeFirstName("6TRk0JB3bqfsLNHtvrr03vHZhh3VPp1W0xpAwO2cMQIOLD4Bdl");
            corecontacts.setNativeMiddleName("qIVohCT818fmYRe7Rd2v4zngE1EDBDeNnvGlBwzQNQQrRPDgUD");
            corecontacts.setVersionId(1);
            corecontacts.setEmailId("DW5uCtx5msNR7YE76V4KI4ZzhZ5j8YB5zsyIFlvXnQnEZa0t36");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
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
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "qlWJkOxa3r1tL7Sixz4FmLwKTrUwwzdZ8tRG8WQCli8qVUjmZFRiFLhlZRKljFf0lLarO0CAfsqbNTVfYLyK2371vJ15xBmbvS8piXGkPJaQ0ZMgz1wM9rfEfn95S7W0rPPnuDxAhX4jsPuGAuIBrOyr5me4XepTi70pttN4TgpJCpnZdoQw1GU9RjlGyNShQuekeZGnV9lllKY1Myw1UpJzv73KRulDHrnXAXzv5cMayOMUXFA1GRnE5bN9we4RL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "TTQ8rqQX622zxbXkBmf0eIVqltqbRpTQfXGUWLhkUZE939Xr7KFfrhrzA97XsCLykacko7AFKB7NUjZGuPuuI4KqBB1uxHDdWeyDWZvi1bzMlzZf95XfrCmmPi5Mvxmg0YloFHra5eNf0PoMdzQAYDY7DBbIdIg0faWAW3oVqtq9xBn0KSYI336xZ7MiLiW7QXlnGnEZZeyfIlevrUmiSvvTgAl1ZLMYKQ1wju0ZdRMSjLm0EiOdEq9negE1gWuV0"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "1nZwpO5GbppfLAn77jod4WaRjmHYQWbXtRbhieMEvVFWLZdavKX9N2GfdETnfcAF8mYyOPAFBD1MNfWD0ko7gtrYIW296wV7mLVpdlXLLgInZKLRlCSw9FRnbNzWd8UkubJpLIFmSEVj7DzoBsM2kA6ioSzwIXdEHAH0VjO1Z0OMaq83amjUGTuCIeTW82uIp2w4lIiEEnADcJmBefXiyd1wgt62XsVmlVLXb9m0sfdUvnnSmItGSioSq2FXO0E0y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "YZpcA2Hoh69cAVHzaTACOJV3QvqXGRQmdVJ7qrdUuHZ0UO6DVJBTmf7zRdg0oGkmo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "2ckrV2m5Jzb3S2tW8djXk8Aec3qc1ZSYbKTHaettN3btAhAqG2YjoSm455WNkzgqtQpfx1GyimShZlETJU17aXFzw2sCHhiry7Jx2ex43KFuRTMkwlRuwiHwGuigFkk0d1x7EmJITvvQP98muCmzLtM4TD5xi7ILK1FOCVYZpAAbyXCQuLIwq7mrOLvBbjJn4S9ey9TuO3ark8UGd0wDd3Z4TwXiuacPr4Q5y5F2HPAASTUorh2CWmAIF3b1YtNJG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "vF8sboxnH7f8GatcANMTVbRIOd09d11gXklPKNevb5oER5VP31NUGNsqxGJS7rQMk9s0p4jTdermCCSU6MRVuOos1xtSkKmDdv9GQJLM8GtS41UFGnLKoJrdoUaTA7lmg8tOevFqoQokYUefNhjrrDGkwl6j6bLMRCWaR5PahJR88vdkfAJQW22AlResz7cmaW6yBtai3jCIqmS13sE6jdmmhASEG1sBut0ss27niGvy3LZK1eCC3ygZKHaeAD7G5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "XGbGvJnQ3TYrzbTQQvCrIrrO8dJQN3mcigFuuozGjBspmzjonGFOV2aQBxFUpmVgTlTssvpIeOY8fJ8hnlD5Qb7mLmOdFEK6eJvP7BS8cb4Cj2sZOspp0nouOSmEo9d34qmEgunwxn5mERcLDPnKrhC0P08V2XP1qx0gOnp8mZPBnpLt6pyRcx14VeM4W2ybD2Xo6nTbitNUHkXCmkAdLCiDQarytglFAHP2Jovh5JrYYcCACSHUynxhKvXjrImDi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 180));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "vgnidBc7OcsOPJHC8NIsqHehfRUnoyFCgCsavYksiKl6kmwuWEQQOFwMtLegmJQdoRcsRo19Crv1r9ZEOaIVIOoa51GIZgseuzuCrdhFeXJFCnOFxvl91dCFlDyNkudPI2uKLuzKCBoimU5iVx4EDnB1jPv6MuDlmkhxZht2NUspCt4FuiV97L6wHPpj3XcjMTchSV5aP50TPKPqFJNPkAljiVKDCXj8TnSNIK5tErEG9Eo7IIkZAr6RgbcBAcOOH"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "dOYZcJVKASX9D2ZFWUvDp"));
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
