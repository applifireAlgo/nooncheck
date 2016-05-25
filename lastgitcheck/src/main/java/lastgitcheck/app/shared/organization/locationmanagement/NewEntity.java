package lastgitcheck.app.shared.organization.locationmanagement;
import com.athena.server.pluggable.interfaces.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import lastgitcheck.app.config.annotation.Complexity;
import lastgitcheck.app.config.annotation.SourceCodeAuthorClass;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import javax.persistence.Embedded;
import lastgitcheck.app.shared.EntityAudit;
import lastgitcheck.app.shared.SystemInfo;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_NewEntity_M")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "NewEntity", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "NewEntity.findById", query = "select e from NewEntity e where e.systemInfo.activeStatus=1 and e.entityId =:entityId") })
public class NewEntity implements Serializable, CommonEntityInterface, Comparator<NewEntity> {

    @Column(name = "entityname")
    @JsonProperty("entityname")
    @NotNull
    @Size(min = 1, max = 256)
    private String entityname;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "entityId")
    @JsonProperty("entityId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String entityId;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getEntityname() {
        return entityname;
    }

    public void setEntityname(String _entityname) {
        if (_entityname != null) {
            this.entityname = _entityname;
        }
    }

    public String getPrimaryKey() {
        return entityId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return entityId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String _entityId) {
        this.entityId = _entityId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
            this.systemInfo.setEntityValidated(true);
        } else {
            throw new java.lang.SecurityException();
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(NewEntity object1, NewEntity object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (entityId == null) {
            return super.hashCode();
        } else {
            return entityId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            lastgitcheck.app.shared.organization.locationmanagement.NewEntity other = (lastgitcheck.app.shared.organization.locationmanagement.NewEntity) obj;
            if (entityId == null) {
                return false;
            } else if (!entityId.equals(other.entityId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }
}
