package checkgit.app.server.service.organization.locationmanagement;
import checkgit.app.config.annotation.Complexity;
import checkgit.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import checkgit.app.shared.organization.locationmanagement.Country;
import java.util.List;
import java.util.Map;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for Country Master table Entity", complexity = Complexity.LOW)
public abstract class CountryService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Country entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Country> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Country entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Country> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
