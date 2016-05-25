package lastgitcheck.app.server.repository.appbasicsetup.usermanagement;
import com.spartan.server.interfaces.LoginSessionRepositoryInterface;
import lastgitcheck.app.server.repository.core.SearchInterface;
import lastgitcheck.app.config.annotation.Complexity;
import lastgitcheck.app.config.annotation.SourceCodeAuthorClass;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for LoginSession Transaction table", complexity = Complexity.MEDIUM)
public interface LoginSessionRepository<T> extends SearchInterface, LoginSessionRepositoryInterface {
}
