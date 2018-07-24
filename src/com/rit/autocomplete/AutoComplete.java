package com.rit.autocomplete;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AutoComplete {

	private TrieNode root = new TrieNode();

	public AutoComplete(List<String> wordlist) {
		// TODO Auto-generated constructor stub
		for (String word : wordlist) {
			root.addWord(word);
		}

	}

//	boolean hasWord(String word, boolean exactMatch) {
//
//		return root.hasWord(word, exactMatch);
//	}

	public List<String> getSuffix(String searchPrefix) {
		List<String> list = new ArrayList<>();
		root.listSuffix(searchPrefix, list);
		return list;

	}
}




//Class TrieNode 

class TrieNode {
	private String prefix = "";
	private Map<String, TrieNode> children = new TreeMap<String, TrieNode>();
	private boolean terminates;

	public boolean terminates() {
		return terminates;
	}

	private void terminate() {
		this.terminates = true;
	}

	public TrieNode(String nodechild) {
		// TODO Auto-generated constructor stub
		prefix = nodechild;
	}

	public TrieNode() {
	}

	private TrieNode getChild(String child) {
		return children.get(child);
	}

	void addWord(String word) {
		if (word == null) {
			throw new RuntimeException("cant add empty");
		}
		TrieNode child = getChild(prefix + word.substring(0, 1));
		if (child == null) {

			child = new TrieNode(prefix + word.substring(0, 1));
			// System.out.println("Adding key"+prefix+word.substring(0,1));
			children.put(prefix + word.substring(0, 1), child);
		}
		if (word.length() > 1) {
			child.addWord(word.substring(1));
		} else {

			child.terminate();
		}

	}

//	boolean hasWord(String word, boolean exactMatch) {
//		if (word == null || word.length() == 0) {
//			return !exactMatch | terminates();
//		}
//		TrieNode firstchild = children.get(prefix + word.substring(0, 1));
//		if (firstchild != null) {
//			return firstchild.hasWord(word.substring(1), exactMatch);
//		} else if (word.length() > 0) {
//			return false;
//		} else {
//
//			return !exactMatch | terminates();
//		}
//
//	}

	public void listSuffix(String searchPrefix, List<String> suffixList) {

		if (terminates) {
			suffixList.add(prefix);
			if (children.size() == 0) {
				return;
			}
		}

		// TrieNode node;
		for (String str : children.keySet()) {
			String tmpsearchprefix = searchPrefix;
			if (str.length() < searchPrefix.length()) {
				tmpsearchprefix = searchPrefix.substring(0, str.length());

			}
			if (str.startsWith(tmpsearchprefix)) {
				TrieNode childNode = children.get(str);
				childNode.listSuffix(searchPrefix, suffixList);

			}
		}

	}

}