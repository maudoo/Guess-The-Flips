import java.text.*;
import java.util.*;
public class Simulation{
  
private int sideOnTop;
private static final int DEFAULT_SIDE_ON_TOP=0;
// heads=0 tails=1
  public Simulation(){
    setSideOnTop(DEFAULT_SIDE_ON_TOP);   
  }    

  public Simulation(int newSideOnTop){
    setSideOnTop(newSideOnTop);
  }
  
  public void setSideOnTop(int newSideOnTop){
    if(newSideOnTop>=0 && newSideOnTop<=1){
      sideOnTop = newSideOnTop;
    }
    else sideOnTop = DEFAULT_SIDE_ON_TOP;
  }
  
  public int getSideOnTop(){
    return sideOnTop;
  }

  public String toString(){
    return "flip = ";   
  }
  
  public int flip(){
    Random random = new Random();
    sideOnTop = random.nextInt(2);
    return sideOnTop;
  }
  
}