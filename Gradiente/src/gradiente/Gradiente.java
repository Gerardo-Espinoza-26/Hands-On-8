package gradiente;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Gradiente extends Agent{
    
    DataSet DS = new DataSet();
    HelperAritmetic HA = new HelperAritmetic();
    
    double aux[] = DS.getMatrizx();
    double auy[] = DS.getMatrizx();
    
    double b0 = HA.b0;
    double b1 = HA.b1;
    double a = HA.a;
    
    public double Error(){
        
        double beta0 = HA.CalculateB0(aux, auy, b0, b1);
        double beta1 = HA.CalculateB1(aux, auy, b0, b1);
        double Error = HA.MeanSquared(aux, auy, beta0, beta1);
        
        for(int i = 0; i < 9; i++){
            
            Double Error1 =+ (-(1 / 9) * (auy[i] - (beta0 + (beta1 * aux[i]))));
            
        }//Fin i
        
        double newb0 = b0 - a * beta0;
        double newb1 = b1 - a * beta1;
        
        return Error;
        
    }//Fin for
    
    @Override
    protected void setup(){
        
        System.out.println("Agent " + getLocalName() + " Started.");
        addBehaviour(new MyOneShotBehaviour());
        
    }//Fin protected void setup
    
    private class MyOneShotBehaviour extends OneShotBehaviour{
        
        @Override
        public void action(){
            
            Gradiente GR = new Gradiente();
            
            System.out.println("Tecnica De Gradiante: " + GR.Error());
            
        }//Fin public void action
    
        @Override
        public int onEnd(){
            
            myAgent.doDelete();
            return super.onEnd();
            
        }//Fin public int onDelete
        
    }//Fin private class MyOneShotBehaviour
    
}//Fin public class Gradiente