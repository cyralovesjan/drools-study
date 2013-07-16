package com.drools;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class Runner 
{
	   public static final void main(String[] args) {
	        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	        kbuilder.add(ResourceFactory.newClassPathResource("myrule.drl"), ResourceType.DRL);
	        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
	        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
	        
	        List<User> users = new ArrayList<User>();
	        User user1 = new User("Microsoft", "Bill Gates", "CEO");
	        User user2 = new User("Apple", "Steve Jobs", "President");
	        users.add(user1);
	        users.add(user2);
	        
	        ksession.execute(users);
	        
	    }
}
