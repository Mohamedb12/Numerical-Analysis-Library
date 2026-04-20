import core.RootFinder;
import core.EquationFunction;
import core.dEquationFunction;
import core.Integrator;

import methods.bracketing.BisectionMethod;
import methods.bracketing.FalsePositionMethod;
import methods.iterative.FixedPointMethod;
import methods.iterative.NewtonRaphsonMethod;
import methods.integration.TrapezoidalMethod;
import methods.integration.SimpsonOneThirdMethod;
import methods.integration.SimpsonThreeEighthsMethod;

public class Main{
  
  static void print(Object data){
    System.out.println(data);
  }
  
  public static void main(String[] args){
    
    EquationFunction function = new EquationFunction(){
      
      @Override
      public double evaluate (double x){
        return 1.0/(x+1.0) ;
      }
      
    };
    
    /*dEquationFunction df = new dEquationFunction(){
      
      @Override
      public double evaluate(double x){
        return 3*Math.pow(x,2) - 1;
      }
      
    };
    RootFinder solver = new NewtonRaphsonMethod(1.5, 0.00001, df);*/
    Integrator solver = new SimpsonThreeEighthsMethod(0, 1, 30);
    double root = solver.integrate(function);
    print(root);
    
  }
}