/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urlparser.implementation;

import java.util.Map;
import urlparser.IUrl;

/**
 * {@inheritDoc}
 */
public class Url implements IUrl {

    private String protocol, host, path, domain;
    private Integer port;
    private Map<String, String> queries;

    public Url() {
    }

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Url(String protocol, String host, String path, int port, Map queries) {
        this.protocol = protocol;
        this.host = host;
        this.path = path;
        this.port = port;
        this.queries = queries;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public Map<String, String> getQueries() {
        return queries;
    }

    @Override
    public void setQueries(Map<String, String> queries) {
        this.queries = queries;
    }

    @Override
    public String toString() {
        StringBuilder urlString = new StringBuilder("");

        urlString.append("URL Information \n\n");
        urlString.append("Protocol - ").append(this.protocol).append(" \n");
        urlString.append("Domain - ").append(this.domain).append(" \n");
        urlString.append("Port - ").append(this.port).append(" \n");
        urlString.append("Path - ").append(this.path).append(" \n");
        if (this.getQueries() != null) {
            urlString.append("Queries: \n");

            for (String key : this.queries.keySet()) {
                urlString.append(key).append(" = ").append(this.queries.get(key)).append(" \n");
            }
        }
        return urlString.toString();
    }
}
