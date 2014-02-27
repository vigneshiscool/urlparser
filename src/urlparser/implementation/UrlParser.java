/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urlparser.implementation;

import java.util.HashMap;
import java.util.Map;
import urlparser.IUrl;
import urlparser.IUrlParser;

/**
 *
 * @author VigneshPrabhu
 */
public class UrlParser implements IUrlParser {

    /**
     * {@inheritDoc}
     */
    @Override
    public IUrl parseURL(String inputURL) {
        IUrl myURL = null;
        if (inputURL != null) {
            myURL = new Url();

            // check if protocol is present in Url
            String[] protocolSplit;
            String remainingPath = "";
            if (isProtocolPresent(inputURL)) {
                protocolSplit = parseProtocol(inputURL);
                myURL.setProtocol(protocolSplit[0]);
                remainingPath = protocolSplit[1];
            } else {
                remainingPath = inputURL;
            }

            // check if path is present in Url
            String[] domainSplit;
            if (isPathPresent(remainingPath)) {
                domainSplit = parseDomain(remainingPath, true);
            } else {
                domainSplit = parseDomain(remainingPath, false);
            }

            // check if port is present in Url
            if (isPortPresent(domainSplit[0])) {
                String[] portSplit = parsePort(domainSplit[0]);
                myURL.setDomain(portSplit[0]);
                myURL.setPort(Integer.parseInt(portSplit[1]));
            } else {
                myURL.setDomain(domainSplit[0]);
            }

            String pathAfterDomain = "";
            pathAfterDomain = remainingPath.replace(domainSplit[0], "");
            String[] pathSplit = parsePath(pathAfterDomain);
            myURL.setPath(pathSplit[0]);

            // check if query is present in Url
            if (isQueryPresent(pathSplit)) {
                Map<String, String> queries = parsequeries(pathSplit[1]);
                myURL.setQueries(queries);
            }
        }
        return myURL;

    }

    private String[] parseProtocol(String inputURL) {
        String[] protocolSplit;

        protocolSplit = inputURL.split("://");
        return protocolSplit;
    }

    private String[] parseDomain(String string, boolean pathFound) {

        String[] domainSplit;
        if (pathFound) {
            domainSplit = string.split("/");
        } else {
            domainSplit = string.split("\\?");
        }

        return domainSplit;
    }

    private String[] parsePort(String string) {
        String[] portSplit = string.split(":");
        return portSplit;
    }

    private String[] parsePath(String pathAfterport) {
        String[] pathSplit = pathAfterport.split("\\?");
        return pathSplit;
    }

    private Map parsequeries(String string) {
        Map<String, String> queries = new HashMap<String, String>();

        String[] queryStrings = string.split("&");

        for (String currentQuery : queryStrings) {
            String[] keyValue = currentQuery.split("=");
            queries.put(keyValue[0], keyValue[1]);
        }

        return queries;
    }

    private boolean isProtocolPresent(String inputURL) {
        if (inputURL.contains("://")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPathPresent(String input) {
        if (input.contains("/")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPortPresent(String input) {
        if (input.contains(":")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isQueryPresent(String[] input) {
        if (input.length > 1) {
            return true;
        } else {
            return false;
        }
    }
}
