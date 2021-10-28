package gradiente;

import static java.lang.Math.pow;

public class HelperAritmetic {
    
    DataSet DS = new DataSet();
    
    double[] x = DS.getMatrizx();
    double[] y = DS.getMatrizy();
    
    double b0 = 0;
    double b1 = 0;
    double a = 0.003;
    double error = 0;
    
    public double CalculateB0(double b0, double b1){
        
        double CalculateB0 = 0;
        
        for(int i = 0; i <= 9-1; i++){
            
            CalculateB0 =+ (y[i] - (b0 + b1 * x[i]));
        
        }//Fin for i
        
        CalculateB0 = -2 * CalculateB0 / 9;
        
        return CalculateB0;
        
    }//Fin public double CalculateB0
    
    public double CalculateB1(double b0, double b1){
        
        double CalculateB1 = 0;
        
        for(int i = 0; i <= 9-1; i++){
            
            CalculateB1 =+ x[i] * (y[i] - (b0 + b1 * x[i]));
        
        }//Fin for i
       
        CalculateB1 = -2 * CalculateB1 / 9;
        
        return CalculateB1;
        
    }//Fin public double CalculateB1
    
    public double Error(double b0, double b1){
        
        double Error = 0;
        
        for(int i = 0; i <= 9-1; i++){
            
            Error = pow((y[i] - (b0 + b1 * x[i])), 2);
            
        }//Fin i
        
        Error = 1 * Error / 9;
        
        return Error;
        
    }//Fin public double MeanSquared
    
    public boolean MeanSquared(){
        
        double nb0 = 0;
        double nb1 = 0;
        
        double Error = this.Error(nb0, nb1);
        
        double CalB0;
        double CalB1;
        
        while(Error > a){
            
            CalB0 = this.CalculateB0(nb0, nb1);
            CalB1 = this.CalculateB0(nb0, nb1);
            
            nb0 = nb0 - CalB0 * a;
            nb1 = nb1 - CalB1 * a;
            
            Error = this.Error(nb0, nb1);
            
        }//Fin while
        
        b0 = nb0;
        b1 = nb1;
        error = Error;
        
        return true;
        
    }//Fin public boolean MeanSquared
    
    public double getB0(){
        
        return b0;
        
    }//Fin public double getB0
    
    public double getB1(){
        
        return b1;
        
    }//Fin public double getB1
    
    public double getError(){
        
        return error;
        
    }//Fin public double getError
    
}//Fin public class HelperAritmetic
