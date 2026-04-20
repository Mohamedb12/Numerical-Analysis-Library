package methods.iterative;
import core.EquationFunction;
import core.RootFinder;

public class FixedPointMethod implements RootFinder{
  private double initial_guess;
  private double tolerance;
  
  public FixedPointMethod(double initial_guess, double tolerance){
    
    this.initial_guess = initial_guess;
    this.tolerance = tolerance;
    
  }
  
  @Override
  public double solve(EquationFunction f){
    
    double guess = f.evaluate(initial_guess);
    while(Math.abs(guess - initial_guess) > tolerance){
      initial_guess = guess;
      guess = f.evaluate(initial_guess);
    }
    return guess;
    
  }
  
}