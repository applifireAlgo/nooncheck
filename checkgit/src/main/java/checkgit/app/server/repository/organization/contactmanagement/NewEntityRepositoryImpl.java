package checkgit.app.server.repository.organization.contactmanagement;
import checkgit.app.server.repository.core.SearchInterfaceImpl;
import checkgit.app.shared.organization.contactmanagement.NewEntity;
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
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for NewEntity Master table Entity", complexity = Complexity.LOW)
public class NewEntityRepositoryImpl extends SearchInterfaceImpl implements NewEntityRepository<NewEntity> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<NewEntity> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<checkgit.app.shared.organization.contactmanagement.NewEntity> query = emanager.createQuery("select u from NewEntity u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("ORGCM324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NewEntityRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public NewEntity save(NewEntity entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("ORGCM322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NewEntityRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<NewEntity> save(List<NewEntity> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            checkgit.app.shared.organization.contactmanagement.NewEntity obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("ORGCM322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NewEntityRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        checkgit.app.shared.organization.contactmanagement.NewEntity s = emanager.find(checkgit.app.shared.organization.contactmanagement.NewEntity.class, id);
        emanager.remove(s);
        Log.out.println("ORGCM328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NewEntityRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(NewEntity entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("ORGCM321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NewEntityRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<NewEntity> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            checkgit.app.shared.organization.contactmanagement.NewEntity obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("ORGCM321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NewEntityRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public NewEntity findById(String entityId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("NewEntity.findById");
        query.setParameter("entityId", entityId);
        checkgit.app.shared.organization.contactmanagement.NewEntity listOfNewEntity = (checkgit.app.shared.organization.contactmanagement.NewEntity) query.getSingleResult();
        Log.out.println("ORGCM324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "NewEntityRepositoryImpl", "findById", "Total Records Fetched = " + listOfNewEntity);
        return listOfNewEntity;
    }
}
