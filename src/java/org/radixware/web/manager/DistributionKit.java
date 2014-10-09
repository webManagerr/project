package org.radixware.web.manager;

import java.sql.Timestamp;

public interface DistributionKit extends Node {
	public String getVersion();
	public Timestamp getCreateTime();
	public String getDescription();
	public String getChangeList();
	public String getPrevVersion();
	public Release getRelease();
	public Scripts getScripts();
}
