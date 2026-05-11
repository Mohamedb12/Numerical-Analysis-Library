package methods.interpolation;
import core.Interpolator;

public class LagrangeMethod implements Interpolator{
  
  private double[] Xvalues;
  private double[] Yvalues;
  
  public LagrangeMethod(double[] Xvalues, double[] Yvalues){
    if(Xvalues.length != Yvalues.length){
      throw new IllegalArgumentException("The two arrays must have the same length");
    }
    this.Xvalues = Xvalues;
    this.Yvalues = Yvalues;
  }
  
  @Override 
  public double interpolate(double targetX){
    int numberOfPoints = Xvalues.length;
    double interpolatedY = 0.0;
    for(int i = 0; i < numberOfPoints; i++){
      double basisPolynomial = 1.0;
      for(int j = 0; j < numberOfPoints; j++){
        if(i != j){
          basisPolynomial = basisPolynomial * (targetX - Xvalues[j]) / (Xvalues[i] - Xvalues[j]);
        }
      }
      interpolatedY = interpolatedY + (basisPolynomial * Yvalues[i]);
      
    }
    return interpolatedY;
  }
  
}
