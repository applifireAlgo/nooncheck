package checkgit.app.server.repository.organization.locationmanagement;
import checkgit.app.server.repository.core.SearchInterfaceImpl;
import checkgit.app.shared.organization.locationmanagement.Checking;
import org.springframework.stereotype.Repository;
import checkgit.app.config.annotation.Complexity;
import checkgit.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for Checking Master table Entity", complexity = Complexity.LOW)
public class CheckingRepositoryImpl extends SearchInterfaceImpl implements CheckingRepository<Checking> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Checking> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<checkgit.app.shared.organization.locationmanagement.Checking> query = emanager.createQuery("select u from Checking u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("ORGLM324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CheckingRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Checking save(Checking entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("ORGLM322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CheckingRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Checking> save(List<Checking> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            checkgit.app.shared.organization.locationmanagement.Checking obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("ORGLM322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CheckingRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        checkgit.app.shared.organization.locationmanagement.Checking s = emanager.find(checkgit.app.shared.organization.locationmanagement.Checking.class, id);
        emanager.remove(s);
        Log.out.println("ORGLM328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CheckingRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Checking entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("ORGLM321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CheckingRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Checking> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            checkgit.app.shared.organization.locationmanagement.Checking obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("ORGLM321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CheckingRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Checking findById(String checkId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Checking.findById");
        query.setParameter("checkId", checkId);
        checkgit.app.shared.organization.locationmanagement.Checking listOfChecking = (checkgit.app.shared.organization.locationmanagement.Checking) query.getSingleResult();
        Log.out.println("ORGLM324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "CheckingRepositoryImpl", "findById", "Total Records Fetched = " + listOfChecking);
        return listOfChecking;
    }
}
