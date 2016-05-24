package checkgit.app.server.service.appbasicsetup.usermanagement;
import checkgit.app.config.annotation.Complexity;
import checkgit.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import checkgit.app.shared.appbasicsetup.usermanagement.PasswordAlgo;
import java.util.List;
import java.util.Map;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for PasswordAlgo Master table Entity", complexity = Complexity.LOW)
public abstract class PasswordAlgoService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(PasswordAlgo entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<PasswordAlgo> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(PasswordAlgo entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<PasswordAlgo> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
