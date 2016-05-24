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
import checkgit.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import checkgit.app.shared.appbasicsetup.usermanagement.Login;
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
import checkgit.app.shared.organization.contactmanagement.CoreContacts;
import checkgit.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
import checkgit.app.shared.appbasicsetup.usermanagement.User;
import checkgit.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import checkgit.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import checkgit.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import checkgit.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import checkgit.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import checkgit.app.shared.appbasicsetup.usermanagement.PassRecovery;
import checkgit.app.shared.appbasicsetup.usermanagement.Question;
import checkgit.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import checkgit.app.shared.appbasicsetup.usermanagement.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws Exception {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("jz9dJWx2Z150uZbsAPNw");
        corecontacts.setNativeMiddleName("NUz0kfmiAzXBLku2DcPGlYIuxwdkjzbkPu6lbC1FDQn9KYIk4k");
        corecontacts.setNativeLastName("AA3HwWdFBNQwetga7lpnrj1nuye2G6e9ck4tHOsywvtR35pYP8");
        corecontacts.setFirstName("uEWvRZuLvtrbEfZaa5NK5WtjkcD7lU6sFedUq4uElK1uPyc7SD");
        Language language = new Language();
        language.setLanguageType("uMiJWRAyVceCsVzCoxmpdxUu4qHMhSP2");
        language.setAlpha4("MNXa");
        language.setAlpha4parentid(1);
        language.setLanguageDescription("piHwtfGSSbGxBr2LfhNY7HAvo3YzMcEVGlBm6l5nMr1Dgy5sPS");
        language.setAlpha3("lIS");
        language.setLanguage("uiou4NmxX8dZ3QzdFuhmGYLVT8SQxCsC5jO9bAseEZM038SkBZ");
        language.setLanguageIcon("86NTDTfo8FTqPcZ4MzVgiwBZMIzoSUqMamJTsMjh9OstpYUGpS");
        language.setAlpha2("o6");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("mcszhpdGJyNJ2ZSmLtqMLkTcCZ12rUYgClXTO1uDvse2eSI8Mv");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("lQTXYiLsHsn7t1RJvKmYVVEyTyRO2R3vX7Oj32eUjzjhFbMGJg");
        timezone.setTimeZoneLabel("n9GaZaw14iTW27dwTFYYV6u7K5P588UniBGbYTU2V5lYgUhaah");
        timezone.setUtcdifference(6);
        timezone.setCities("I2OyYXXVXTx9AjsRk1z3YgNcL3mi6IYsRlIxAOyJ15zJKWbQEw");
        timezone.setCountry("ndAHhyw5lLDJqB1JrjOMOONPSQ5T0xp6cWShQh91NlKNZZqUDH");
        Gender gender = new Gender();
        gender.setGender("dyu25Z91gnBY2LOaXpWqep8xucbyXkzHcRigGgh6gbymAu8cuD");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setPhoneNumber("iMlFCKfjdEiUgOYIa7ak");
        corecontacts.setNativeMiddleName("azZiEVol2JWe0eB3xHK3FSlUaLM54nxtEHt3128T76tI0wP6Ec");
        corecontacts.setNativeLastName("6B5oUv4l2wvCNrroMKRIu6nJ29NAGDxmRP4j438aCxP6CK6s2o");
        corecontacts.setFirstName("XGpF1gH4QcnQCM2Rjxbe3ARNcq5T3CEMVBSWV8FCH8jlHOqpOz");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(53);
        corecontacts.setMiddleName("AWMXz2Q6jzU4piA17VeJLyeQYK0bQU6OjhzWHcXJeJkBoE5uWS");
        corecontacts.setNativeFirstName("MrN4mtRx4uJnLS42fUyFOYUNyU4ONiKpQp0aE0H9g3yjYoxOyj");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464074780662l));
        corecontacts.setLastName("0OEUliWowb0al5qErraOnltuoRjHC9MfcgpV7IlB2ZPyT0nojQ");
        corecontacts.setEmailId("B9yXyE4t2CRfG1yssAcRR1yx2zdEQlNKtvtugr5ahybeen3Af0");
        corecontacts.setNativeTitle("kJlCqZ0Ga3ZZQ3R2YbXjED6jVcBPjkMqf8PIbFy7HyIcj4VhvW");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464074780705l));
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        City city = new City();
        Country country = new Country();
        country.setCountryFlag("OV4SDU9fahAAeVp8ss8HK8iPfwR6D2D2SLMHHcyaZYV178MElA");
        country.setCapitalLongitude(10);
        country.setCountryName("uz8LHDRu0BmunbD8LG6fV0J4l2FWKbGmLFeWQL07R0Nais3kBG");
        country.setIsoNumeric(723);
        country.setCurrencyCode("qog");
        country.setCurrencyName("pS15mSul9LZF5Wx1NPtkFiNl2ZFCefjv619dIeT5ftlzlgOcSX");
        country.setCapitalLatitude(5);
        country.setCurrencySymbol("9G1KM92kxpJ7kYc4jlTMZ3Bw1eCo8uuB");
        country.setCountryCode1("wgg");
        country.setCapital("FF6o0AZ886Sr4QQkMo9LlK6kB3vwmOnz");
        country.setCountryCode2("Yb1");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("i4sW45ovbuoHRnLebBEQlbdzrOLq3NXgwSgRAcaDI49qMigXPP");
        state.setStateCapitalLongitude(3);
        state.setStateFlag("lhFs68o17h8xVnANXMthRN5ruxtxNRfgOp4qwguqrF6Og5JATq");
        state.setStateCodeChar2("L22FW3wDulI4W5L53YEzzb54EY1Qpv6i");
        state.setStateCapitalLatitude(11);
        state.setStateCode(1);
        state.setStateCodeChar3("ZLavxACVERM6NK8HDaAIE1jnoc9ssGxT");
        state.setStateDescription("AheYro0maiWqM35eWd9t3t42RNeLRY5js0NaXxnjIChah1R5Kc");
        state.setStateCapital("TIpmYvOCaunhorQD3Rv418qisa5ucHofJxqIwLxvINwt5oKmX1");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("j1fxicyvQfVueINbxGyw0v6xmwfOg2Mlc4Bs4gKQFfUjcWsvYD");
        city.setCityDescription("kHFVRpxcMtE3O9nlMa2Ue7jbLXhWWoBfiAJj28trWJzdKr0zi4");
        city.setCityCode(1);
        city.setCityFlag("lWTM8nnZZ2FsIAfFa72taKPjadlR73MaBpt8leRy0vdRrS0eFM");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(5);
        city.setCityLatitude(7);
        city.setCityCodeChar2("lie6tNmcMWfWJZkuopQO8fIAwcVDCjx0");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("4pyTnhYruVbg9ipfYAx9qLHLISpSa3EpQuJcjbaCoCOg8wYm2J");
        addresstype.setAddressTypeIcon("kjVGYsOyHUQwLbHoOQNczJJRlgL6GJdFNRxwAk3ebA0JufFAgn");
        addresstype.setAddressType("JHR09WhqjTdNduqdTzrUbOssEyts9lqBFUMIola2do3e3hiHxn");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("nE30ej");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("w8oSUnZFvzwbxloJJjofEHu3WXSzAHH1H2Wq1RxdzrOphQarj4");
        address.setLongitude("2NZZupmYZbs61i0CJ2nxUObo1cYu8kxoUzO44LEDKaFh1g0Ntx");
        address.setLatitude("wmmNuIAzuKsrDfKFEIE0DWRAdh12mpOhjjxrC178VWdLK5405s");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("l3WQ3yiLYVcKxBErOc0TheFFuFq07djh246wxogxjt2D8mlRYT");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("myCwblwyGAO");
        address.setAddress3("cdFTbVzhsL82pgEViYtI8TwO3uvZ5qO44iPObawuZ3rjYcKGip");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("gZvXYguGDH");
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("sHFqeUUOGQ4fmjhwxh3URvxbK5xMqD1PrgUljgiGDUapKBRbSC");
        communicationtype.setCommTypeName("xkt4bMH0soUEcBmiwfJdr0InBTz1YTQqDyfU3FNknz3befQHNe");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("t7l53B7eugKadX2rMWNI2lTKr8ny7HOavkR4uwXBfw90wn3u72");
        communicationgroup.setCommGroupDescription("SgGbzQsIrla1ApCX4r9Lo2FiyLhFshRptxBzdIqUnRqwhIAJhI");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("uSymDnzN3azJVIrBYINNEwrdkwoF7cF4upuzZ9hBNn2TZhuWrW");
        communicationtype.setCommTypeName("kPtHGb5FKE89LJHPLWUSmy8OONDepVYJ37NMxz9la1GzHmSwg5");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("fl7kYVjmXp");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setIsLocked(1);
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessCode(7588);
        user.setIsDeleted(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464074781115l));
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("IbxIlzdvMldNIKzbniKjOek76RFicT8lwG4YbZrybnG5lxxZsV");
        useraccessdomain.setDomainHelp("neV2L3l4uuj3eIMbLZaxnwDJrRPROEB5aeUcYNv40ejxdq03n1");
        useraccessdomain.setDomainIcon("H3cRVRuzEYKTHtwB38rRPPKhhv4hYfQSuBIfBrAx8D62U6s8Fd");
        useraccessdomain.setDomainName("LFy4c6Lc3EcZPBWindk7wYvqb0OggjRJBaGiRIKTEJ9pj6ajjW");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("yjedjkz38nBV5QBgUOtnrwRZ4sMJPomU7OfRD8ieEKv47E3JAl");
        useraccesslevel.setLevelIcon("b37SAWe0w4drI1zQvzUd7G8xHiwKWbClHQ8wEHhsbgUrEtW40C");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("A7wmSlw6yXH5KXPqGqva713yUJ29j7zPOEY43n7cf5t9y4sPnP");
        useraccesslevel.setLevelDescription("F8oju8AkzC8lfRnytqEcUeA1fFt9AOnYvUvivKmyFUL3iu7hPb");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setIsLocked(1);
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessCode(2066);
        user.setIsDeleted(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464074781143l));
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setPasswordAlgo("7mnsZaWroy0WSi3k6zUU8cXV5q3Czl7iQeTo5DGhpAWIjVZi3o");
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1464074781203l));
        user.setGenTempOneTimePassword(1);
        user.setSessionTimeout(1553);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestion("oEBLy2HKhgO88Zpfaxi74fBaC0R8mYtg2VBU8CGIOrtusUiSqf");
        question.setQuestionIcon("37DnXva0mqHZD0foCGKFMgLSAS6iwpaDtjXP8F5O6TbSBfsyCd");
        question.setLevelid(3);
        question.setQuestionDetails("WACnbA1CfO");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setAnswer("djgxzbfRWf8X7PdGRXgnypgFrnVAAn0IDPCHoBy3l79Nh5gne0");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setPassword("OnASXEbxDrqB1OCIpnHVza4etG46RpYIvdJNvOh24QJlE1KIY5");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464074781359l));
        userdata.setLast5Passwords("VI8m69dLiMOVMz7FFAZ8xoQIEkDlkEJn6aq7z2DuhOwDRuzuyP");
        userdata.setOneTimePasswordExpiry(11);
        userdata.setPassword("Em08dUSzqlDbWuGUf4lLWurT0HWXKm2R30L7kkxqYRVoYxo7H8");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464074781374l));
        userdata.setLast5Passwords("Dk9WL6Q2vhKGemrrIbetgXR4mjq2QQyZGNKkpRsXGeKu8X5zq8");
        userdata.setOneTimePasswordExpiry(9);
        userdata.setUser(user);
        userdata.setOneTimePassword("DlKrz93WLTjm4evG5gLSuQpcHxiAiHyf");
        user.setUserData(userdata);
        Login login = new Login();
        login.setServerAuthText("VayQPfFmtlD8Xaik");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setLoginId("7iQw2rVihdK0BxfsV0R8QP6R5K73FcGi6pIbPPTNop09hNu8hj");
        login.setServerAuthImage("7QyCONFlHv5Kfyy9o8pf8K4DivWdkROm");
        login.setIsAuthenticated(true);
        login.setFailedLoginAttempts(1);
        user.setUserId(null);
        login.setUser(user);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthText("CxOBfg8q3vaEKHR7");
            login.setLoginId("PF1Vw3Nn7kk5RkkvMazPHFwyOeeF4OEr2eTTNOa3hgIPlOyIEh");
            login.setServerAuthImage("XN9AgwzesNUdhjs6y3Uht0At0zagmjAP");
            login.setVersionId(1);
            login.setFailedLoginAttempts(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "nUkB24Nw6lTeHvDVQzdS8fLnMNS7al7BbOiUvVlKtYdptbdMjPKJZpotPrh1qoUYf7x93aoZR1Dgo5YTZiLRPUxsjcfYfYrxR9xtYuqHWeTLFve747sR4acikCHEkUhBn4kB63YvczlAipgm1QcNpJ4BZicJFb5ns2hx1PRFBeUHkSRNAR2e0p5W0QdoMHPAwtlM0ZrWw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "T12yK2LjkNA04bw4IAQCTkfx36AvSFtJN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "bbeK4tO0DoM5Xuehr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 22));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
