package methods.bracketing;
import core.RootFinder;
import core.EquationFunction;

public class FalsePositionMethod implements RootFinder{
  
  private double lowerbound;
  private double upperbound;
  private double tolerance;
  
  public FalsePositionMethod(double lowerbound, double upperbound, double tolerance){
    this.lowerbound = lowerbound;
    this.upperbound = upperbound;
    this.tolerance = tolerance;
  }
  
  @Override
  public double solve(EquationFunction f){
    double MidPoint = (lowerbound * f.evaluate(upperbound) - upperbound * f.evaluate(lowerbound))/(f.evaluate(upperbound) - f.evaluate(lowerbound));
    
    while(Math.abs(f.evaluate(MidPoint)) > tolerance){
      
      if(f.evaluate(lowerbound) * f.evaluate(MidPoint) < 0)
        upperbound = MidPoint;
      else
      lowerbound = MidPoint;
      
      MidPoint = (lowerbound * f.evaluate(upperbound) - upperbound * f.evaluate(lowerbound))/(f.evaluate(upperbound) - f.evaluate(lowerbound));
    }
    return MidPoint;
  }
  
}