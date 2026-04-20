package methods.bracketing;
import core.RootFinder;
import core.EquationFunction;

public class BisectionMethod implements RootFinder{
  private double lowerbound;
  private double upperbound;
  private double tolerance;
  public BisectionMethod(double lowerbound, double upperbound, double tolerance){
    this.lowerbound = lowerbound;
    this.upperbound = upperbound;
    this.tolerance = tolerance;
  }
  @Override
  public double solve(EquationFunction f){
  if((f.evaluate(lowerbound) * f.evaluate(upperbound)) < 0){
    double MidPoint = (lowerbound + upperbound)/2;
    while(Math.abs(f.evaluate(MidPoint)) > tolerance){
    if((f.evaluate(lowerbound) * f.evaluate(MidPoint)) < 0){
      upperbound = MidPoint;
    }
    else{
      lowerbound = MidPoint;
    }
    MidPoint = (lowerbound + upperbound)/2;
    }
    return MidPoint;
  }
  else {
    throw new IllegalArgumentException("There's no roots between the intervals");
  }
  }
  
}