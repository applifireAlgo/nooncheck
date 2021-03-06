package lastgitcheck.app.shared.appinsight.alarms;
public class LoggingProperties {
	private String attributeComment;

	private String attributeName;

	private String attributeValue;
	
	private String attributeDisplayName;
	
	private String attributeId;

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeComment() {
		return attributeComment;
	}

	public void setAttributeComment(String attributeComment) {
		this.attributeComment = attributeComment;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	public String getAttributeDisplayName() {
		return attributeDisplayName;
	}

	public void setAttributeDisplayName(String attributeDisplayName) {
		this.attributeDisplayName = attributeDisplayName;
	}

	@Override
	public String toString() {
		return "LoggingProperties [attributeComment=" + attributeComment + ", attributeName=" + attributeName + ", attributeValue=" + attributeValue
				+ ", attributeDisplayName=" + attributeDisplayName + ", attributeId=" + attributeId + "]";
	}
}
