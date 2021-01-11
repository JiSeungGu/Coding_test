	
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
	
public class Point implements Comparable<Point>{

        private int x;
        private int y;
        
        public Point(int x,int y)
        {
        	this.x = x;
        	this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if(this.x > o.x) {
                return 1; // x에 대해서는 오름차순
            }
            else if(this.x == o.x) {
                if(this.y < o.y) { // y에 대해서는 내림차순
                    return 1;
                }
            }
            return -1;
        }
    
    public static void main(String[] args) {
        List<Point> pointList = new ArrayList<>();
        Point first = new Point(9,1);
        Point second = new Point(3,4);
        Point third = new Point(6,5);
        pointList.add(first);
        pointList.add(second);
        pointList.add(third);
        Collections.sort(pointList);
        for(Point i:pointList)
        {
        	System.out.print(i.x);
        	System.out.println(i.y);
        }
    }
}	