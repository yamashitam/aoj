package p1305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	class Node {
		String name;
		List<Node> cons;
		Set<String> members;
		
		public Node(String name) {
			this.name = name;
			this.cons = new ArrayList<Node>();
			this.members = new HashSet<String>();
			this.members.add(this.name);
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.name.equals(((Node)obj).name);
		}
		
		public void updateMembers(Set<String> members){
//			System.out.println(name + " updated" + members.size());
			if(!this.members.addAll(members)) return;
			for(int i = 0; i < this.cons.size(); i++) {
				this.cons.get(i).updateMembers(members);
			}
		}
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			
			Map<String, Node> nodes = new HashMap<String, Node>();
			List<String> groups = new ArrayList<String>();
			
			Node start = null;
			for(int i = 0; i < n; i++) {
				String str = sc.next();
				String[] _str = str.split(":");
				
				String group = _str[0];
				groups.add(group);
				
				Node node = null;
				if(nodes.containsKey(group)){
					node = nodes.get(group);
				}
				else {
//					System.out.println(group + " created");
					node = new Node(group);
					nodes.put(group, node);
				}
				
				if(i==0)start = node;
				String[] member = (_str[1].substring(0, _str[1].length()-1)).split(",");
				for(int j = 0; j < member.length; j++) {
//					System.out.println(member[j]);
					if(nodes.containsKey(member[j])){
						Node m = nodes.get(member[j]);
						m.cons.add(node);
						node.updateMembers(m.members);
					}
					else {
//						System.out.println(member[j] + " created");
						Node m = new Node(member[j]);
						nodes.put(member[j], m);
						m.cons.add(node);
						Set<String> _s = (new HashSet<String>());
						_s.add(member[j]);
						node.updateMembers(_s);
					}
				}
			}
			int answer = 0;
			for(String s : start.members) {
				if(!groups.contains(s))answer++;
			}
			System.out.println(answer);
		}
	}

	public static void main(String[] args) {
		(new Main()).run();
	}

}
