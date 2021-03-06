package checkgit.app.server.repository.appbasicsetup.usermanagement;
import checkgit.app.server.repository.core.SearchInterface;
import com.spartan.server.password.interfaces.PasswordPolicyRepositoryInterface;
import checkgit.app.config.annotation.Complexity;
import checkgit.app.config.annotation.SourceCodeAuthorClass;
import com.spartan.server.password.interfaces.PasswordPolicyInterface;
import java.util.List;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for PasswordPolicy Master table Entity", complexity = Complexity.LOW)
public interface PasswordPolicyRepository<T> extends SearchInterface, PasswordPolicyRepositoryInterface {

    public List<PasswordPolicyInterface> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public T findById(String policyId) throws Exception;
}
