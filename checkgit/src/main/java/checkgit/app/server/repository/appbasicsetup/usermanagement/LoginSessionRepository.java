package checkgit.app.server.repository.appbasicsetup.usermanagement;
import checkgit.app.server.repository.core.SearchInterface;
import com.spartan.server.interfaces.LoginSessionRepositoryInterface;
import checkgit.app.config.annotation.Complexity;
import checkgit.app.config.annotation.SourceCodeAuthorClass;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for LoginSession Transaction table", complexity = Complexity.MEDIUM)
public interface LoginSessionRepository<T> extends SearchInterface, LoginSessionRepositoryInterface {
}
