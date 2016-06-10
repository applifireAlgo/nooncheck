package mygitcheck.app.server.repository.appbasicsetup.usermanagement;
import mygitcheck.app.shared.appbasicsetup.usermanagement.ArtAppNotificationTemplate;



public interface ArtAppNotificationTemplateRepository {

	public ArtAppNotificationTemplate findById(String templateId) throws Exception;
}
