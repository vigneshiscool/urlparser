/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urlparser;

/**
 * URL Parser
 *
 * @author VigneshPrabhu
 */
public interface IUrlParser {

    /**
     * Gets the input URL and parses it into {@link IUrl} object
     *
     * @param inputURL
     *
     * @return {@link IUrl} object for the parsed URL. Returns null if input is
     * null.
     */
    IUrl parseURL(String inputURL);
}
