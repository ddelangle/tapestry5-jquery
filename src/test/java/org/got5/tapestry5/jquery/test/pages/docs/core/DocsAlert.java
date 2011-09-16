package org.got5.tapestry5.jquery.test.pages.docs.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.alerts.Duration;
import org.apache.tapestry5.alerts.Severity;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.got5.tapestry5.jquery.utils.JQueryTabData;

public class DocsAlert {
	
	public List<JQueryTabData> getListTabData()
	{
		List<JQueryTabData> listTabData = new ArrayList<JQueryTabData>();
        listTabData.add(new JQueryTabData("Example","example")); 
        return listTabData;
    }
	
@Inject
private AlertManager manager;


void onActionFromTransient(){
	manager.alert(Duration.TRANSIENT, Severity.INFO, "INFO TRANSIENT");
	manager.alert(Duration.TRANSIENT, Severity.WARN, "WARN TRANSIENT");
	manager.alert(Duration.TRANSIENT, Severity.ERROR, "ERROR TRANSIENT");
}

void onActionFromSingle(){
	manager.alert(Duration.SINGLE, Severity.INFO, "INFO SINGLE");
	manager.alert(Duration.SINGLE, Severity.WARN, "WARN SINGLE");
	manager.alert(Duration.SINGLE, Severity.ERROR, "ERROR SINGLE");
}

void onActionFromUntilDismiss(){
	manager.alert(Duration.UNTIL_DISMISSED, Severity.INFO, "INFO UNTIL_DISMISSED");
	manager.alert(Duration.UNTIL_DISMISSED, Severity.WARN, "WARN UNTIL_DISMISSED");
	manager.alert(Duration.UNTIL_DISMISSED, Severity.ERROR, "ERROR UNTIL_DISMISSED");
}
	

}
