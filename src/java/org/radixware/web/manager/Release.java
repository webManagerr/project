package org.radixware.web.manager;

public interface Release extends Node{
	
	public String getVersion();
    public String getPrevReleaseVersion();
    public String getStatus();
}
