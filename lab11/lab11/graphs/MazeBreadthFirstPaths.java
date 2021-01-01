package lab11.graphs;

import java.util.*;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
   /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        // Add more variables here!
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
     /*
     *
        marked[v] = true;
        announce();

        if (v == t) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }

        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                dfs(w);
                if (targetFound) {
                    return;
                }
            }
        }
     * */
       Queue<Integer> queue = new ArrayDeque<>();
       announce();
       queue.add(s);
       marked[s] = true;

       if (s == t) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }
       while (!queue.isEmpty()){
           int v = queue.remove();
           for(int w: maze.adj(v)) {
               if (!marked[w]) {
                   queue.add(w);
                   announce();
                   marked[w] = true;
                   distTo[w] = distTo[v] + 1;
                   edgeTo[w] = v;
                   if (v == t) {
                       targetFound = true;
                   }

                   if (targetFound) {
                       return;
                   }
               }
           }
       }

    }


    @Override
    public void solve() {
         bfs();
    }
}

