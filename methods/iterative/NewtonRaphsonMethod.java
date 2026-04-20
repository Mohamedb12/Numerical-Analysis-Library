package methods.iterative;
import core.RootFinder;
import core.EquationFunction;
import core.dEquationFunction;

public class NewtonRaphsonMethod implements RootFinder{
  private double initial_guess;
  private double tolerance;
  private dEquationFunction df;
  public NewtonRaphsonMethod(double initial_guess, double tolerance, dEquationFunction df){
    this.initial_guess = initial_guess;
    this.tolerance = tolerance;
    this.df = df;
  }
  
  @Override
  public double solve(EquationFunction f){
    
    if(Math.abs(df.evaluate(initial_guess)) < 1e-10){
      throw new IllegalArgumentException("Derivative is zero or too close to zero.");
    }
    double guess = initial_guess - (f.evaluate(initial_guess)/df.evaluate(initial_guess));
    while(Math.abs(guess - initial_guess) > tolerance){
      initial_guess = guess;
      guess = initial_guess - (f.evaluate(initial_guess)/df.evaluate(initial_guess));
      
    }
    return guess;
    
  }
  
}