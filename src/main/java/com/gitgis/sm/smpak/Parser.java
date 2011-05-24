/**
 * 
 */
package com.gitgis.sm.smpak;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * @author gg
 *
 */
public interface Parser {

	public InputStream getInputStream(String entryName) throws IOException, SmParException;
	public Collection<String> getFileEntryNames() throws IOException, SmParException;

}
