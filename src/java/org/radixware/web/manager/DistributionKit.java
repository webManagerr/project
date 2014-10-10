package org.radixware.web.manager;

import java.sql.Timestamp;
import java.util.List;

public interface DistributionKit extends Node {
	public String getVersion();
	public Timestamp getCreateTime();
	public String getDescription();
	public List<String> getChangeList();
	public String getPrevVersion();
	public Release getRelease();
	public Scripts getScripts();
}
