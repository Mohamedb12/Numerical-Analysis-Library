package methods.integration;
import core.Integrator;
import core.EquationFunction;
public class TrapezoidalMethod implements Integrator{
  private double startpoint;
  private double endpoint;
  private double segement_width;
  
  public TrapezoidalMethod(double startpoint, double endpoint, double segement_width){
    this.startpoint = startpoint;
    this.endpoint = endpoint;
    this.segement_width = segement_width;
  }
  
  @Override
  public double integrate(EquationFunction f){
    
    int segement_number = (int) ((endpoint - startpoint)/segement_width);
    double storage = 0.0;
    for(int i = 1; i < segement_number; i++){
      storage = storage + f.evaluate(startpoint + i * segement_width);
    }
    double I = segement_width/2.0*(f.evaluate(startpoint) + 2*storage + f.evaluate(endpoint));
    return I;
  }
  
  
}