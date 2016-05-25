package lastgitcheck.app.server.repository.appbasicsetup.usermanagement;
import lastgitcheck.app.shared.appbasicsetup.usermanagement.ArtAppNotificationTemplate;



public interface ArtAppNotificationTemplateRepository {

	public ArtAppNotificationTemplate findById(String templateId) throws Exception;
}
