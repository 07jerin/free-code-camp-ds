package com.jerin.test.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.jerin.others.ds.trie.OthersTestSuite;
import com.jerin.programiz.ds.tree.TreeSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TreeSuite.class, 
	OthersTestSuite.class
})
public class MainSuite {

}

