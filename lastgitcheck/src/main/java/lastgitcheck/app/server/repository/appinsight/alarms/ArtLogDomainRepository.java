package lastgitcheck.app.server.repository.appinsight.alarms;
import lastgitcheck.app.shared.appinsight.alarms.ArtLogBoundedContext;

import lastgitcheck.app.shared.appinsight.alarms.ArtLogDomain;

import java.util.List;
public interface ArtLogDomainRepository {

	public List<ArtLogDomain> findByArtLogBoundedContext(ArtLogBoundedContext artLogBoundedContext);

	public ArtLogDomain findById(String getdomainPkId);
	
	public void save(ArtLogDomain awsLogDomain);

	public void update(ArtLogDomain awsLogDomain);

}
