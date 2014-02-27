/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urlparser;

import java.util.Map;

/**
 * URL structure
 *
 * @author VigneshPrabhu
 */
public interface IUrl {

    String getDomain();

    String getHost();

    String getPath();

    int getPort();

    String getProtocol();

    Map<String, String> getQueries();

    void setDomain(String domain);

    void setHost(String host);

    void setPath(String path);

    void setPort(int port);

    void setProtocol(String protocol);

    void setQueries(Map<String, String> queries);
}
