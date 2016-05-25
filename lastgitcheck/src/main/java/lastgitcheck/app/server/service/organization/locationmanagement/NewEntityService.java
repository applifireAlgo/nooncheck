package lastgitcheck.app.server.service.organization.locationmanagement;
import lastgitcheck.app.config.annotation.Complexity;
import lastgitcheck.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import java.util.List;
import lastgitcheck.app.shared.organization.locationmanagement.NewEntity;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for NewEntity Master table Entity", complexity = Complexity.LOW)
public abstract class NewEntityService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(NewEntity entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<NewEntity> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(NewEntity entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<NewEntity> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
