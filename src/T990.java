import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T990 {
    class Equation implements Comparable<Equation>{
        String equation;

        public Equation(String equation) {
            this.equation = equation;
        }

        @Override
        public int compareTo(Equation o) {
            if(equation.substring(1, 3).equals("==") && o.equation.substring(1, 3).equals("!=")) {
                return -1;
            } else if(equation.substring(1, 3).equals("!=") && o.equation.substring(1, 3).equals("==")) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    class Solution {
        int[] parent;

        public boolean equationsPossible(String[] equations) {
            List<Equation> list = new ArrayList<>();
            for(String equation : equations) {
                list.add(new Equation(equation));
            }
            Collections.sort(list);
            parent = new int[26];
            for(int i = 0; i < 26; i++) {
                parent[i] = i;
            }
            for(Equation equation : list) {
                int x = equation.equation.charAt(0) - 'a';
                int y = equation.equation.charAt(3) - 'a';
                if(equation.equation.substring(1, 3).equals("==")) {
                    if(x != y) {
                        union(x, y);
                    }
                } else {
                    if(findParent(x) == findParent(y)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void union(int x, int y) {
            parent[findParent(x)] = findParent(y);
        }

        public int findParent(int x) {
            int t = x;
            while(parent[t] != t) {
                t = parent[t];
            }
            while(parent[x] != t) {
                int p = parent[x];
                parent[x] = t;
                x = p;
            }
            return t;
        }
    }
}
