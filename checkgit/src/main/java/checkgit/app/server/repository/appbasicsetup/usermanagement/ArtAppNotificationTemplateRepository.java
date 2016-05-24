package checkgit.app.server.repository.appbasicsetup.usermanagement;
import checkgit.app.shared.appbasicsetup.usermanagement.ArtAppNotificationTemplate;



public interface ArtAppNotificationTemplateRepository {

	public ArtAppNotificationTemplate findById(String templateId) throws Exception;
}
