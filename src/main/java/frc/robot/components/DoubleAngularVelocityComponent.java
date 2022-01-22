package frc.robot.components;

public class DoubleAngularVelocityComponent implements AngularVelocityComponent{
    private AngularVelocityComponent m1;
    private AngularVelocityComponent m2;
    public DoubleAngularVelocityComponent(AngularVelocityComponent motor1, AngularVelocityComponent motor2){
        m1 = motor1;
        m2 = motor2;
    }

    public void setAngularVelocity(double angularVelocity){
        m1.setAngularVelocity(angularVelocity);
        m2.setAngularVelocity(angularVelocity);
    }

    public double getAngularVelocity(){
        return m1.getAngularVelocity();
    }
}
