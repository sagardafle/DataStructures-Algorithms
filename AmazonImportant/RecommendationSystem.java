import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class RecommendationSystem
{
	private final Map<Integer, Node> sets = new HashMap<>();

	public void add(int value)
	{
		if (sets.containsKey(value))
			return;
		sets.put(value, new Node(value));
	}

	public Node find(int value)
	{
		Node node = sets.get(value);
		if (node == null)
			return null;
		
		if (node != node.parent)
		{
			node.parent = find(node.parent.value);
			return node.parent;
		}
		return node;
	}

	public Node union(int val1, int val2)
	{
		Node node1 = find(val1);
		Node node2 = find(val2);
		
		if (node1 == null || node2 == null)
			return null;

		Node result = null;
		if (node1.rank > node2.rank)
		{
			node2.parent = node1;
			node1.rank++;
			result = node1;
		}
		else
		{
			node1.parent = node2;
			node2.rank++;
			result = node2;;
		}
		
		return result;
	}
	
	public int countSets()
	{
		int count = 0;
		for (Entry<Integer, Node> entry : sets.entrySet())
		{
			if (entry.getValue().parent == entry.getValue())
				count++;
		}
		return count;
	}
	
	public List<Set<Integer>> getSets()
	{
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (Entry<Integer, Node> entry : sets.entrySet())
		{
			Node n = find(entry.getValue().value);
			Set<Integer> set = map.get(n.value);
			if (set == null)
			{
				set = new HashSet<>();
				map.put(n.value, set);
			}
			set.add(entry.getValue().value);
		}
		return map.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
	}

	private class Node
	{
		private final int value;
		private Node parent;
		private int rank;

		public Node(int value)
		{
			this.value = value;
			parent = this;
		}
	}
	
	public static void main(String[] args)
	{
		RecommendationSystem disjointSets = new RecommendationSystem();
		
		disjointSets.add(1);
		disjointSets.add(2);
		disjointSets.add(3);
		disjointSets.add(4);
		disjointSets.add(5);
		disjointSets.add(6);
		
		disjointSets.union(1, 2);
		disjointSets.union(2, 3);
		disjointSets.union(2, 4);
		disjointSets.union(5, 6);
		
		System.out.println(disjointSets.countSets());
		System.out.println(disjointSets.getSets());
	}

}