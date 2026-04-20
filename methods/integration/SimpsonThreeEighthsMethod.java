package methods.integration;
import core.Integrator;
import core.EquationFunction;

public class SimpsonThreeEighthsMethod implements Integrator{
  
  private double startpoint;
  private double endpoint;
  private int segmenet_number;
  
  public SimpsonThreeEighthsMethod(double startpoint, double endpoint, int segmenet_number){
    this.startpoint = startpoint;
    this.endpoint = endpoint;
    this.segmenet_number = segmenet_number;
  }
  
  @Override
  public double integrate(EquationFunction f){
    double segmenet_width = (endpoint - startpoint)/segmenet_number;
    double storage = 0.0;
    for(int i = 1; i < segmenet_number; i++){
      if(i % 3 == 0)
        storage += 2 * f.evaluate((startpoint + i * segmenet_width));
      else
        storage += 3 * f.evaluate((startpoint + i * segmenet_width));
    }
    double result = ((3 * segmenet_width)/8) * (f.evaluate(startpoint) + storage + f.evaluate(endpoint));
    return result;
  }
  
}