package checkgit.app.server.service.appbasicsetup.userrolemanagement;
import checkgit.app.config.annotation.Complexity;
import checkgit.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import checkgit.app.shared.appbasicsetup.userrolemanagement.Roles;
import java.util.List;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for Roles Transaction table", complexity = Complexity.MEDIUM)
public abstract class RolesService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Roles entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Roles> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Roles entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Roles> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
