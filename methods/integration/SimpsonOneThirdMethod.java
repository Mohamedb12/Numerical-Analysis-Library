package methods.integration;
import core.Integrator;
import core.EquationFunction;

public class SimpsonOneThirdMethod implements Integrator{
  
  private double startpoint;
  private double endpoint;
  private double segement_width;
  
  public SimpsonOneThirdMethod(double startpoint, double endpoint, double segement_width){
    
    this.startpoint = startpoint;
    this.endpoint = endpoint;
    this.segement_width = segement_width;
    
  }
  
  @Override
  public double integrate(EquationFunction f){
    int segement_number = (int) Math.round((endpoint - startpoint)/segement_width);
    double odd_storage = 0.0; double even_storage = 0.0;
    for(int i = 1; i < segement_number; i +=2){
      
      odd_storage += f.evaluate((startpoint + i * segement_width));
    }
    for(int i = 2; i < segement_number; i += 2){
    
      even_storage += f.evaluate((startpoint + i * segement_width));
      
    }
    double result = (segement_width/3.0) * (f.evaluate(startpoint) + 4 * odd_storage + 2 * even_storage + f.evaluate(endpoint));
    return result;
  }
  
}