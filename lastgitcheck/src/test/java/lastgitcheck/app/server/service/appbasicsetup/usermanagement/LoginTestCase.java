package lastgitcheck.app.server.service.appbasicsetup.usermanagement;
import lastgitcheck.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import lastgitcheck.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import lastgitcheck.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.Login;
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
import lastgitcheck.app.shared.organization.contactmanagement.CoreContacts;
import lastgitcheck.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
import lastgitcheck.app.shared.appbasicsetup.usermanagement.User;
import lastgitcheck.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import lastgitcheck.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import lastgitcheck.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.PassRecovery;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.Question;
import lastgitcheck.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.UserData;

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
        corecontacts.setNativeTitle("YLyhiPHMCIzzRYyAG9ixcMnKUL5C99tz9pgIGoruUbySWxsF61");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464157729007l));
        corecontacts.setLastName("zNpwGPZ20jS1IUDZI2P8XN5r9nEAzcf24pPZA2A5z6JFUqOKmC");
        corecontacts.setNativeLastName("o56Ai5W30u2QtCa0rttZExkH0PL5jac3iJ88DojdMJIujHZspy");
        corecontacts.setPhoneNumber("YEoubNupvyCxmAUzAx03");
        corecontacts.setAge(46);
        corecontacts.setFirstName("Yq8WOgXXp2DueP06zdo3ljxr2kjuUtCdnLZehb9sqdv18EMMLm");
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(4);
        timezone.setCities("9DLmN1Hr8RRP16SnIONtr7JFtnakC7QPdsy2uBHl2YhU93rYfW");
        timezone.setGmtLabel("NSwmOeofT6ft3Dhh8N6gkVdqLiAXt43IKN8ZckAyL9XF5j94H2");
        timezone.setCountry("w5dE9NMHQIbtJTUXJekjQ0bUxn5v0ozF3Z9L73eumXs0bMZjl8");
        timezone.setTimeZoneLabel("mr2NjwklsjRDMuVXpclSovHYYyWaB7CMlY2VnXsyj4ujuy5FHE");
        Language language = new Language();
        language.setAlpha4parentid(11);
        language.setLanguageType("BxneTfyfwEQAqTWRnzFoTVjKnnfrNbmx");
        language.setLanguageDescription("OJfW97K0pze3f3gIpGtDYXrR2rvQ6lCWJjEG9hP2GtHuZVwPVK");
        language.setAlpha4("7sGw");
        language.setLanguageIcon("wMys8vTOSzMNouDszDFmoAQMPSFhXFp1BygqIg4I2U9uvlZmny");
        language.setAlpha3("N3n");
        language.setAlpha2("ue");
        language.setLanguage("KCnPPfGPDzZ4pZVxjhYvp2AJstTuzHL6DHjeK1IBSzsoxcztKi");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("LDWNcSzZGuNdlg2A84AXr6is5xQBZHt8e1ixlD2VlEzHbxJR1r");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("NbF6TSFSJU6wsxMWUfANPPORw63Sr7TH7cdVMDaorR3oIzdpF2");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setNativeTitle("BUZOfXqkKbLg9N5gUmWTThMQQPrpUeXh9rcrNTuAtm1uVW1uLe");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464157729050l));
        corecontacts.setLastName("YXvH5ma2HpriQHIFPTXXo9JqxIUqN4nJsH57fDjEZipqpd5ilC");
        corecontacts.setNativeLastName("Vskkxo6gA9E7TaYMPTrstjnEq2AdRJPTQu83JCFSTOaSpHz1u1");
        corecontacts.setPhoneNumber("43pzqfyX6sf1ygK9E2pP");
        corecontacts.setAge(38);
        corecontacts.setFirstName("FOVLkltJzEFd6Kq43LXKlRNsVBfmyCOslRadGzGibNdQ2TFAvp");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464157729116l));
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("Jg2AWBNxXEk0MocNezDNjWtYRj8nkFYKxZnrqaBg3mdz23fCEM");
        corecontacts.setNativeFirstName("YDISFOWJZLzho66h4aXDnBOfF26oAnvxvkm6QecUpPdaxDgzNm");
        corecontacts.setNativeMiddleName("xvob0RZgsJB29pxi0VjQHU4fHOjWHmnNv0vbaeFufMkOSc0mhJ");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("YW5PyW5OWY0bDJLfyynuz5LR5BOMF0LS4w4qq6DVmtVhMdzU3Q");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("DSsX1p5cnrJshBUjiDQKfGSEJNRZ7kOWcjiMH9pA4xkNDSwDj2");
        Country country = new Country();
        country.setCountryFlag("S4R7NmEXx8gt0Sru5z6VgiakvPavSq5L9KVgF449PPxTkaiesc");
        country.setCountryName("9aqOBZIoPCDGTUdsH3mrIhaTUROwFLRtWp8xRI1ZrVyFkfuqll");
        country.setCapital("dtyiSnPcVIIE7Owv2QS8Qdr3WGNIhCwm");
        country.setCurrencyName("fJvzDLGqtFLl3Ar2EBUYB6btejtUc9yzEwgZ7VMJ4bmvL9shU6");
        country.setCurrencySymbol("1gcCrJEqAPTng1m83gcakY8AvdVi1Ub3");
        country.setCapitalLatitude(3);
        country.setCountryCode1("T2H");
        country.setIsoNumeric(401);
        country.setCurrencyCode("obk");
        country.setCapitalLongitude(2);
        country.setCountryCode2("zkK");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityFlag("tCYGznnpCVDiQgnI2cFXhthftwgje8X1aBQNKL7BF67Sj3ZxVN");
        State state = new State();
        state.setStateFlag("50P7lhSo32lfUhbRzM45xFBGrjDgPGnO1TsWZ6ZBjirgaq2bBN");
        state.setStateCapitalLongitude(9);
        state.setStateCapitalLatitude(11);
        state.setStateCodeChar2("YqVHKdqk6puzDZjAykxR30hyiS6Rzsh5");
        state.setStateCapital("Q7EEHadz2YgDoQ9etJ9blbTx6Vzi8mT4UdY0ZnBkJlYZrQkzZ2");
        state.setStateName("iSClxJBUi8jP73sLcAcsfxX8zA1Yh8kW7hPBFVru877toavV56");
        state.setStateFlag("8vLnEInYchJmP7bgW5hbEnJOrXVr3Vp371mzkZgOhpXuDfCR0o");
        state.setStateCapitalLongitude(6);
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("N4cLZFrPtSRZC4pH15FXaW36hhSDPowO");
        state.setStateCapital("rswuiRlrHKkmUZTwmdmb9bP0cD6r3gbJLmS1PqFXVTzVTAjyoS");
        state.setStateName("RPoJ48fS7GKQm35gePSt6CsX7oa34jOWkprrwHEHsUUMRyCJuA");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCode(1);
        state.setStateCodeChar3("hpfsplu1tUt8kH3DgBG0LO5X4UHyk006");
        state.setStateDescription("XaKCqkTzv3MsdM07OXJQNZlyV7DM9odyyYHs4jAu2oGE8jC9jh");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityFlag("0eHAvIwXOKqGjeu5COh1B1hq5Yzq5bw6TliKxscmgy0Fd5I2FX");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(3);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("0lCjSYRwGf2cZ5avJ8Bz92uCKmGP7XubOxOEipQz7VKZqrs10k");
        city.setCityCodeChar2("gl2wSElktMlQpLFsV90T8i4UbgeOOCwj");
        city.setCityLongitude(7);
        city.setCityDescription("yQgfi0AVYBqJ07OtvfN3FVeCuaPIOY8bPtnZQXgCgohBV1ypeX");
        city.setCityLatitude(4);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("zLZrk30YEaNRYYFPQgSEOvLAiHc3sRCXFkA6LVUafVxbzqpkoD");
        addresstype.setAddressType("uPG6mkS8d1d537nsJzYvrrClcHzU7PqGvP3wG5CACMq39sCneY");
        addresstype.setAddressTypeIcon("lmT9Nc0qzp5kpca2iYpGZC4AvDHbGSQ0Zg0l6zyESU0WrGBQAz");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("gGKtMnzrXJSAhyQQ6ZYRjrVKnDRVLfiBfX46rYCU8Mq82MGOpD");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("6CV0eLJ3JD40Nbseo4n5tDeo0bZKimMsxxy0fY6Riajwjq5BzB");
        address.setAddress2("uf7bpmk87qvGUDxZgM0fCLuHGsGpHE2MG8mCLalS4jNS9GoeBq");
        address.setAddress1("EbtsVuss4vzsVSTavY4xu1PsmXIuHaj2xZ7lqpJT5JwjdX2fhK");
        address.setLatitude("RzGfQ1yKN3mLnwwOPjmHtVNKdDGC4EANXb4dpcZJGoAIuDzPK1");
        address.setAddressLabel("261UKV0boTQ");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("GG2iC2");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("FpOZG0Nn0bBFc2uQeXrjZOW7AnyKpG48rNCrpFHve5tgaTQ66W");
        communicationgroup.setCommGroupName("QwfKnhcoJDlNoxT0ysZdk01IbqU5piQ0cXT6anBBMWIbJJ58cd");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("Mle6hWEvgTvhMugsPf6J4dWaezvLYobWbZKxjI2wWl310R82k9");
        communicationtype.setCommTypeDescription("dDJEbyx2dQM9wbsTnpzmCtxN1t8j3doKfXBCMCgyJ2yT5hhYvO");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("k9Ref0Ujf22LlMZw29or9xttNXRggl0gxyHM5iBbRhC3xnHWHX");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("4X0LCdMZrf");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464157729866l));
        user.setIsLocked(1);
        user.setIsDeleted(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("sj9udLjGwqzgl6oBpZuMfL2fNEcvpmS69KIVCrW0icitkrTN6G");
        useraccessdomain.setDomainName("NEpjMB9m5GD42UQAYtlg8Ymmn9mGvEbok3apv1ZJ4RAO1h4YSa");
        useraccessdomain.setDomainHelp("01RGFq5bueKrvkof78Q2gGvDyFNVaWCpzQuUPGLm8dNIaWymFT");
        useraccessdomain.setDomainIcon("lugo7IHGVW6rNZGeLealRA169SsfwHFNL137mMC6fF2gCv7phC");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("OIUvXmvSKhrdXdySFm4GvJB0oaKj7kAIQkgVE9l3CKq7rt4a27");
        useraccesslevel.setLevelDescription("CXvJvrQwXgtXnhvIRLarqoDooBEoz4icXNlucctBj6JkWCPTG9");
        useraccesslevel.setLevelName("4fxbsSwavNjfJSN9LnYpW3SrS3R5iXrUjmOiG3inmkuRyhgo5U");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("1i1bXeOvUY68JAHgPyI5VDuneIo1LLTzs8bWkzXCMlQascSdzw");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464157729912l));
        user.setIsLocked(1);
        user.setIsDeleted(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessCode(46215);
        user.setPasswordAlgo("mH23FJEPvSvCkNyoT6QJ8ObmGLOFU2VYkvyM5eCT3r0egMXffd");
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1464157729950l));
        user.setSessionTimeout(3340);
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setChangePasswordNextLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestion("KXpFF5S2UnLb6mxWRmBzVIoi6oJMXOMUV5VoAbRDXQxKCyWgXN");
        question.setQuestionIcon("wIcmVV95SlOlqFG8clhtRaPWxZekvPkonmz81CyqrPFBIFo2Py");
        question.setQuestionDetails("rtag3caSPy");
        question.setLevelid(1);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("iBEE8I8uWxAXW1GO6tyFnuXUghEjjIe0uL5PXBRTawHuA0xgkb");
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464157730113l));
        userdata.setLast5Passwords("aPwFhP7YZPpi6qUlUg2y0edaUnWX0gWGPlUsxsOIDQ0d9FIemJ");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464157730127l));
        userdata.setLast5Passwords("zu55WP6EkHGcV0jLinItNf9Nex8W4uH7CMXqmE699L3t5pMFZN");
        userdata.setUser(user);
        userdata.setOneTimePassword("i1I0Idl9R1ovyB7BGKz7dDCSdMyvE9Oq");
        userdata.setPassword("Ro0L66MiqCUVyNCDqQpdCIbuzp1IfUW0JmPq6ib9XovQkT7OLU");
        userdata.setOneTimePasswordExpiry(9);
        user.setUserData(userdata);
        Login login = new Login();
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setFailedLoginAttempts(7);
        login.setServerAuthImage("jya5ydKkRsZbDh4IWdk1qQidtn06mFMW");
        login.setIsAuthenticated(true);
        login.setServerAuthText("mBNl6n32XjGbO0ey");
        login.setLoginId("fosRubfJMln2vf7EFQ2l7wsMML6LdG6DRhh0enw0gbJBSrYNPw");
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
            login.setFailedLoginAttempts(2);
            login.setServerAuthImage("Gc6FZokMqMyzxqm49JnOIFHElE5AO57m");
            login.setVersionId(1);
            login.setServerAuthText("IUXBVISZ31j5Nk2f");
            login.setLoginId("1ERrmbkEITEtmFnN2DuqcnyzpJjURWeD9gX0SdOcnD5KrZNN8O");
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
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "a5wTCLyk9YjxYMh5orYdnYmADotNSCmQ7oWX2hqUZ2XKIpCQxSZPbb2oXSPmTlpU8DjlUpIZYTRBowiWD4s3jWJSu6AbDNXX5stE5HUWS2pGKxPrJEA8YhxuVu29JeenyPzkfaEv5z9mrlrIOd4DgMCLt748p4pIGYmWwRY9tW3f7F5TK7KVJaCx8wZQAVSSAos94k3GW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "QK9KN8w02D89usNP3CcsYxsUACCXjpt9y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "fV0lF71i3TXnbzb3U"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 21));
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
