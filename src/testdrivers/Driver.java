/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testdrivers;

import urlparser.IUrl;
import urlparser.IUrlParser;
import urlparser.implementation.UrlParser;

/**
 * Driver to test the URL parser application
 *
 * @author VigneshPrabhu
 */
public class Driver {

    public static void main(String[] args) {
        IUrlParser p = new UrlParser();

        // List of URLs tested. Modify the String array to add new URL.
        String[] URLList = {"https://www.google.com:8080/maps/india/bangalore/vig.txt?user=vignesh&user1=vig&user2=sami",
            "http://www.stackoverflow.com/questions/360748/computational-complexity-of-fibonacci-sequence",
            "www2.cox.com",
            "svn://svn.code.sf.net/p/quadriga/code/trunk",
            "https://koding.com/#!/Teamwork",
            null};

        // Parse each URL
        for (String currentURL : URLList) {
            IUrl parsedURL = p.parseURL(currentURL);
            System.out.println(parsedURL);
        }
    }
}
