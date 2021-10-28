package gradiente;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import javax.swing.JOptionPane;

public class Gradiente extends Agent{
    
    HelperAritmetic HA = new HelperAritmetic();
    
    boolean Metalera = HA.MeanSquared();
    double b0 = HA.getB0();
    double b1 = HA.getB1();
    
    public void displayGradienteEquation(){
        
        System.out.println("                               ┌                ┐");
        System.out.println("                               │ a/aB0 ƒ(B0,B1) │");
        System.out.println("Gradient Equation ▼ƒ(B0, B1) =│                │");
        System.out.println("                               │ a/aB1 ƒ(B0,B1) │");
        System.out.println("                               └                ┘");
        
    }//Fin public void displayRegressioEquation
    
    public void Error(){
        
        System.out.println("Error: " + String.format("%.7f", HA.getError()));
        
    }//Fin public void Error
    
    public double predict(){
        
        double valor = Float.parseFloat(JOptionPane.showInputDialog("Ingresa El Valor a Predecir"));
        
        double predict = b0 + b1 * valor;
        
        System.out.println("Predict: " + predict);
        
        return predict;
        
    }//Fin public float predict
    
    @Override
    protected void setup(){
        
        System.out.println("Agent " + getLocalName() + " Started.");
        addBehaviour(new MyOneShotBehaviour());
        
    }//Fin protected void setup
    
    private class MyOneShotBehaviour extends OneShotBehaviour{
        
        @Override
        public void action(){
            
            Gradiente GR = new Gradiente();
            
            GR.displayGradienteEquation();
            GR.Error();
            GR.predict();
            
        }//Fin public void action
    
        @Override
        public int onEnd(){
            
            myAgent.doDelete();
            return super.onEnd();
            
        }//Fin public int onDelete
        
    }//Fin private class MyOneShotBehaviour
    
}//Fin public class Gradiente