package com.sankoudai.java.api.jndi;

import junit.framework.TestCase;

import javax.naming.*;
import java.util.Hashtable;


public class FSJDNITest extends TestCase {
    public void testList() throws NamingException {
        // Create the initial context.  The environment information specifies the JNDI provider to use
        // and the initial URL to use (in our case, a directory in URL form -- file:///...).
        Hashtable<String, String> hashtableEnvironment = new Hashtable();
        hashtableEnvironment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        hashtableEnvironment.put(Context.PROVIDER_URL, "file:///E:/sankoudai/sql");
        Context context = new InitialContext(hashtableEnvironment);
        NamingEnumeration namingenumeration = context.listBindings("");
        while (namingenumeration.hasMore()) {
            Binding binding = (Binding) namingenumeration.next();
            System.out.println(binding.getName() + " " + binding.getObject());
        }
    }

    public void testLookup() throws NamingException {
        // Create the initial context.  The environment information specifies the JNDI provider to use
        // and the initial URL to use (in our case, a directory in URL form -- file:///...).
        Hashtable<String, String> hashtableEnvironment = new Hashtable();
        hashtableEnvironment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        hashtableEnvironment.put(Context.PROVIDER_URL, "file:///E:/sankoudai/sql");
        Context context = new InitialContext(hashtableEnvironment);

        Object object = context.lookup("mysql.sql");
        System.out.println("mysql.sql" + " " + object);
    }

}
