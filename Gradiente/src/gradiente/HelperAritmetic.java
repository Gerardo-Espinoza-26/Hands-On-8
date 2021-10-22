package gradiente;

public class HelperAritmetic {
    
    double b0 = 0;
    double b1 = 0;
    double a = 0.003;
    
    public double CalculateB0(double aux[], double auy[], double b0, double b1){
        
        double CalculateB0 = 0;
        
        for(int i = 0; i < 9; i++){
            
            CalculateB0 =+ (-(2 / 9) * (auy[i] - (b0 + (b1 * aux[i]))));
        
        }//Fin for i
        
        return CalculateB0;
        
    }//Fin public double CalculateB0
    
    public double CalculateB1(double aux[], double auy[], double b0, double b1){
        
        double CalculateB1 = 0;
        
        for(int i = 0; i < 9; i++){
            
            CalculateB1 =+ ((-(2 / 9)) * aux[i]) * (auy[i] - (b0 - (b1 * aux[i])));
        
        }//Fin for i
        
        return CalculateB1;
        
    }//Fin public double CalculateB1
    
    public double MeanSquared(double aux[], double auy[], double b0, double b1){
        
        double MeanSquared = 0;
        
        for(int i = 0; i < 9; i++){
            
            MeanSquared =+ 1 / 9 * (Math.pow(((auy[i] - (b0 - (b1 * aux[i])))), 2));
            
        }//Fin i
        
        return MeanSquared;
        
    }//Fin public double MeanSquared
    
}//Fin public class HelperAritmetic
