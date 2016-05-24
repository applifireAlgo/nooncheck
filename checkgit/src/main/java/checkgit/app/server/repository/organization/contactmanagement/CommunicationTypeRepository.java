package checkgit.app.server.repository.organization.contactmanagement;
import checkgit.app.server.repository.core.SearchInterface;
import checkgit.app.config.annotation.Complexity;
import checkgit.app.config.annotation.SourceCodeAuthorClass;
import java.util.List;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for CommunicationType Master table Entity", complexity = Complexity.LOW)
public interface CommunicationTypeRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public List<T> findByCommGroupId(String commGroupId) throws Exception;

    public T findById(String commType) throws Exception;
}
