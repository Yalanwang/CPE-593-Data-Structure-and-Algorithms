import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Trie {
	private class Node{
		public Node[] next;
		public boolean isWord;
		public Node() {
			this.next = null;
			this.isWord = false;
		}
	}
	Node root;
	
	public void insert(String s) {
		if (root == null) {
			root = new Node();
//			System.out.println("check code");
		}
		Node p = root;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i)-97;
			if (p.next == null) {
				p.next = new Node[26];
//				System.out.print("check code");
			}
			if (p.next[index] == null) {
				p.next[index] = new Node();
			}
			p = p.next[index];
		}
		p.isWord = true;
	}
	
	public boolean contain (String word) {
		Node p = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 97;
			if (p.next[index] == null) {
				return false;
			}
			p = p.next[index];
		}
		return p.isWord;
	}
	
	public boolean containPrefix (String word) {
		Node p = root;
		for(int i = 0; i < word.length();i++) {
			int index = word.charAt(i) - 97;
			if (p.next[index] == null) {
				return false;
			}
			p = p.next[index];
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		
////		check insert and contain
//		trie.insert("abc");
//		System.out.print(trie.contain("abc"));
//		
		try {
//			BufferedReader reader = new BufferedReader(new FileReader("F:\\2017 fall third semester\\CPE 593\\week6\\dict.txt"));
			BufferedReader reader = new BufferedReader(new FileReader("dict.txt"));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				trie.insert(line);
			}
			reader.close();
//			BufferedReader reader2 = new BufferedReader(new FileReader("F:\\2017 fall third semester\\CPE 593\\week6\\hw5.txt"));
			BufferedReader reader2 = new BufferedReader(new FileReader("hw5.txt"));
			String word = null;			
			while ((word = reader2.readLine()) != null) {
				System.out.println(trie.contain(word));
			}
			reader2.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
