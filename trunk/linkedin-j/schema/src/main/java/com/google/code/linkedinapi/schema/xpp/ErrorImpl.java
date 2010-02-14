
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Error;

public class ErrorImpl
    extends BaseSchemaEntity
    implements Error
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7306088000916275288L;
	protected Long status;
    protected Long timestamp;
    protected String errorCode;
    protected String message;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long value) {
        this.status = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("status")) {
        		setStatus(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("timestamp")) {
        		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("error-code")) {
        		setErrorCode(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("message")) {
        		setMessage(XppUtils.getElementValueFromNode(parser));
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "error");
		XppUtils.setElementValueToNode(element, "status", getStatus());
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		XppUtils.setElementValueToNode(element, "error-code", getErrorCode());
		XppUtils.setElementValueToNode(element, "message", getMessage());
		serializer.endTag(null, "error");
	}
}